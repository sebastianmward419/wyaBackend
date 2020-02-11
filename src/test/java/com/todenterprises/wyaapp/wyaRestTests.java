package com.todenterprises.wyaapp;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.everyItem;
public class wyaRestTests {

    private String idPosted = "";

    @Test
    public void getOfficeMates () {
        Response getRequest = RestAssured.given ().get ("/api/get/officemates");

        getRequest
        .then       ()
        .statusCode (200)
        .body       ("$", everyItem (hasKey ("name")));
    }

    @Test
    public void portOfficeMate () {
        JSONObject reqObj = new JSONObject ();

        reqObj.put ("first_name", "Darw");
        reqObj.put ("last_name", "Naitsabes");
        reqObj.put ("status", "yes");
        reqObj.put ("location", "Nas ocsicnarf");
        reqObj.put ("email", "kern@idm.com");
        reqObj.put("password", "DEFAULT");

        Response postRequest = RestAssured.given ().contentType (ContentType.JSON).body (reqObj.toJSONString ()).post ("/api/post/officemate");
         
        postRequest
        .then       ()
        .log ().all();

    }

    @Test
    public void putOfficeMate () {

    }

    @Test 
    public void deleteOfficeMateByName () {
        Response deleteResponse = RestAssured.given ().delete ("/api/delete/officemate/name/DarwNaitsabes");

        deleteResponse
        .then ()
        .statusCode (200);
    }
}