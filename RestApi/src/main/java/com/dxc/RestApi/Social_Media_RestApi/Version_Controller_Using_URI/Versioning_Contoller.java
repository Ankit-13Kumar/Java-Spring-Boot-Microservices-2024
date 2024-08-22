package com.dxc.RestApi.Social_Media_RestApi.Version_Controller_Using_URI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Versioning_Contoller {

//    1 - Using URI - Twitter

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }



    /*Output:-
     {
  "name": {
    "firstName": "Bob",
    "lastName": "Charle"
  }
}
    */
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob","Charle"));
    }

       //    2- Using Request PARAM - Amazon
      // http://localhost:8080/person?version=1
      @GetMapping(path = "/person",params = "version=1" )
      public PersonV1 getFirstVersionOfPersonRequestParameter() {
          return new PersonV1("Bob Charle");

      }

          // http://localhost:8080/person?version=2
          @GetMapping(path = "/person/header",params = "version=2")
          public PersonV2 getSecondVersionOfPersonRequestParameter() {
              return new PersonV2(new Name("Bob", "Charle"));
          }

          // 3- Using custom header versioning -> Microsoft
          //http://localhost:8080/person/header
          //Pass header in postman - KEY-> X-API-VERSION value->1
          @GetMapping(path = "/person/header",headers = "X-API-VERSION=1" )
          public PersonV1 getFirstVersionOfPersonRequestHeasers() {
              return new PersonV1("Bob Charle");

          }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeaders() {
        return new PersonV2(new Name("Bob", "Charle"));
    }

    //media type versioning - github
    // Use postman -> key -> accept, value ->application/vnd.company.app-v2+json
    @GetMapping(path = "/person/accept-header",produces = "application/vnd.company.app-v1+json" )
    public PersonV1 getFirstVersionOfPersonRequestMediaType() {
        return new PersonV1("Bob Charle");

    }

    @GetMapping(path = "/person/accept-header",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonRequestMediaType() {
        return new PersonV2(new Name("Bob", "Charle"));
    }


}

