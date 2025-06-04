package com.buka.service;

import com.buka.http.AppInfo;
import com.buka.mapper.ArrangeMapper;
import com.buka.mapper.CinemaHouseMapper;
import com.buka.mapper.CinemaMapper;
import com.buka.mapper.MovieMapper;
import com.buka.pojo.*;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private CinemaHouseMapper cinemaHouseMapper;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ArrangeMapper arrangeMapper;
    public ResponseJson login(String username, String password, HttpSession httpSession) {
        Movie cinema=cinemaMapper.getCinemaByUserName(username);
        if(cinema!=null){
           if(cinema.getCinemaState()==0){
               return ResponseJson.getError("已被封号");
           }else if(cinema.getCinemaPassword().equals(password)){
                httpSession.setAttribute(AppInfo.SESSION_CINEMA,cinema);
                return ResponseJson.getOK();
            }else{
                return ResponseJson.getError("用户名或密码错误");
            }
        }
        return ResponseJson.getError("用户不存在");
    }

    public ResponseJson addHouse(CinemaHome cinemaHome,HttpSession httpSession) {
        Movie cinema = getPojoBySession(httpSession);
        cinemaHome.setCinemaHomeCinemaId(cinema.getCinemaId());
        int i=cinemaHouseMapper.add(cinemaHome);
        return i>0?ResponseJson.getOK():ResponseJson.getError();
    }
    private Movie getPojoBySession(HttpSession httpSession){
        return (Movie) httpSession.getAttribute(AppInfo.SESSION_CINEMA);
    }

    public ResponseJson getHouseList(HttpSession httpSession) {
        Movie cinema = getPojoBySession(httpSession);
        List<CinemaHome> cinemaHomeList=cinemaHouseMapper.getList(cinema.getCinemaId());
        return ResponseJson.getOK(cinemaHomeList);
    }

    public ResponseJson changeHouseState(int cinemaHomeId, int state) {
        if(state==0||state==1){
            int i=cinemaHouseMapper.changeHouseStateById(cinemaHomeId,state);
            return i>0?ResponseJson.getOK():ResponseJson.getError();
        }
        return ResponseJson.getError();
    }

    public ResponseJson getMovieList() {
        List<Cinema> movieList =movieMapper.getListByState(1);

        return ResponseJson.getOK(movieList);
    }

    public ResponseJson getHouseListByArrange(HttpSession httpSession) {
        Movie cinema = getPojoBySession(httpSession);
        List<CinemaHome> cinemaHomeList=cinemaHouseMapper.getListByState(cinema.getCinemaId(),1);
        return ResponseJson.getOK(cinemaHomeList);
    }

    public ResponseJson addArrange(int movieId, int houseId, Date startTime, int money, HttpSession httpSession) {
        Movie cinema = getPojoBySession(httpSession);
        Cinema movie=movieMapper.getMovieById(movieId);
        long endTime = startTime.getTime()+ (long) movie.getMovieTime() *60*1000;
        Arrange arrange=new Arrange(cinema.getCinemaId(),houseId,movieId,startTime,new Date(endTime),money);
        int i= arrangeMapper.add(arrange);
        return i>0?ResponseJson.getOK():ResponseJson.getError();
    }

    public ResponseJson getArrangeList(HttpSession httpSession) {
        Movie cinema = getPojoBySession(httpSession);
        List<Arrange> arrangeList=arrangeMapper.getListByCinemaId(cinema.getCinemaId());
        return ResponseJson.getOK(arrangeList);
    }
}
