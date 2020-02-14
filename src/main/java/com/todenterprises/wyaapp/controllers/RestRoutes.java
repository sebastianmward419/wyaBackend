package com.todenterprises.wyaapp.controllers;

import com.todenterprises.wyaapp.database.OfficeMate;
import com.todenterprises.wyaapp.database.OfficeMateRepository;
import com.todenterprises.wyaapp.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RestRoutes {

    @Autowired
    private OfficeMateRepository repository;

    @Autowired
    private RestService restService;

    @GetMapping("/api/get/officemates")
    public ResponseEntity<Object> getUsersRoute () {
        return new ResponseEntity<>(restService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/get/officemate/{id}")
    public ResponseEntity<Object> getUserRoute (@PathVariable String id) {
       return new ResponseEntity<>(restService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/api/post/officemate")
    public ResponseEntity postUser(@RequestBody OfficeMate officemate) {
        return new ResponseEntity<>(restService.postUser(officemate), HttpStatus.CREATED);
    }

    @PutMapping("/api/update/officemate/{id}")
    public OfficeMate updateUser(@RequestBody OfficeMate newOfficemate, @PathVariable String id) {
        return repository.findById(id)
                .map(officeMate -> {
                    officeMate.setStatus(newOfficemate.getStatus());
                    officeMate.setLocation(newOfficemate.getLocation());
                    return repository.save(officeMate);
                })
                .orElseGet(() -> {
                    newOfficemate.setId(id);
                    return repository.save(newOfficemate);
                });
    }

    @DeleteMapping ("/api/delete/officemate/name/{name}")
    public void deleteUserByName (@PathVariable String name, HttpServletResponse response) {
        List <OfficeMate> users = repository.findAll ();

        users.forEach (officemate -> {
           
            if (officemate.getName ().replaceAll ("\\s", "").equals (name)) repository.deleteById (officemate.getId ());
            
        });

        response.setStatus (204);
    }

    @DeleteMapping("/api/officemate/{id}")
    public void deleteUser(@PathVariable String id) {
        repository.deleteById(id);
    }
}
