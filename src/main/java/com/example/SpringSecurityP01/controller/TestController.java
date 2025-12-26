package com.example.SpringSecurityP01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/updates")
    public String updates(){
        return "This is update tab";
    }

    @GetMapping("/contact")
    public String contactUs(){
        return "this is the contactUs page";
    }

    @GetMapping("/check-balance")
    public String CheckBalance(){
        return "this is the check balance";
    }

    @GetMapping("/transfer")
    public String transfer(){
        return "this is transfer tab";
    }

}
