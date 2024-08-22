package com.dxc.RestApi.Social_Media_RestApi.SpringBoot_JPA;

import com.dxc.RestApi.Social_Media_RestApi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//For DataBase
public interface User_Repository extends JpaRepository<User,Integer> {

}
