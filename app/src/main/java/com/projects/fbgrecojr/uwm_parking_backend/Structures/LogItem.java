package com.projects.fbgrecojr.uwm_parking_backend.Structures;

/**
 * Created by fbgrecojr on 11/7/15.
 */
public class LogItem {

    private String time;
    private String keyword;
    private int length;
    private String lotName;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("username: " + this.getUserName() + "\n");
        sb.append("time: " + this.getTime() + "\n");
        sb.append("lot: " + this.getLotName() + "\n");
        sb.append("keyword: " + this.getKeyword() + "\n");
        sb.append("length " + this.getLength() + "\n");
        return sb.toString();
    }
}
