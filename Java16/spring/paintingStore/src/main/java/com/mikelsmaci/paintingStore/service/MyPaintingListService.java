package com.mikelsmaci.paintingStore.service;

import com.mikelsmaci.paintingStore.entity.MyPaintingList;
import com.mikelsmaci.paintingStore.repository.MyPaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPaintingListService {
    @Autowired
    private MyPaintingRepository myPainting;
    public void saveMyPaintings(MyPaintingList painting) {
        myPainting.save(painting);
    }
    public List<MyPaintingList> getAllMyPaintings() {
        return myPainting.findAll();
    }
    public void deleteById(int id) {
        myPainting.deleteById(id);
    }

}
