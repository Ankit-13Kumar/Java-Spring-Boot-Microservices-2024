package com.dxc.RestApi.Social_Media_RestApi.JPA_BASICS;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;



//Entity manager need transactional annotations
@Repository
@Transactional
public class Course_Jpa_Repository {
//    To talk with database use entity manager
    // we can use both @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    //to insert use merge method
    public void insert(Course course){
        entityManager.merge(course);
    }
    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }
  /*  public void deleteById(Long id){
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }*/


    public boolean deleteById(Long id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
            return true;
        } else {
            return false;
        }
    }

}
