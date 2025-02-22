package com.dxc.RestApi.Social_Media_RestApi.FilteringController;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//To apply filer use annotations
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    //It will not show in UI
    //JSON IGNORE IS WELL GOOD SUPPOSE IF WE CHANGE THE NAME THEN ALSO IT WILL WORK
    //@JsonIgnore
    //For multiple field use as arrays
    //@JsonIgnoreProperties({"filed1","field2"})

    private String field1;
   // @JsonIgnoreProperties("filed2")
    private String field2;

    //@JsonIgnore
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }

    public String getField1() {
        return field1;
    }


    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

}
