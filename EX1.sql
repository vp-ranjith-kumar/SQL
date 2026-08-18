create table student(sno number(3) primary key,sname varchar2(15), course varchar2(10), mark1 number(3),mark2 number(3));
desc student;
alter table student add result varchar2(4);
desc student;
alter table student modify course varchar2(15);
desc student; 
alter table student drop column result; 
desc student;
rename student to cs_student;
desc student;
desc cs_student;
insert into cs_student values(1,'Robert','IIBSC',50,60); 
insert into cs_student values(2,'James','IBSC',80,60); 
select * from student;
truncate table cs_student;
select * from cs_student;
drop table cs_student; 
desc cs_student; 

