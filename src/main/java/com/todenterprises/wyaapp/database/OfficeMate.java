package com.todenterprises.wyaapp.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "officeMates")
public class OfficeMate {

    @Id
    public String id;

    final String email;
    
    String first_name;
    String last_name;
    String status;
    String location;
    String phoneNum;
   

    public OfficeMate (String first_name, String last_name, String status, String location, String email, String phoneNum) {
        this.first_name = first_name;
        this.last_name  = last_name;
        this.status     = status;
        this.location   = location;
        this.email      = email;
        this.phoneNum   = phoneNum;
       
    }

    public String getId () {
        return id;
    }

    public String getName () {
        return first_name + " " + last_name;
    }

    public String getFirstname () {
        return first_name;
    }

    public String getLastname () {
        return last_name;
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

    public String getPhoneNum () {
        return phoneNum;
    }

    public void setId (String id) {
        this.id = id;
    }

    public void setFirstname (String firstname) {
        this.first_name = firstname;
    }

    public void setLastname (String lastname) {
        this.last_name = lastname;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public void setLocation (String location) {
        this.location = location;
    }

   public void setPhoneNum (String phoneNum) {
       this.phoneNum = phoneNum;
   }
}