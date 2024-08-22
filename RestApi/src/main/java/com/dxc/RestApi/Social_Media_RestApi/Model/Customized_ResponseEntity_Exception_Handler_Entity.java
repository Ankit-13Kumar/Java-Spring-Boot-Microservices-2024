package com.dxc.RestApi.Social_Media_RestApi.Model;

import com.dxc.RestApi.Social_Media_RestApi.Exception.Error_Details_Cutomization;
import com.dxc.RestApi.Social_Media_RestApi.Exception.UserNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*Will get error in postman
        Get - http://localhost:8080/GET/users/76

        {
        "timestamp": "2024-08-06",
        "message": "id:76",
        "details": "uri=/GET/users/76"
        }
       -> After chnaging to LocalDateTime
        {
    "timestamp": "2024-08-06T12:28:38.9164889",
    "message": "id:76",
    "details": "uri=/GET/users/76"
}
*/
//we will overwrite the existing error so we have extends.
//It will not work without annotation
//applicable to all the controller in the project after annotations
@ControllerAdvice
public class Customized_ResponseEntity_Exception_Handler_Entity extends ResponseEntityExceptionHandler {

    //Copy from extend ctrl+click on extend then go and copy
    //Change the method name same cannot
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error_Details_Cutomization> handleAllException(Exception ex, WebRequest request) throws Exception {
//creating own cutomer error handling
        //Use exception class for creating new object
        Error_Details_Cutomization errorDetails = new Error_Details_Cutomization(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)

        );
        return new ResponseEntity<Error_Details_Cutomization>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    //User not found exception seperate exception we have create
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Error_Details_Cutomization> handleUserNotFoundExceptionException(Exception ex, WebRequest request) throws Exception {
//creating own cutomer error handling
        //Use exception class for creating new object
        Error_Details_Cutomization errorDetails = new Error_Details_Cutomization(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)

        );
        //Row error -> Error_Details_Cutomization
        return new ResponseEntity<Error_Details_Cutomization>(errorDetails, HttpStatus.NOT_FOUND);

    }

    //Validation copy from reponseentityexceptionhanderclass
    //Override the class
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        /*//Added
        Error_Details_Cutomization errorDetails = new Error_Details_Cutomization(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
*/
      //Modify for only required error one line one by one for field

        Error_Details_Cutomization errorDetails = new Error_Details_Cutomization(
                LocalDateTime.now(),
                "Total errors: " + ex.getErrorCount()+ " - First Errors - "+ ex.getFieldError().getDefaultMessage(),
                request.getDescription(false));




        //Added
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
        //To check pass the wrong value will get validation error
        /*
        {
    "timestamp": "2024-08-06T14:09:39.8179",
    "message": "Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.dxc.RestApi.Social_Media_RestApi.Model.User> com.dxc.RestApi.Social_Media_RestApi.Controller_Api.Social_Media_Controller.createUser(com.dxc.RestApi.Social_Media_RestApi.Model.User): [Field error in object 'user' on field 'name': rejected value []; codes [Size.user.name,Size.name,Size.java.lang.String,Size]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [user.name,name]; arguments []; default message [name],2147483647,2]; default message [size must be between 2 and 2147483647]] ",
    "details": "uri=/POST/users"
}
        * */

    }
}