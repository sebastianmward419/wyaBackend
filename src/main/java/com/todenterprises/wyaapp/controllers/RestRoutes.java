package com.todenterprises.wyaapp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
public class RestRoutes 
{
    @RequestMapping ("/fuck")
    public String index () {
        return "FUCKKKKK";
    }

    @GetMapping ("/api/get/users")
    public String getUsers () {
        return "Here are your users";
    }

}
