package com.mikelsmaci.paintingStore.controller;


import com.mikelsmaci.paintingStore.entity.Painting;
import com.mikelsmaci.paintingStore.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PaintingController {
    @Autowired
    //create a painting service object
    private PaintingService service;
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
    //we add a path for save method by using postmapping
    @PostMapping("/save")
    public String addPainting(@ModelAttribute Painting painting) {
        //then we save this painting in our database
        //for that we creat an object by using annotation autowired
        service.save(painting);
        //we redirect this to available paintings
        return "redirect:/available_paintings";
    }
}
