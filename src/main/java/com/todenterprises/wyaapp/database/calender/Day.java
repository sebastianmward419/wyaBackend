package com.todenterprises.wyaapp.database.calender;

public class Day {
    private String status   = "";
    private String location = "";

    public String getStatus () {
        return status;
    }

    public String getLocation () {
        return location;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public void setLocation (String location) {
        this.location = location;
    }
}