package com.projects.fbgrecojr.uwm_parking_backend.Test;

import com.projects.fbgrecojr.uwm_parking_backend.Archive.Location;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date date = format.parse("2012-12-13 14:54:30"); // mysql datetime format
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            System.out.println(calendar.getTime());
            int month = calendar.get(Calendar.MONTH);
            System.out.println(month);
        }catch (ParseException e){
            //do something
        }
    }
}
