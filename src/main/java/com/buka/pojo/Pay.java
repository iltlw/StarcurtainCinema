package com.buka.pojo;

import java.util.Date;

public class Pay {
    private int payId;
    private String payNum;
    private int payUserId;
    private Date payCreateTime;
    private  String payRefundInfo;
    private String payNotifyInfo;
    private int payState;

    public int getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(int payUserId) {
        this.payUserId = payUserId;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }

    public Date getPayCreateTime() {
        return payCreateTime;
    }

    public void setPayCreateTime(Date payCreateTime) {
        this.payCreateTime = payCreateTime;
    }

    public String getPayRefundInfo() {
        return payRefundInfo;
    }

    public void setPayRefundInfo(String payRefundInfo) {
        this.payRefundInfo = payRefundInfo;
    }

    public String getPayNotifyInfo() {
        return payNotifyInfo;
    }

    public void setPayNotifyInfo(String payNotifyInfo) {
        this.payNotifyInfo = payNotifyInfo;
    }
}
