package com.todenterprises.wyaapp.controllers;

import com.todenterprises.wyaapp.database.OfficeMate;
import com.todenterprises.wyaapp.database.OfficeMateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestRoutes {

    @Autowired
    private OfficeMateRepository repository;

    @GetMapping("/api/get/officemates")
    @ResponseBody
    public List<OfficeMate> getUsers() {
        return repository.findAll();
    }

    @PostMapping("/api/post/officemate")
    public int postUser(@RequestBody OfficeMate officemate) {
        repository.save(officemate);
        return 201;
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
    public void deleteUserByName (@PathVariable String name) {
        List <OfficeMate> users = repository.findAll ();

        users.forEach (officemate -> {
           
            if (officemate.getName ().replaceAll ("\\s", "").equals (name)) repository.deleteById (officemate.getId ());
            
        });
    }

    @DeleteMapping("/api/officemate/{id}")
    public void deleteUser(@PathVariable String id) {
        repository.deleteById(id);
    }
}
