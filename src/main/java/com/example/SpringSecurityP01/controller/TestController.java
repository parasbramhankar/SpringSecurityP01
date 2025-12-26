package com.example.SpringSecurityP01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/updates")
    public String updates(){
        return "This is update tab";
    }

    @GetMapping("/login")
    public String login(){
        return "this is the login page";
    }

    @GetMapping("/check-balance")
    public String CheckBalance(){
        return "this is the check balance";
    }
    

}
