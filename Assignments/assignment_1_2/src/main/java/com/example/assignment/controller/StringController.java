package com.example.assignment.controller;

import com.example.assignment.service.IStringService;
import com.example.assignment.service.StringService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class StringController {

    @Autowired
    IStringService stringService;

    @GetMapping(value = "/string")
    @ResponseBody
    public String Reverse(@RequestParam(value = "value", defaultValue = "") String input){
        return stringService.getReversed(input);
    }

    @GetMapping(value = "/text")
    public Integer Count(@RequestParam(value="value", defaultValue = "") String input){
        
    }




}


