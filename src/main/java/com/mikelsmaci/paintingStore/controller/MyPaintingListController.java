package com.mikelsmaci.paintingStore.controller;

import com.mikelsmaci.paintingStore.service.MyPaintingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPaintingListController {
    //create my painting list service object
    @Autowired
    private MyPaintingListService service;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/my_paintings";
    }
}
