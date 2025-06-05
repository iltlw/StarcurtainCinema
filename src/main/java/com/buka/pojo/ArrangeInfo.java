package com.buka.pojo;

import java.util.Date;

public class ArrangeInfo {
    private int arrangeId;
    private String arrangeCinemaName;
    private int arrangeCinemaHomeName;
    private int arrangeMovieName;
    private Date arrangeMovieStartTime;
    private Date arrangeMovieEndTime;
    private int arrangeMoney;
    private int arrangeState=1;

    public int getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(int arrangeId) {
        this.arrangeId = arrangeId;
    }

    public String getArrangeCinemaName() {
        return arrangeCinemaName;
    }

    public void setArrangeCinemaName(String arrangeCinemaName) {
        this.arrangeCinemaName = arrangeCinemaName;
    }

    public int getArrangeCinemaHomeName() {
        return arrangeCinemaHomeName;
    }

    public void setArrangeCinemaHomeName(int arrangeCinemaHomeName) {
        this.arrangeCinemaHomeName = arrangeCinemaHomeName;
    }

    public int getArrangeMovieName() {
        return arrangeMovieName;
    }

    public void setArrangeMovieName(int arrangeMovieName) {
        this.arrangeMovieName = arrangeMovieName;
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
