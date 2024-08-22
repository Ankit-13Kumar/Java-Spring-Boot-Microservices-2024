
--JDBC -> Write a lot of sql queries ->and write a lot java codes.
--SPRING JDBC -> Write a lot of sql queries ->but lesser code in java.
--JPA -> Do not worry about queries -> Just map entities to tables.
--Spring Data JPA -> Lets make JPA even more simple -> I will take care of everything.
--JPA VS HIBERNATE -> we are just using api and implementing the hibernate.
--direclty we are not using.Hibernate is a implementations of JPA


--Added for JPA learning basics
--For jpa use jpa/h2,web/jdbc dependency
--configure Application properties
--create .sql file in resource
--URL -> http://localhost:8080/h2-console

--id
--name
--author
create table coursenew
(
id bigint not null,
name VARCHAR(255) not null,
author VARCHAR(255) not null,
primary key(id)

);

--SELECT * FROM COURSENEW

--  insert into courseNew(id,name,author)
--  values(19,'ankith','rajvanshi');

--delete from courseNew where id=19;