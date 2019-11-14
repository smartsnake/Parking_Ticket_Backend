package com.parking_ticket.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Document(collection = "pointTest")
public class Point {
    private double lat, lon;
    public Point setlat(double lat){
        this.lat = lat;
        return this;
    }
    public double getlat(){
        return this.lat;
    }

    public Point setlon(double lon){
        this.lon = lon;
        return this;
    }
    public double getlon(){
        return this.lon;
    }


    private long time;

    public long gettime(){
        return this.time;
    }
    public Point settime(long time){
        this.time = time;
        return this;
    }

    public Point(){

    }

    public Point(double lat, double lon, long time){
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


    @Override
    public String toString(){
        String json = "{lat: " + this.lat+", lon: " + this.lon + ", time: " + this.time + "}";
        return json;
    }
}
