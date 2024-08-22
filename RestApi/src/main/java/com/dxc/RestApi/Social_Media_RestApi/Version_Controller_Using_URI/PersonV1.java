package com.dxc.RestApi.Social_Media_RestApi.Version_Controller_Using_URI;

public class PersonV1 {

    private String name;

    public String getName(){
        return name;
    }

    //Tostring
    @Override
    public String toString(){
        return "PersonV1 [name=" + name + "]";
    }


    public PersonV1(String name){
        super();
        this.name=name;
    }

}
