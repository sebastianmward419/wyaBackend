package com.todenterprises.wyaapp.services;

import java.util.List;
import java.util.Optional;

import com.todenterprises.wyaapp.database.OfficeMate;

public interface RestService {
    // GET
    public abstract List<OfficeMate> getUsers ();
    public abstract Optional<OfficeMate> getUser (String id);
    public abstract String getLocations (String input);
    //POST
    public abstract OfficeMate postUser (OfficeMate officemate);

    //PUT
    public abstract OfficeMate updateUser (String id, OfficeMate officemate);

    //DELETE
    public abstract void deleteUserByName (String name);
    public abstract void deleteUser (String id);

    // SMS
    public abstract void sendSMSToAll ();

}