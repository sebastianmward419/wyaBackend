package com.todenterprises.wyaapp.controllers;

import com.todenterprises.wyaapp.database.OfficeMate;
import com.todenterprises.wyaapp.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestRoutes {

    @Autowired
    RestService restService;

// GET ROUTES
    @GetMapping("/api/get/officemates")
    ResponseEntity<Object> getUsersRoute () {
        return new ResponseEntity<>(restService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/get/officemate/{id}")
    ResponseEntity<Object> getUserRoute (@PathVariable String id) {
       return new ResponseEntity<>(restService.getUser(id), HttpStatus.OK);
    }

// POST ROUTES
    @PostMapping("/api/post/officemate")
    ResponseEntity<Object> postUserRoute (@RequestBody OfficeMate officemate) {
        return new ResponseEntity<>(restService.postUser(officemate), HttpStatus.CREATED);
    }

// PUT ROUTES
    @PutMapping("/api/update/officemate/{id}")
    ResponseEntity<Object> updateUserRoute (@PathVariable String id, @RequestBody OfficeMate officemate) {
        return new ResponseEntity<>(restService.updateUser(id, officemate), HttpStatus.ACCEPTED);
    }

// DELETE ROUTES
    @DeleteMapping("/api/delete/officemate/name/{name}")
    ResponseEntity<Object> deleteUserByNameRoute (@PathVariable String name) {

        restService.deleteUserByName(name);

        return new ResponseEntity<>("User delete success", HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/api/delete/officemate/{id}")
    ResponseEntity<Object> deleteUser (@PathVariable String id) {

        restService.deleteUser(id);

        return new ResponseEntity<>("User delete success", HttpStatus.NO_CONTENT);

    }

}
