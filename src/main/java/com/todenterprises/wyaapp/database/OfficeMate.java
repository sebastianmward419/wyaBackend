package com.todenterprises.wyaapp.database;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import com.todenterprises.wyaapp.database.calender.*;

@Document(collection = "officeMates")
public class OfficeMate {
    @Id
    public String id;

    private final String first_name;
    private final String last_name;
    private final String status;
    private final String location;
    private final String email;
    private final String password;

    private Day[] calender = new OfficemateCalender ().createCalender();

    public OfficeMate (String first_name,String last_name, String status, String location, String email, String password) {
        this.first_name = first_name;
        this.last_name  = last_name;
        this.status      = status;
        this.location    = location;
        this.email       = email;
        this.password  = password;
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

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }

    public Day[] getCalender () {
        return calender;
    }   
}