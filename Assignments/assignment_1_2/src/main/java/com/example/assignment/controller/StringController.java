package com.example.assignment.controller;

import com.example.assignment.service.IStringService;
import com.example.assignment.service.ITextService;
import com.example.assignment.service.StringService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class StringController {

    final
    IStringService stringService;
    ITextService textService;

    public StringController(IStringService stringService, ITextService textService) {
        this.stringService = stringService;
        this.textService = textService;
    }

    @GetMapping(value = "/string")
    @ResponseBody
    public String Reverse(@RequestParam(value = "value", defaultValue = "") String input){
        return stringService.getReversed(input);
    }

    @GetMapping(value = "/text")
    @ResponseBody
    public Integer Count(@RequestParam(value="value", defaultValue = "") String input){
        return textService.countWords(input);
    }




}


