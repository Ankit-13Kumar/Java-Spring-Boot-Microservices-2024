package com.dxc.RestApi.Social_Media_RestApi.SpringBoot_JPA;



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
import com.dxc.RestApi.Social_Media_RestApi.Model.Post;
import com.dxc.RestApi.Social_Media_RestApi.Model.User;
import com.dxc.RestApi.Social_Media_RestApi.Service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class Social_Media_Controller_Jpa {
//    @Autowired
//    private UserDaoService service;

    @Autowired
    private User_Repository userRepository;

    @Autowired
    private Post_Repository postRepository;

    //constructor for repository
    public Social_Media_Controller_Jpa(UserDaoService service, User_Repository userRepository,Post_Repository postRepository) {
//        this.service = service;
        this.userRepository = userRepository;
        this.postRepository=postRepository;
    }

    //GET /users http://localhost:8080/GET/users
    //First create logic in service
    @GetMapping("/JPA/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    //GET /users/{id} - http://localhost:8080/users/1
    //Need to use path variable
    //After the create logic in service
    //Return type should be user
    @GetMapping("/JPA/users/{id}")
/*    public User retrieveUserById(@PathVariable int id){
         return service.findOne(id);*/
    public Optional<User> retrieveUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
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
    @PostMapping("/JPA/POST/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        //valid whenever binding happenend your object auto invoked

        //added after service logic
        userRepository.save(user);

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
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser
                        .getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    //Delete the specific user using id
    //Path variable for ID
    @DeleteMapping("/JPA/Delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);

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
    @GetMapping("/JPA/users1/{id}")
    public EntityModel<User> retrieveUserById1(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user.get());

        //To return link use WebMvcLinkBuilder
        //manually import the class.
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        //Need to return after braces
        return entityModel;
    }



//Created for Post Entity
//    http://localhost:8080/jpa/users/121/posts
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);
           return user.get().getPosts();
        }



//         http://localhost:8080/jpa/users/121/posts

    /*{
    "description":"Learning Computer"
    }*/
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost
                        .getId()).toUri();

        return ResponseEntity.created(location).build();

    }


    }
