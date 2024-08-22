package com.dxc.RestApi.Social_Media_RestApi.SpringBoot_JPA;

import com.dxc.RestApi.Social_Media_RestApi.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//For DataBase
public interface Post_Repository extends JpaRepository<Post,Integer> {

}
