package com.mikelsmaci.paintingStore.service;

import com.mikelsmaci.paintingStore.entity.MyPaintingList;
import com.mikelsmaci.paintingStore.repository.MyPaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPaintingListService {
    @Autowired
    private MyPaintingRepository myPainting;
    public void saveMyPaintings(MyPaintingList painting) {
        myPainting.save(painting);
    }


}
