package com.todenterprises.wyaapp.database;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "officeMates")
public class OfficeMate {
    private final String id;
    private final String first_name;
    private final String last_name;
    private final String status;
    private final String location;
    private final String password;

    public OfficeMate (String id, String first_name,String last_name, String status, String location, String password) {
        this.id       = id;
        this.first_name     = first_name;
        this.last_name = last_name;
        this.status   = status;
        this.location = location;
        this.password = password;
    }

    public String getName () {
        return first_name + " " + last_name;
    }

    public String getStatus () {
        return status;
    }

    public String getLocation () {
        return location;
    }

    public String getPassword () {
        return password;
    }

   
}