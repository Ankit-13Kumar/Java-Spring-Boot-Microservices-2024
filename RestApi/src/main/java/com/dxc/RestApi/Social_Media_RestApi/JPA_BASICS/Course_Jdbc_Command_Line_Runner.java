package com.dxc.RestApi.Social_Media_RestApi.JPA_BASICS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Course_Jdbc_Command_Line_Runner implements CommandLineRunner {
    @Autowired
    private Course_Jdbc_Repository repository;

    @Override
    public void run(String... args) throws Exception {
        //Added and .method name
//        repository.insert();
//        Modify
        repository.insert(new Course(
                119,"Ankit Kumar","Vansh Authority"
        ));
        repository.insert(new Course(
                120,"Sagar Kumar","Sagar Authority"
        ));
        repository.insert(new Course(
                121,"Sonam Kumar","Sonam Authority"
        ));

//        wokring well delete id
        repository.deleteById(120L);

//        repository.findById(119L);

        //delete one should remove else will get error
        System.out.println(repository.findById(119L ));
        System.out.println(repository.findById(121L));


        /*Output*/
        /*
        Course{id=119, name='Ankit Kumar', author='Vansh Authority'}
        Course{id=121, name='Sonam Kumar', author='Sonam Authority'}
*/

    }



}
