package com.buka.pojo;

import java.util.Date;

public class Order {
    private int orderId;
    private String orderNum;
    private int orderArrangeId;
    private int orderCinemaId;
    private int orderMovieId;
    private int orderSeatRow;
    private int orderSeatCol;
    private Date orderTime;
    private int orderMoney;
    private int orderState;
    private int orderPayId;
private  Arrange arrange;
    public int getOrderPayId() {
        return orderPayId;
    }

    public Arrange getArrange() {
        return arrange;
    }

    public void setArrange(Arrange arrange) {
        this.arrange = arrange;
    }

    public void setOrderPayId(int orderPayId) {
        this.orderPayId = orderPayId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int getOrderArrangeId() {
        return orderArrangeId;
    }

    public void setOrderArrangeId(int orderArrangeId) {
        this.orderArrangeId = orderArrangeId;
    }

    public int getOrderCinemaId() {
        return orderCinemaId;
    }

    public void setOrderCinemaId(int orderCinemaId) {
        this.orderCinemaId = orderCinemaId;
    }

    public int getOrderMovieId() {
        return orderMovieId;
    }

    public void setOrderMovieId(int orderMovieId) {
        this.orderMovieId = orderMovieId;
    }

    public int getOrderSeatRow() {
        return orderSeatRow;
    }

    public void setOrderSeatRow(int orderSeatRow) {
        this.orderSeatRow = orderSeatRow;
    }

    public int getOrderSeatCol() {
        return orderSeatCol;
    }

    public void setOrderSeatCol(int orderSeatCol) {
        this.orderSeatCol = orderSeatCol;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(int orderMoney) {
        this.orderMoney = orderMoney;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }
}
