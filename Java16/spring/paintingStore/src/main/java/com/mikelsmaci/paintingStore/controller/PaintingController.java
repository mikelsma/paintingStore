package com.mikelsmaci.paintingStore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PaintingController {
    @GetMapping("/")
//create a method for home
    public String home() {
        return "home";
    }
}
