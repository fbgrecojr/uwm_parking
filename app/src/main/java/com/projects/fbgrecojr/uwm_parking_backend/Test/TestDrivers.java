package com.projects.fbgrecojr.uwm_parking_backend.Test;

import com.projects.fbgrecojr.uwm_parking_backend.Structures.Location;

/**
 * Created by fbgrecojr on 11/7/15.
 */
public class TestDrivers {

    public static void main(String[] args){
        Location x = new Location();
        x.setLatitude(43.065476);
        x.setLongitude(-87.886568);

        Location y = new Location();
        y.setLatitude(43.123725);
        y.setLongitude(-88.050591);

        double dist = Location.distance(x,y);

        System.out.println(dist + " miles between " + x.toString() + " and " + y.toString());
    }
}
