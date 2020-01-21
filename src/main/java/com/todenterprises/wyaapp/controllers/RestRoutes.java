package com.todenterprises.wyaapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todenterprises.wyaapp.database.*;

import java.util.List;

@RestController 
public class RestRoutes {
    
    @Autowired
    private OfficeMateRepository repository;

    @RequestMapping ("/fuck")
    public List <OfficeMate> index () {
        return repository.findAll ();
    }

    @GetMapping ("/api/get/officemates")
    @ResponseBody
    public List <OfficeMate> getUsers () {
        return repository.findAll ();
    }

}
