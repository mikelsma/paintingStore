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
    //we add a path for paintingRegister
    @GetMapping("/painting_register")
    public String paintingRegister() {
        return "paintingRegister";
        //now we go to template and create a new html file paitingRegister
    }
    // we add a path for available_paintings
    @GetMapping("/available_paintings")
    public String getAllPaintings() {
        return "paintingList";
        //now we go to template and create a new html file paintingList
    }
}
