package com.buka.pojo;

import java.util.Date;

public class Arrange {
    private int arrangeId;
    private int arrangeCinemaId;
    private int arrangeCinemaHomeId;
    private int arrangeMovieId;
    private Date arrangeMovieStartTime;
    private Date arrangeMovieEndTime;
    private int arrangeMoney;
    private int arrangeState=1;

    private Cinema movie;
    private CinemaHome cinemaHome;

    public Cinema getMovie() {
        return movie;
    }

    public void setMovie(Cinema movie) {
        this.movie = movie;
    }

    public CinemaHome getCinemaHome() {
        return cinemaHome;
    }

    public void setCinemaHome(CinemaHome cinemaHome) {
        this.cinemaHome = cinemaHome;
    }

    public Arrange() {
    }

    public Arrange(int arrangeCinemaId, int arrangeCinemaHomeId, int arrangeMovieId, Date arrangeMovieStartTime, Date arrangeMovieEndTime, int arrangeMoney) {
        this.arrangeCinemaId = arrangeCinemaId;
        this.arrangeCinemaHomeId = arrangeCinemaHomeId;
        this.arrangeMovieId = arrangeMovieId;
        this.arrangeMovieStartTime = arrangeMovieStartTime;
        this.arrangeMovieEndTime = arrangeMovieEndTime;
        this.arrangeMoney = arrangeMoney;
    }

    public int getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(int arrangeId) {
        this.arrangeId = arrangeId;
    }

    public int getArrangeCinemaId() {
        return arrangeCinemaId;
    }

    public void setArrangeCinemaId(int arrangeCinemaId) {
        this.arrangeCinemaId = arrangeCinemaId;
    }

    public int getArrangeCinemaHomeId() {
        return arrangeCinemaHomeId;
    }

    public void setArrangeCinemaHomeId(int arrangeCinemaHomeId) {
        this.arrangeCinemaHomeId = arrangeCinemaHomeId;
    }

    public int getArrangeMovieId() {
        return arrangeMovieId;
    }

    public void setArrangeMovieId(int arrangeMovieId) {
        this.arrangeMovieId = arrangeMovieId;
    }

    public Date getArrangeMovieStartTime() {
        return arrangeMovieStartTime;
    }

    public void setArrangeMovieStartTime(Date arrangeMovieStartTime) {
        this.arrangeMovieStartTime = arrangeMovieStartTime;
    }

    public Date getArrangeMovieEndTime() {
        return arrangeMovieEndTime;
    }

    public void setArrangeMovieEndTime(Date arrangeMovieEndTime) {
        this.arrangeMovieEndTime = arrangeMovieEndTime;
    }

    public int getArrangeMoney() {
        return arrangeMoney;
    }

    public void setArrangeMoney(int arrangeMoney) {
        this.arrangeMoney = arrangeMoney;
    }

    public int getArrangeState() {
        return arrangeState;
    }

    public void setArrangeState(int arrangeState) {
        this.arrangeState = arrangeState;
    }
}
