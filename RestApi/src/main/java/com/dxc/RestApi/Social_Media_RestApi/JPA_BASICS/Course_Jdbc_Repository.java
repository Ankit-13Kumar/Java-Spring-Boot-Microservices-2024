package com.dxc.RestApi.Social_Media_RestApi.JPA_BASICS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class Course_Jdbc_Repository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                          insert into courseNew(id,name,author)
                     /*   values(1,'IITIAN','vanshi'); */
                             values(?,?,?);
                    """;

    private static String DELETE_QUERY =
            """
                          delete from courseNew where id=?
                    """;

    private static String SELECT_QUERY =
            """
                          select * from courseNew where id = ?
                    """;

    //either use autowired or constructor ->Getting null error so added constructor
//    public Course_Jdbc_Repository(JdbcTemplate springJdbcTemplate) {
//        this.springJdbcTemplate = springJdbcTemplate;
//    }

//    public void insert(){
//        springJdbcTemplate.update(INSERT_QUERY);
//    }

    public void insert(Course course) {
//        springJdbcTemplate.update(INSERT_QUERY);
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    //    Delete 120 ID
    public void deleteById(Long id) {
//        springJdbcTemplate.update(INSERT_QUERY);
        springJdbcTemplate.update(DELETE_QUERY, id);

    }

    public Course findById(Long id) {
        //ResultSet ->Bean -> Row Mapper ->
        // Id
       return springJdbcTemplate.queryForObject(SELECT_QUERY,
               new BeanPropertyRowMapper<>(Course.class), id);
//column name should match with row value

    }


}




