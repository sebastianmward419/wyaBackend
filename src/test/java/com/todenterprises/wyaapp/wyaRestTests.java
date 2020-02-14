package com.todenterprises.wyaapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import net.minidev.json.JSONObject;

import static org.hamcrest.Matchers.hasKey;

import static org.hamcrest.Matchers.everyItem;
public class wyaRestTests {

    private String idPosted = "";

    private JSONObject reqObj;

    @BeforeEach
    public void intitialize () {
        reqObj = new JSONObject ();

        reqObj.put ("first_name", "Darw");
        reqObj.put ("last_name", "Naitsabes");
        reqObj.put ("status", "yes");
        reqObj.put ("location", "Nas ocsicnarf");
        reqObj.put ("email", "kern@idm.com");
        reqObj.put ("password", "DEFAULT");

        Response postRequest = RestAssured.given ().contentType (ContentType.JSON).body (reqObj.toJSONString ()).post ("/api/post/officemate");
        
        idPosted = postRequest
        .then       ()
        .statusCode (201)
        .extract    ()
        .jsonPath   ()
        .get        ("id");

    }

    @AfterEach 
    public void terminiate () {
        Response deleteResponse = RestAssured.given ().delete ("/api/delete/officemate/name/DarwNaitsabes");

        deleteResponse
        .then       ()
        .statusCode (204);

    }

    @Test
    public void getOfficeMates () {
        Response getRequest = RestAssured.given ().get ("/api/get/officemates");

        getRequest
        .then       ()
        .statusCode (200)
        .body       ("$", everyItem (hasKey ("name")));

    }

    @Test
    public void getOfficeMate () {
        Response getRequest = RestAssured.given ().get ("/api/get/officemate/" + idPosted);

        getRequest
        .then ()
        .statusCode(200);

        getRequest = RestAssured.given ().get ("/api/get/officemate/fakeid");

        getRequest
        .then       ()
        .statusCode (200);
    }

    @Test
    public void putOfficeMate () {
        reqObj.put ("first_name", "Chris");
        reqObj.put ("last_name", "Palko");
        reqObj.put ("status", "maybe");
        
        Response putResponse = RestAssured.given ().contentType (ContentType.JSON).body (reqObj.toJSONString ()).put ("/api/update/officemate/" + idPosted);

        putResponse
        .then       () 
        .statusCode (200);

        Response getResponse = RestAssured.given ().get ("/api/get/officemate/" + idPosted);

        JsonPath resObj = getResponse
        .then       ()
        .statusCode (200)
        .extract    ()
        .jsonPath   ();

        assertEquals ("Chris Palko", resObj.get ("name"));
        assertEquals ("maybe", resObj.get ("status"));
        
    }

}