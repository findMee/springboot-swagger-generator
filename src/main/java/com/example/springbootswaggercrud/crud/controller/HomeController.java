package com.example.springbootswaggercrud.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1")
@Api(description = "Rest api for home path", tags = {"Home"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        return "Welcome to spring boot with crud";
    }
}
