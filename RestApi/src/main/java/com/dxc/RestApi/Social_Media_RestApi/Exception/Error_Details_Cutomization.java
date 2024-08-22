package com.dxc.RestApi.Social_Media_RestApi.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

//Creating customize error details
//Before we are getting from spring in postman or web page now manually we are doing

public class Error_Details_Cutomization {
    //TimeStanp
    //Error Message
    //Details

    private LocalDateTime timestamp;
    private String message;
    private String details;

    //Getter
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    public String getMessage(){
        return message;
    }
    public String getDetails(){
        return details;
    }


    //Constructor
    public Error_Details_Cutomization(LocalDateTime timestamp, String message, String details){
        super();
        this.timestamp= timestamp;
        this.message=message;
        this.details=details;
    }
}
