package com.buka.pojo;

public class Cinema {
    private int movieId;
    private String movieName;
    private int movieTime;
    private int movieState=1;
    private String movieImgUrl;

    public Cinema() {

    }

    public Cinema(String movieName, String movieImgUrl,int movieTime) {
        this.movieName = movieName;
        this.movieTime = movieTime;
        this.movieImgUrl = movieImgUrl;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(int movieTime) {
        this.movieTime = movieTime;
    }

    public String getMovieImgUrl() {
        return movieImgUrl;
    }

    public void setMovieImgUrl(String movieImgUrl) {
        this.movieImgUrl = movieImgUrl;
    }

    public int getMovieState() {
        return movieState;
    }

    public void setMovieState(int movieState) {
        this.movieState = movieState;
    }
}
