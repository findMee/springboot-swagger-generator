package com.example.springbootswaggercrud.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        return "Welcome to spring boot with crud";
    }
}
