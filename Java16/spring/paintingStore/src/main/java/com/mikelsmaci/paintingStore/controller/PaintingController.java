package com.mikelsmaci.paintingStore.controller;


import com.mikelsmaci.paintingStore.entity.MyPaintingList;
import com.mikelsmaci.paintingStore.entity.Painting;
import com.mikelsmaci.paintingStore.service.MyPaintingListService;
import com.mikelsmaci.paintingStore.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class PaintingController {
    @Autowired
    //create a painting service object
    private PaintingService service;
    @Autowired
    private MyPaintingListService myPaintingService;

    @GetMapping("/")
//create a method for home
    public String home() {
        return "home";
    }
    //add a path for paintingRegister

    @GetMapping("/painting_register")
    public String paintingRegister() {
        return "paintingRegister";
        //now we go to template and create a new html file paitingRegister
    }


    // add a path for available_paintings
    @GetMapping("/available_paintings")
    public ModelAndView getAllPainting() {
        List<Painting>list=service.getAllPainting();
        //create a model and view object and go and make changes to html paiting list
        return new ModelAndView("paintingList", "painting", list);
        //now we go to template and create a new html file paintingList
    }


    //we add a path for save method by using post mapping
    @PostMapping("/save")
    public String addPainting(@ModelAttribute Painting painting) {
        //then  save this painting in our database
        //for that creat an object by using annotation autowired
        service.save(painting);
        //redirect this to available paintings
        return "redirect:/available_paintings";
    }


    @GetMapping("/my_paintings")
    public String getMyPaintings(Model model) {
        List<MyPaintingList> list=myPaintingService.getAllMyPaintings();
        model.addAttribute("painting", list);
        return "myPaintings";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
       Painting painting=service.getPaintingById(id);
       //for object, create in the top autowired annotation for my painting service
        MyPaintingList myPaintingList = new MyPaintingList(painting.getId(),painting.getName(),painting.getAuthor(),painting.getPrice());
        myPaintingService.saveMyPaintings(myPaintingList);
        return "redirect:/my_paintings";
        //go to painting service and create e method
    }

    @RequestMapping("/editPainting/{id}")
    public String editPainting(@PathVariable("id") int id, Model model) {
        Painting painting = service.getPaintingById(id);
        model.addAttribute("painting", painting);
        return "paintingEdit";
    }

    @RequestMapping("/deletePainting/{id}")
    public String deletePainting(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_paintings";
    }
}
