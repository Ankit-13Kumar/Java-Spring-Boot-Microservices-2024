package com.dxc.RestApi.Social_Media_RestApi.JPA_BASICS;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<Course,Long> {

//    We can create our own menthod using spring data JPA
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);

}
