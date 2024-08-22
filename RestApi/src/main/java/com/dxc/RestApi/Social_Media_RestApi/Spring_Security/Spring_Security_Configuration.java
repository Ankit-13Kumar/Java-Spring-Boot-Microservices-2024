package com.dxc.RestApi.Social_Media_RestApi.Spring_Security;

//import jakarta.servlet.http.HttpFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;


//Import static methods
//import static org.springframework.security.config.Customizer.withDefaults;

/*Hide it not working need to check getting error on ui page */

//@Configuration
//public class Spring_Security_Configuration {

//    Need to check not working properly

    /*
    * Spring Security
    * Filter Chains
    * All request should be authenticated
    * If a request is not authenticated, a web page is shown
    * CSRF ->POST,PUT
    * CONFIGURATION
    * Bean FilterChain
    * */

    //  @Bean
    //public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    //All request should be authenticated
    // Access will denied on web page after this
    /* http.authorizeHttpRequests(
             auth -> auth.anyRequest().authenticated()
     );*/

    //If a request is not authenticated, a web page is shown
    //  It will ask pop up for user and password
        //http.httpBasic(withDefaults());

    // CSRF ->POST,PUT
//        pop up removed
//          Depriacated -> http.csrf().disable();
//        http.csrf().disable();
//        http.csrf(AbstractHttpConfigurer::disable);

       // return http.build();
//    }
//
//
//}
