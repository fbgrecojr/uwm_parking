package com.projects.fbgrecojr.uwm_parking_backend.Structures;

/**
 * Created by fbgrecojr on 11/7/15.
 */
public class User {

    private String username;
    private String first;
    private String last;
    private String phone;
    private String email;
    private boolean covered;
    private int distORprice;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public int getDistORprice() {
        return distORprice;
    }

    public void setDistORprice(int distORprice) {
        this.distORprice = distORprice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("username: " + this.getUsername() + "\n");
        sb.append("first name: " + this.getFirst() + "\n");
        sb.append("last name: " + this.getLast() + "\n");
        sb.append("phone: " + this.getPhone() + "\n");
        sb.append("email: " + this.getEmail() + "\n");
        sb.append("covered: " + this.isCovered() + "\n");
        sb.append("Distance/Price (1-10 scale): " + this.getDistORprice() + "\n");
        return sb.toString();
    }
}
