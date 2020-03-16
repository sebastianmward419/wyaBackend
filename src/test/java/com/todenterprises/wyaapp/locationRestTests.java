package com.todenterprises.wyaapp;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class locationRestTests {

    @Test
    public void getLocationPredications () {
        Response getRequest = RestAssured.given ().get ("/api/get/locations/Sanfrancisco Galvanize");

        getRequest
        .then       ()
        .statusCode (200);
    }
    
}

