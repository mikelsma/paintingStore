package com.mikelsmaci.paintingStore.repository;

import com.mikelsmaci.paintingStore.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//extending Jpa it will add all jpa functionalities like add, delete ect
public interface PaintingRepository extends JpaRepository<Painting, Integer> {

}
