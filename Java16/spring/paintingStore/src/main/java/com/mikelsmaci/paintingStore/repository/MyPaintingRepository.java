package com.mikelsmaci.paintingStore.repository;

import com.mikelsmaci.paintingStore.entity.MyPaintingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPaintingRepository extends JpaRepository<MyPaintingList, Integer> {
    //go to service package now
}
