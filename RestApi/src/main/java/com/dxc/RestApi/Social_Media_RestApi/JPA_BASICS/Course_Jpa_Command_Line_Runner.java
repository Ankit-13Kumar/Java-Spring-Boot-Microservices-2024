package com.dxc.RestApi.Social_Media_RestApi.JPA_BASICS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Course_Jpa_Command_Line_Runner implements CommandLineRunner {

    //    FOR JPA WE ARE USING COMMAND LINE RUNNER

    @Autowired
    private Course_Jpa_Repository repository1;

    @Override
    public void run(String... args) throws Exception {
        repository1.insert(new Course(
                1,"Soma Kumar","New Authority"
        ));
        repository1.insert(new Course(
                2,"Ravi Kumar","Client Authority"
        ));
        repository1.insert(new Course(
                3,"Rekha Kumari","Vansh Authority"
        ));

//        wokring well delete id
        repository1.deleteById(2L);

//        repository.findById(119L);

        //delete one should remove else will get error
        System.out.println(repository1.findById(1L ));
        System.out.println(repository1.findById(3L));

    }


}
