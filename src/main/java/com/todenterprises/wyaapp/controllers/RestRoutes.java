package com.todenterprises.wyaapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

import com.todenterprises.wyaapp.database.*;

import java.util.List;

@RestController 
public class RestRoutes {
    
    @Autowired
    private OfficeMateRepository repository;

    @GetMapping ("/api/get/officemates")
    @ResponseBody
    public List <OfficeMate> getUsers () {
        return repository.findAll ();
    }

    @PostMapping ("/api/post/officemate")
    public int postUser (@RequestBody OfficeMate officemate) {
        repository.save (officemate);

        return 201;
    }

    @PutMapping ("/api/update/officemate")
    public int updateUser () {
        return 202;
    }

    @DeleteMapping ("/api/delete/officemate")
    public int deleteUser () {
        return 202;
    }

}
