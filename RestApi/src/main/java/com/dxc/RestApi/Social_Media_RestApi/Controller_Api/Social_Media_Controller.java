package com.dxc.RestApi.Social_Media_RestApi.Controller_Api;



/*
Social Media Application - Resources & Mathods
Users Rest API
- Retrieve all users - get/users
- Create a User - Post/users
- retrieve one user - get/users/{id} -> /users/1
- Delete a User - delete/users/{id} -> /users/1
- Post REST API - Retrieve all posts for a user - get/users/{id}/posts
*/

import com.dxc.RestApi.Social_Media_RestApi.Exception.UserNotFoundException;
import com.dxc.RestApi.Social_Media_RestApi.Model.User;
import com.dxc.RestApi.Social_Media_RestApi.Service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//manually import
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;


@RestController
public class Social_Media_Controller {
    @Autowired
    private UserDaoService service;

    //constructor
    public Social_Media_Controller(UserDaoService service) {
        this.service = service;
    }

    //GET /users http://localhost:8080/GET/users
    //First create logic in service
    @GetMapping("/GET/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //GET /users/{id} - http://localhost:8080/users/1
    //Need to use path variable
    //After the create logic in service
    //Return type should be user
    @GetMapping("/GET/users/{id}")
/*    public User retrieveUserById(@PathVariable int id){
         return service.findOne(id);*/
    public User retrieveUserById(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }
        //Need to return after braces
        return user;


    }

    //Post /user
    //Post will not return anything so Void
    //accept by Request Body and it will take user
    //First go to service and create
    //http://localhost:8080/POST/users - FOR POSTMAN HIT API
    //TO CHECK ADDED OR NOT HIT AND GET LIST- http://localhost:8080/GET/users
  /*  {
            "name":"Rajvanhsi",
            "birthDate":"1997-08-05"
    }*/
//    @PostMapping("/POST/users")
//    public void createUser(@RequestBody User user){
//        //added after service logic
//          service.save(user);
//    }

    //modify for response status
    //Post request
    //Need to fix it is taking future dob and empty name -> Need dependency starter validation for fixing.
    //Use valid anotation for check then go to entity and apply anotation
    @PostMapping("/POST/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        //valid whenever binding happenend your object auto invoked

        //added after service logic
        service.save(user);

        //Response Status
        /*
         * 200 - Success
         * 201 - Created
         * 400 - Bad request
         * 404-  Resource not found
         * 500 - Server error
         */
        //Location header - /users/4 which url is created by user and return the URI
        // /users/4 -> /users/{id}, user.getID
        // Replace the id with created by the user
        //No win postman in header location will show with new url
        // We need to think as perspective of user -> http://localhost:8080/POST/users/4
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser
                        .getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    //Delete the specific user using id
    //Path variable for ID
    @DeleteMapping("/Delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);

        //Need to use exception for other id it is giving success 201 message.
        //Need to fix later

    }

     //HATEOAS DEPENDENCY USED AND MANUAL IMPORT the package
    // Return link when hit api
    // EntityModel
    // WebMvcLinkBuilder

    /*Output - {
    "id": 1,
    "name": "Ankit",
    "birthDate": "2003-08-11",
    "_links": {
        "all-users": {
            "href": "http://localhost:8080/GET/users"
        }
    }
}*/
    @GetMapping("/GET/users1/{id}")
    public EntityModel<User> retrieveUserById1(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<User> entityModel=EntityModel.of(user);

        //To return link use WebMvcLinkBuilder
        //manually import the class.
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        //Need to return after braces
        return entityModel;
    }



}
