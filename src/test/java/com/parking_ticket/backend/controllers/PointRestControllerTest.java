package com.parking_ticket.backend.controllers;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;


class PointRestControllerTest {

    @Test
    void getAllPoints() {
        //Checks that JSON is returned and the status code is 200
        get("/points/").then().assertThat().contentType(ContentType.JSON)
        .statusCode(200);
    }

    @Test
    void findByAllPointsWithinTimes() {

        //Checks that get within time returns a json file and gets status code 200
        long time1 = 0;
        long time2 = Long.MAX_VALUE;

        get("/points?time1=" + time1 + "&time2=" + time2)
        .then().assertThat().contentType(ContentType.JSON)
        .statusCode(200);
    }

    @Test
    void savePoint() {
        //Save json point object, makes sure status code is 201
        JSONObject obj = new JSONObject();
        obj.put("lat", 36.05);
        obj.put("lon", -94.17);
        obj.put("time", (System.currentTimeMillis() / 1000));

        given().header("Content-Type", ContentType.JSON)
                .body(obj)
                .post("/point/")
        .then().assertThat().statusCode(201);

    }

    @Test
    void savePointFail(){
        //Making sure save null fails.
        given().header("Content-Type", ContentType.JSON)
                .post("/point/")
                .then().assertThat().statusCode(400);
    }
}