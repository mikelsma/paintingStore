package com.mikelsmaci.paintingStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//adding the annotation entity it will create my painting list in database
//so it will import the package from persistence
@Entity
//add annotation to create a table istead of painting table
@Table(name = "MyPaintings")
public class MyPaintingList {
    //adding id attribute it tells that this is primary key for the table
    @Id
    //here don't add annotation generate id becouse this id is not generated
    private int id;
    private String name;
    private String author;
    private String price;

    public MyPaintingList(int id, String name, String author, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public MyPaintingList() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
