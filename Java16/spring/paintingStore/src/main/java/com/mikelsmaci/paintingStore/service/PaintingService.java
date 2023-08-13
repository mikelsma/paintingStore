package com.mikelsmaci.paintingStore.service;

import com.mikelsmaci.paintingStore.entity.Painting;
import com.mikelsmaci.paintingStore.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // the service annotate tells that class belong to service
public class PaintingService {
    //now we import the service package
    //first we create a method save to save the object
    @Autowired
    private PaintingRepository paintingRepository;
    public void save(Painting painting) {
        paintingRepository.save(painting);
    }
}
