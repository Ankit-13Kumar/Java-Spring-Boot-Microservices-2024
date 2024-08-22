

--Added data into new database for first time
--Format should be same as Database order and all should be in small letter
insert into user_details(birth_date,id,name)
values(current_date(),121,'Ankit');

insert into user_details(birth_date,id,name)
values(current_date(),122,'Sagar');

insert into user_details(birth_date,id,name)
values(current_date(),123,'Sonam');

--Work well need to use -> user existing id for user

insert into post(id,user_id,description)
values(12,121,'Sonam Know Everythin');

insert into post(id,user_id,description)
values(14,121,'Sonam Know Everything');
