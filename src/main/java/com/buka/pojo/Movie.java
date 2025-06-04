package com.buka.pojo;

public class Movie {
    private int cinemaId;
    private String cinemaName;
    private String cinemaPassword;
    private String cinemaAddress;
    private int cinemaState=1;

    public Movie() {
    }

    public Movie(String cinemaName, String cinemaPassword) {
        this.cinemaName = cinemaName;
        this.cinemaPassword = cinemaPassword;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaPassword() {
        return cinemaPassword;
    }

    public void setCinemaPassword(String cinemaPassword) {
        this.cinemaPassword = cinemaPassword;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public int getCinemaState() {
        return cinemaState;
    }

    public void setCinemaState(int cinemaState) {
        this.cinemaState = cinemaState;
    }
}
