package com.dxc.RestApi.Spring_Boot_Basics;


//Private entity can be use outside by only Getter and Setter
//Need Getter and Setter with Constructor
public class Model_Courses {

    private int id;
    private String Course;
    private   String Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Model_Courses(int id, String course, String description) {
        this.id = id;
        Course = course;
        Description = description;
    }
}
