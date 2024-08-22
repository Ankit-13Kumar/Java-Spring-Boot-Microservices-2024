package com.dxc.RestApi.Social_Media_RestApi.Service;

import com.dxc.RestApi.Social_Media_RestApi.Model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //JPA /Hibernate > DataBase
    //UserDaoService > Static Lists

    //Static user list
    private static List<User> users =new ArrayList<>();

    //Created for Post
    private static int usersCount=3;

    static {
        users.add(new User(1,"Ankit", LocalDate.now().minusYears(21)));
        users.add(new User(2,"Sagar", LocalDate.now().minusYears(25)));
        //Another way to count user
        // users.add(new User(++usersCount,"Sagar", LocalDate.now().minusYears(25)));

    }


    //public List<User> findAll(){}
    public List<User> findAll(){
        return users;
    }

    //public User save(User user){}
    public User save(User user){
        //add and save the user and return user
        //created counUsers id for this and ++ increase all time
        //set the user is
        user.setId(usersCount++);
        users.add(user);
        return user;
        //now got to controller and modify
    }


    //public User findOne(int id){}

    public User findOne(int id) {
     //Using functional programming
        //Predicate variable - check the id of the user is matching then it will return
        //How do you match the user we can use predicate for matching the user
        //using lambda function
       Predicate<? super User> predicate= user -> user.getId().equals(id);
       //.get return the user
        //users list
       //return users.stream().filter(predicate).findFirst().get();
        //modifying for exception now it will show blank gage for wrong api not white lebel page
        return users.stream().filter(predicate).findFirst().orElse(null);

    }

    //Delete user
    public void deleteById(int id) {
        Predicate<?super User> predicate=user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
