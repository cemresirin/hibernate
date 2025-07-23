package com.cemre.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") //
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //  Boş constructor
    public User() {
    }

    // Dolu constructor
    public User(String name) {
        this.name = name;
    }

    // Getter ve Setter
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
    }


