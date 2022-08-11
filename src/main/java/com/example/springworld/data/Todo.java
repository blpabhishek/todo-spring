package com.example.springworld.data;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@EqualsAndHashCode
public class Todo {
    @Id
    @GeneratedValue
    private int id;

    @Valid
    @NotNull
    private String item;

    public Todo(){

    }

    public Todo(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
