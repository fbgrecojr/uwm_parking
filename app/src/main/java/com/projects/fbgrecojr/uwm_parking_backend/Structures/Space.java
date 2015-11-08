package com.projects.fbgrecojr.uwm_parking_backend.Structures;


/**
 * Created by fbgrecojr on 11/5/15.
 */
public class Space {

    private int number;
    private String lot;
    private boolean available;
    private String expired;

    public Space(int number, String lot, boolean available, String expired){
        this.number = number;
        this.lot = lot;
        this.available = available;
        this.expired = expired;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Space#" + this.getNumber() + "\n");
        sb.append("Available: " + this.isAvailable() + "\n");
        sb.append("Expired: " + this.getExpired() + "\n");
        return sb.toString();
    }
}
