package com.buka.controller;

import com.buka.pojo.Cinema;
import com.buka.pojo.Movie;
import com.buka.service.PlatformService;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping("/platform")
public class PlatformController {
    @Autowired
    private PlatformService platformService;
    @PostMapping("/regis")
    public ResponseJson regis(String platformName, String password){
        return platformService.regis(platformName,password);
    }
    @PostMapping("/login")
    public ResponseJson login(String name, String password, HttpSession httpSession){
        return platformService.login(name,password,httpSession);
    }
    @PostMapping("/addmovie")
    public ResponseJson addMovie(String movieName,int movieTime,MultipartFile file) throws IOException {
        return platformService.addMovie(movieName,movieTime,file);
    }
    @PostMapping("/movielist")
    public ResponseJson getMovieList(){
        return platformService.getMovieList();
    }
    @PostMapping("/changemoviestate")
    public ResponseJson changeMovieState(int movieId,int state){
        return platformService.changeMovieState(movieId,state);
    }
    @PostMapping("/addcinema")
    public ResponseJson addCinema(Movie cinema){
        return platformService.addCinema(cinema);
    }
    @PostMapping("/cinemalist")
    public ResponseJson getCinemaList(){
        return platformService.getCinemaList();
    }
    @PostMapping("/changecinemastate")
    public ResponseJson changeCinemaState(int cinemaId,int state){
        return platformService.changeCinemaState(cinemaId,state);
    }


}
