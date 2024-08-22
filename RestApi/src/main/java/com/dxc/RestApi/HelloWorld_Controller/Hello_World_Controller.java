package com.dxc.RestApi.HelloWorld_Controller;

import org.hibernate.boot.model.internal.XMLContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Hello_World_Controller {

    //Added for language and created constructor as well
    private MessageSource messageSource;
    public Hello_World_Controller(MessageSource messageSource){
      this.messageSource=messageSource;
    }

    //hello-world
    @GetMapping("/hello-world")
    public String HelloWorld1(){
        return "Hello Ankit";
    }

           //JSON value return
            /*
            Steps:
            Return Bean
            create class(HelloWorldBean)
            create private entity and pass message
            Pass Constructor
            Getter & setter
            ToStringMethod
            */
//    Created Bean and Return Bean || JSON RESPONSE
    @GetMapping("/hello-world-bean")
    public HelloWorldBean HelloWorld(){
        return new HelloWorldBean("Hello Ankit");
    }

    /*Path parimeters Link need to build
    /user/{id}/todos/{id} -/user/2/todos/56
    /hellow-world/path-variable/{name}
    */

    //http://localhost:8080/hello-world/path-variable/ankit
    //{Name} and path variable name should be same as and passing in string formet
    @GetMapping("/hello-world/path-variable/{name}")
    public String HelloWorldPathVariable(@PathVariable String name){
        return name;
    }


    //i18n for d/f language
   /* Eg - en - English (Good Morning)
    Eg - fr - Franch (Bonjour)*/
    //Created messages.properties in resource and added line
    @GetMapping("/hello-world-Internationalized")
    public String HelloWorldInternationalization(){
        //created messagesource above and using here
        //created local we have pass
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage(
                "good.morning.message",null,"Default Message",locale);
       // return "Hello Ankit";
    }

}
