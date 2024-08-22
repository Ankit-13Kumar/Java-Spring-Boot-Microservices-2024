package com.dxc.RestApi.Social_Media_RestApi.Version_Controller_Using_URI;

public class PersonV2 {
    //Name is an object
private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name=" + name +
                '}';
    }
}
