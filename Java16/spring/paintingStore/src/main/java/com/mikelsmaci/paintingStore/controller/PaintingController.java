package com.mikelsmaci.paintingStore.controller;


import com.mikelsmaci.paintingStore.entity.MyPaintingList;
import com.mikelsmaci.paintingStore.entity.Painting;
import com.mikelsmaci.paintingStore.service.MyPaintingListService;
import com.mikelsmaci.paintingStore.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class PaintingController {
    @Autowired
    //create a painting service object
    private PaintingService service;
    @Autowired
    private MyPaintingListService myPaintingListService;
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
    public ModelAndView getAllPaintings() {
        List<Painting>list=service.getAllPainting();
        //create a modelandview object and go and make changes to html paiting list
        return new ModelAndView("paintingList", "painting", list);
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
    @GetMapping("/my_paintings")
    public String getMyPaintings() {
        return "myPaintings";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
       Painting painting=service.getPaintingById(id);
       //for object, we create in the top autowired annotation for my painting service
        MyPaintingList myPaintingList = new MyPaintingList(painting.getId(),painting.getName(),painting.getAuthor(),painting.getPrice());
        myPaintingListService.saveMyPaintings(myPaintingList);
        return "redirect:/my_paintings";
        //go to Painting service and create e method
    }
}
