package com.buka.pojo;

public class Platform {
    private int platformId;
    private String platformName;
    private String platformPassword;

    public Platform() {
    }

    public Platform(String platformName, String platformPassword) {
        this.platformName = platformName;
        this.platformPassword = platformPassword;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformPassword() {
        return platformPassword;
    }

    public void setPlatformPassword(String platformPassword) {
        this.platformPassword = platformPassword;
    }
}
