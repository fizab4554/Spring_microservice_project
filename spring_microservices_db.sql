create database rest_jpa_db;
use rest_jpa_db;

create table student11 (
stdId int primary key,
stdName varchar(20),
courseId int);

insert into student11 values(1,"likitha",101);
insert into student11 values(2,"keerti",102);
insert into student11 values(3,"yashaswini",101);
insert into student11 values(4,"Ananya",103);
insert into student11 values(5,"Suraj",104);
insert into student11 values(6,"Harshad",104);


create table course(
courseId int primary key,
courseName varchar(20));

insert into course values(101,"BCA");
insert into course values(102,"BBA");
insert into course values(103,"BSC");
insert into course values(104,"MCA");

select* from student11;
select* from course;
