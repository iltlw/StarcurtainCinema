package com.buka.controller;

import com.buka.service.UserService;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/regis")
    public ResponseJson regis(String username,String password){
        return userService.regis(username,password);
    }
    @PostMapping("/login")
    public  ResponseJson login(String username, String password, HttpSession httpSession){
        return userService.login(username,password,httpSession);
    }
    @PostMapping("/movielist")
    public  ResponseJson getMovieList(){
        return userService.getMovieList();
    }

    @PostMapping("/arrangelist")
    public ResponseJson getArrangeByMovieId(int movieId){
        return userService.getArrangeByMovieId(movieId);
    }
    @PostMapping("/seatinfo")
    public ResponseJson getSeatInfo(int arrangeId){
        return userService.getSeatInfo(arrangeId);
    }

    @PostMapping("/buy")
    public ResponseJson buy(int arrangeId,String[] seat,HttpSession httpSession) throws Exception {
return userService.buy(arrangeId,seat,httpSession);
    }

    @PostMapping("/paystate")
    public ResponseJson getPayState(int payId){
return userService.getPayState(payId);
    }

    @PostMapping("/notify_url")
    public String notifyUrl(@RequestBody String body) throws Exception {
        userService.updateOrderForNotify(body);
        return "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA]></return_msg>\n" +
                "</xml>";
    }

    @PostMapping("/myorder")
    public ResponseJson getPayOrderList(HttpSession httpSession){

        return userService.getPayOrderList(httpSession);
    }

    @PostMapping("/orderlist")
    public ResponseJson getOrderListByPayId(int payId){
return userService.getOrderListByPayId(payId);
    }

}
