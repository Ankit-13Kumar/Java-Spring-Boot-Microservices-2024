package com.dxc.RestApi.Social_Media_RestApi.FilteringController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Filtering_Controller {

    //For dynamic value we can use MappingJacksonValue

    @GetMapping("/filteringDynamic")
    public MappingJacksonValue filtering() {
        SomeBean someBean=new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        //create a filter
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
        //return new SomeBean("value1", "value1", "value3");
    }

    @GetMapping("/filteringList")
    public List<SomeBean> filteringList() {
        return Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value5", "value6", "value7")

        );
    }

    @GetMapping("/filtering_List")
    public MappingJacksonValue filteringList2() {
        List<SomeBean> list = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value5", "value6", "value7")

        );

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(list);
        //create a filter

        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;

    }
}
