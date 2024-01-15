package com.uem.whitecamelapi.infraestructure.adapter.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AppController {
    @GetMapping("/api")
    public String wellcome() {
        return "Wellcome to White Camel API";
    }
    
}
