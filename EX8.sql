set serveroutput on;
create table emp (
    eno number(3) primary key,
    ename varchar2(20),
    address varchar2(10),
    designation varchar2(12),
    dept varchar2(10),
    salary number(6)
);

desc emp;

create table emp_d (
    eno number(3) primary key,
    ename varchar2(20),
    dept varchar2(10)
);

desc emp_d;

create or replace trigger t1
after insert on emp
for each row
begin
    insert into emp_d values (:new.eno, :new.ename, :new.dept);
    dbms_output.put_line('Inserted into the table emp_d');
end t1;
/

insert into emp values (101, 'ROBERT', 'DELHI', 'MANAGER', 'HR', 45000);
insert into emp values (102, 'JAMES', 'DELHI', 'TEAM LEADER', 'TECH', 40000);

select * from emp;
select * from emp_d;

create or replace trigger t2
after delete on emp
for each row
begin
    delete from emp_d where eno = :old.eno;
    dbms_output.put_line('Deleted record from table emp_d');
end t2;
/

delete from emp where eno = 101;

select * from emp;
select * from emp_d;

create or replace trigger t3
after update on emp
for each row
begin
    update emp_d
    set ename = :new.ename,
        dept = :new.dept
    where eno = :new.eno;
    dbms_output.put_line('Updated record in the table emp_d');
end t3;
/

update emp set dept = 'web design' where eno = 102;

select * from emp;
select * from emp_d;
drop trigger t1;
drop trigger t2;
drop trigger t3;
drop table emp;
drop table emp_d;