package com.buka.service;

import com.buka.http.AppInfo;
import com.buka.mapper.CinemaMapper;
import com.buka.mapper.MovieMapper;
import com.buka.mapper.PlatformMapper;
import com.buka.pojo.Cinema;
import com.buka.pojo.Movie;
import com.buka.pojo.Platform;
import com.buka.pojo.User;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PlatformService {
    @Autowired
    private  PlatformMapper platformMapper;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private CinemaMapper cinemaMapper;
    public ResponseJson regis(String platformName, String password) {
        int i=platformMapper.addUser(new Platform(platformName,password));
        return i>0?ResponseJson.getOK():ResponseJson.getError();
    }

    public ResponseJson login(String name, String password, HttpSession httpSession) {
        Platform platform=platformMapper.getPlatformByPlatformName(name);
        if(platform!=null){
            if(platform.getPlatformPassword().equals(password)){
                httpSession.setAttribute(AppInfo.SESSION_ADMIN,platform);
                return ResponseJson.getOK();
            }else{
                return ResponseJson.getError("用户名或密码错误");
            }
        }
        return ResponseJson.getError("用户不存在");
    }

    public ResponseJson addMovie(String movieName, int movieTime, MultipartFile file) throws IOException {
        String imgName= UUID.randomUUID().toString();
        file.transferTo(new File(AppInfo.MOVIE_IMG_PATH,imgName));
        Cinema movie=new Cinema(movieName,"http://localhost:8080/cinema/down/movie/img/"+imgName,movieTime);
        int i=movieMapper.add(movie);
        return i>0?ResponseJson.getOK():ResponseJson.getError();
    }

    public ResponseJson getMovieList() {
        List<Cinema> movieList=movieMapper.list();
        return ResponseJson.getOK(movieList);
    }
    public static Platform getAdminFromSession(HttpSession httpSession){
        return (Platform) httpSession.getAttribute(AppInfo.SESSION_ADMIN);
    }

    public ResponseJson changeMovieState(int movieId, int state) {

        if(state==0||state==1){
             int i=movieMapper.changeMovieState(movieId,state);
             return i>0?ResponseJson.getOK():ResponseJson.getError();
        }
        return ResponseJson.getError();
    }

    public ResponseJson addCinema(Movie cinema) {
int i=cinemaMapper.add(cinema);
        return i>0?ResponseJson.getOK():ResponseJson.getError();
    }

    public ResponseJson getCinemaList() {
        List<Movie> cinemaList=cinemaMapper.getList();
        return ResponseJson.getOK(cinemaList);
    }

    public ResponseJson changeCinemaState(int cinemaId, int state) {
        if(state==0||state==1){
            int i=cinemaMapper.changeForStateById(cinemaId,state);
            return i>0?ResponseJson.getOK():ResponseJson.getError();
        }

        return ResponseJson.getError();
    }
}
