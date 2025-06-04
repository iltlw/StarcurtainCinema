package com.buka.service;

import com.alibaba.fastjson.JSON;
import com.buka.http.AppInfo;
import com.buka.mapper.*;
import com.buka.pojo.*;
import com.buka.util.ResponseJson;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.spi.ResolveResult;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.function.Consumer;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ArrangeMapper arrangeMapper;
    @Autowired
    private CinemaHouseMapper cinemaHouseMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private PayMapper payMapper;
    @Autowired
    private WXPay wxPay;
    public ResponseJson regis(String username, String password) {
        int i=userMapper.addUser(new User(username,password));
        return i>0?ResponseJson.getOK():ResponseJson.getError();
    }

    public ResponseJson login(String username, String password, HttpSession httpSession) {
        User user=userMapper.getUserByUserName(username);
        if(user!=null){
            if(user.getUserPassword().equals(password)){
                httpSession.setAttribute(AppInfo.SESSION_USER,user);
                return ResponseJson.getOK();
            }else{
                return ResponseJson.getError("用户名和密码错误");
            }
        }
        return ResponseJson.getError("用户不存在");
    }

    public ResponseJson getMovieList() {
        Date startTime=new Date(System.currentTimeMillis()+10*60*1000);
        Set<Integer> movieIds=arrangeMapper.getListByStartTimeAfterForMovieIds(startTime);
        List<Cinema> movieList = movieMapper.getMovieByIds(movieIds);
        return ResponseJson.getOK(movieList);
    }
    private User getPojoBySession(HttpSession httpSession){
        return (User) httpSession.getAttribute(AppInfo.SESSION_USER);
    }

    public ResponseJson getArrangeByMovieId(int movieId) {
        Date startTime=new Date(System.currentTimeMillis()+10*60*1000);
        List<Arrange> arrangeList= arrangeMapper.getListByStartTimeAfterAndMovieIds(startTime,movieId);
        return ResponseJson.getOK(arrangeList);
    }

    public ResponseJson getSeatInfo(int arrangeId) {
        Arrange arrange= arrangeMapper.getById(arrangeId);
        CinemaHome cinemaHome= cinemaHouseMapper.getById(arrange.getArrangeCinemaHomeId());
        Integer[][] seatInfo=JSON.parseObject(cinemaHome.getCinemaHomeSeat(),Integer[][].class);
        List<Order> orderList=orderMapper.getListByArrangeId(arrange.getArrangeId());
        orderList.forEach(order -> {
            seatInfo[order.getOrderSeatRow()][order.getOrderSeatCol()]=2;//锁定


        });
        return ResponseJson.getOK(seatInfo);
    }
@Transactional(rollbackFor = Exception.class)
    public ResponseJson buy(int arrangeId, String[] seat, HttpSession httpSession) throws Exception {

        User user = getPojoBySession(httpSession);
        Arrange arrange= arrangeMapper.getById(arrangeId);
        if(arrange==null){
            return ResponseJson.getError();
        }
        Pay pay=new Pay();
        pay.setPayNum(""+System.currentTimeMillis()+user.getUserId());
        pay.setPayUserId(user.getUserId());
        pay.setPayCreateTime(new Date());
        pay.setPayState(1);
        int i=payMapper.add(pay);
        if(i>0){
            for(String s:seat){
                createOrder(arrange,s,user,pay.getPayId());
            }
            Map<String, String> map = new HashMap<>();
            map.put("body", "购票");
            map.put("out_trade_no", pay.getPayNum());
            map.put("total_fee", "1");
            map.put("spbill_create_ip", "127.0.0.1");
            map.put("notify_url", " http://pqmsxs.natappfree.cc/cinema/user/notify_url");
            map.put("trade_type", "NATIVE");
            Map<String, String> resultMap = wxPay.unifiedOrder(map);
            String code_url = resultMap.get("code_url");
            if(code_url!=null){
                resultMap=new HashMap<>();
                resultMap.put("code_url",code_url);
                resultMap.put("payId",String.valueOf(pay.getPayId()));

                return ResponseJson.getOK(resultMap);
            }else{
                System.out.println("===>"+resultMap);
                throw new RuntimeException("支付码生成失败");
            }
        }

        return ResponseJson.getError("支付订单创建失败");
    }
    private Order createOrder(Arrange arrange, String seat, User user, int payId) throws Exception{
        Order order=new Order();
        String orderNum=""+System.currentTimeMillis()+user.getUserId()+arrange.getArrangeId();
        order.setOrderNum(orderNum);
        order.setOrderArrangeId(arrange.getArrangeId());
        order.setOrderCinemaId(arrange.getArrangeCinemaId());
        order.setOrderMovieId(arrange.getArrangeMovieId());
        Integer[] seatArr=JSON.parseObject(seat,Integer[].class);
        order.setOrderSeatRow(seatArr[0]);
        order.setOrderSeatCol(seatArr[1]);
        order.setOrderTime(new Date());
        order.setOrderMoney(arrange.getArrangeMoney());
        order.setOrderState(1);
        order.setOrderPayId(payId);
        Integer i=orderMapper.isLocalByArrangeIdAndSeat(arrange.getArrangeId(),order.getOrderSeatRow(),order.getOrderSeatCol());
        if(i==0){
            synchronized (UserService.class){
                i=orderMapper.add(order);
                if(i<1){
                    throw new RuntimeException("添加数据失败");
                }
                return order;
            }

        }
throw new RuntimeException("座位已被锁定");
    }
    public void updateOrderForNotify(String body) throws Exception {
        Map<String, String> xmlToMap = WXPayUtil.xmlToMap(body);

        if(xmlToMap.get("return_code").equals("SUCCESS")&&xmlToMap.get("result_code").equals("SUCCESS")){
            String payNum =xmlToMap.get("out_trade_no");
            payMapper.payd(payNum,body);
            int payId=payMapper.getIdByNum(payNum);
            orderMapper.payd(payId);
        }

    }

    public ResponseJson getPayState(int payId) {

        int state=payMapper.getStateById(payId);
        return ResponseJson.getOK(state);
    }

    public ResponseJson getPayOrderList(HttpSession httpSession) {
        User user = getPojoBySession(httpSession);
        List<Pay> payList=payMapper.getListByUserId(user.getUserId());
        return ResponseJson.getOK(payList);
    }

    public ResponseJson getOrderListByPayId(int payId) {
      List<Order> orderList=orderMapper.getListByPayId(payId);
        return ResponseJson.getOK(orderList);
    }
}
