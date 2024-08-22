package com.dxc.RestApi.Social_Media_RestApi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/*
Post -> id,description
User -> id,name,birthDate
**/

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(max = 30)
    private String description;
    @ManyToOne(fetch =FetchType.LAZY)
    @JsonIgnore
    private User user;

    //Creating getter and setter for user for get request for Post entity


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //Getting error bcoz no arg constructor was missing for Post entity request
    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

