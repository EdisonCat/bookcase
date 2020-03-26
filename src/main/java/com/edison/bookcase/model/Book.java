package com.edison.bookcase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Document
public class Book implements Serializable {

    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private Date addingDate = new Date();
    private String category;

    public Book(UUID id, String name, Date addingDate, String category) {
        this.id = id;
        this.name = name;
        if(addingDate != null) this.addingDate = addingDate;
        this.category = category;
    }

    public Book() { }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
