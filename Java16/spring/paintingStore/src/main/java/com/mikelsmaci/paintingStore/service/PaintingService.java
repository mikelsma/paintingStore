package com.mikelsmaci.paintingStore.service;

import com.mikelsmaci.paintingStore.entity.Painting;
import com.mikelsmaci.paintingStore.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // the service annotate tells that class belong to service
public class PaintingService {
    //now import the service package
    //first create a method save to save the object
    @Autowired
    private PaintingRepository paintingRepository;
    public void save(Painting painting) {
        paintingRepository.save(painting);
    }
    //now to fetch data in table format
    // create a method getAllPainting
    public List<Painting> getAllPainting() {
        return paintingRepository.findAll();
        //now go to book controller
    }
    public Painting getPaintingById(int id) {
        return paintingRepository.findById(id).get();
        //go back to painting controller class and call this method
    }

}
