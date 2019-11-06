package com.parking_ticket.backend.models;

public class Point {
    int lat, lon;
    long time;
    public Point(int lat, int lon, long time){
        // TODO: Add move validations.
        if(lat == 0 || lon == 0 || time == 0){
            //problem
        }
        else{
            this.lat = lat;
            this.lon = lon;
            this.time = time;
        }
    }
}
