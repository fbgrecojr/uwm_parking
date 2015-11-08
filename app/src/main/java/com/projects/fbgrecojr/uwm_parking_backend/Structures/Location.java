package com.projects.fbgrecojr.uwm_parking_backend.Structures;

/**
 * Created by fbgrecojr on 11/7/15.
 */
public class Location {

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "(" + getLatitude() + ", " + getLongitude() + ")";
    }

    /**
     * Calculates and returns the distance in miles between the two locations with 1 x 10^-15 accuracy
     * @param from
     * @param to
     * @return
     */
    public static double distance(Location from, Location to){
        double theta = to.getLongitude() - from.getLongitude();
        double dist = Math.sin(deg2rad(to.getLatitude())) * Math.sin(deg2rad(from.getLatitude())) + Math.cos(deg2rad(to.getLatitude())) * Math.cos(deg2rad(from.getLatitude())) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
}
