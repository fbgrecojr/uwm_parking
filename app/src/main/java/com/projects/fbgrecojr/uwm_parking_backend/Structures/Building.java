package com.projects.fbgrecojr.uwm_parking_backend.Structures;

/**
 * Created by fbgrecojr on 11/7/15.
 */
public class Building {

    private String name;
    private Location location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + this.getName() + "\n");
        sb.append("Location: " + this.getLocation().toString() + "\n");
        return sb.toString();
    }
}
