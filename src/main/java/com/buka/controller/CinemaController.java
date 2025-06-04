package com.buka.controller;

import com.buka.pojo.Arrange;
import com.buka.pojo.CinemaHome;
import com.buka.service.CinemaService;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Date;

@Controller
@ResponseBody
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;
    @PostMapping("/login")
    public ResponseJson login(String username, String password, HttpSession httpSession){
        return cinemaService.login(username,password,httpSession);
    }

    @PostMapping("/addhouse")
    public ResponseJson addHouse(CinemaHome cinemaHome,HttpSession httpSession){
        return cinemaService.addHouse(cinemaHome,httpSession);

    }
    @PostMapping("/houselist")
    public ResponseJson getHouseList(HttpSession httpSession){
        return cinemaService.getHouseList(httpSession);
    }

    @PostMapping("/changehousestate")
    public ResponseJson changeHouseState(int cinemaHomeId,int state){
        return cinemaService.changeHouseState(cinemaHomeId,state);
    }
    @PostMapping("/movielist")
    public ResponseJson getMovieList(){
        return cinemaService.getMovieList();
    }
    @PostMapping("/houselistbyarrange")
    public ResponseJson getHouseListByArrange(HttpSession httpSession){
        return cinemaService.getHouseListByArrange(httpSession);
    }

    @PostMapping("/addarrange")
    public ResponseJson addArrange(int movieId, int houseId, @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date startTime, int money, HttpSession httpSession){

        return cinemaService.addArrange(movieId,houseId,startTime,money,httpSession);
    }
    @PostMapping("/arrangelist")
    public ResponseJson getArrangeList(HttpSession httpSession){

        return cinemaService.getArrangeList(httpSession);
    }

}
