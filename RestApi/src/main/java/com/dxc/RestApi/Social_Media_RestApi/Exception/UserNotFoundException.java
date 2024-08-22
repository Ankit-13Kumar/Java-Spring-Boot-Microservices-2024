package com.dxc.RestApi.Social_Media_RestApi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Now we are getting
/*There was an unexpected error (type=Internal Server Error, status=500).
        id:9
        com.dxc.RestApi.Social_Media_RestApi.Exception.UserNotFoundException: id:9*/
//For change the Response code use annotations before 500 now 400
// We have comment the devtools , Now only limited data will show in web page error-->

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    //Created constuctor who will aceept the message
    public UserNotFoundException(String message) {
        //accept the message and passes to the super class
        super(message);
    }
}
