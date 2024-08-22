package com.dxc.RestApi.Spring_Boot_Basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//Pass the value and created a class with model name
//Annotations for Rest API
//Dependency use only Spring Web

@RestController
public class Controller_Api {

    @GetMapping("/Courses1")
    public List<Model_Courses> AllCourse(){
        return Arrays.asList(
                new Model_Courses(1,"Java","OOPS"),
                new Model_Courses(2,"Python","ML/AI")
        );
    }

}


//Working Steps

/*

Spring Boot Learning......................................................

spring initializer -
group name -com.dxc
artifact - application name -> class name
name - project name same as artifact
package name - dxc.demo.new
java 17

............................................................................................
Dependcies -
srping web - use for rest api
generate

..............................................................................
Json

https:localhost:8080/spring
[{
"id":1,
"name":"Ankit"
}]


....................................................................................

Controller - list of course - return arrays.asList
pass the new course(value)

Model - entity -  getter and setter - constructor
entity private - we can use them using public getter and setter method

Getter

public int getId() {
        return id;
    }

Setter

  public void setId(int id) {
        this.id = id;
    }

Constructor

 public Model_Courses(int id, String course, String description) {
        this.id = id;
        Course = course;
        Description = description;
    }

.........................................................................................


 */