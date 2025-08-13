package com.notesbackend.notes.model;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.*;


@Entity
@Table(name = "users")

// Class
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Public Constructor
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Setters and Getters
    public Long getId(){
        return this.id;
    }
    public void setId(){
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(){
        this.password = password;
    }

    public LocalDateTime getDateTime(){
        return this.createdAt;
    }
    public void setDateTime(){
        this.createdAt = createdAt;
    }

}
