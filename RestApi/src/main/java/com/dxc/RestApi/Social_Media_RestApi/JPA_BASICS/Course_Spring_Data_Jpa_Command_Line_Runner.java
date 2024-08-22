package com.dxc.RestApi.Social_Media_RestApi.JPA_BASICS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Course_Spring_Data_Jpa_Command_Line_Runner implements CommandLineRunner {

    //    FOR JPA WE ARE USING COMMAND LINE RUNNER

    @Autowired
    private SpringDataJpaRepository repository2;

    @Override
    public void run(String... args) throws Exception {
        repository2.save(new Course(
                1,"Soma Kumar","New Authority"
        ));
        repository2.save(new Course(
                2,"Ravi Kumar","Client Authority"
        ));
        repository2.save(new Course(
                3,"Rekha Kumari","Vansh Authority"
        ));

//        wokring well delete id
        repository2.deleteById(2L);

//        repository.findById(119L);

        //delete one should remove else will get error
        System.out.println(repository2.findById(1L ));
        System.out.println(repository2.findById(3L));
        System.out.println(repository2.count());
        System.out.println(repository2.findAll());
        System.out.println(repository2.findByAuthor("Rajvanhsi"));
        System.out.println(repository2.findByName("Ankit"));


    }


}
