set serveroutput on;
create table student (
    sno number(3) primary key,
    sname varchar2(15),
    course varchar2(10),
    mark1 number(3),
    mark2 number(3),
    result varchar2(4)
        );
desc student;
select * from student;
declare
    f1 number(3);
    f2 varchar2(20);
    f3 varchar2(13);
    f4 number(3);
    f5 number(3);
    f6 varchar2(4);
    cursor cur_pass is
        select * from student where result = 'pass';
    cursor cur_fail is
        select * from student where result = 'fail';
begin
    open cur_pass;
    dbms_output.put_line('LIST OF STUDENTS WHO HAVE GOT RESULT PASS');
    loop
        fetch cur_pass into f1, f2, f3, f4, f5, f6;
        exit when cur_pass%notfound;
        dbms_output.put_line(f1 || '   ' || f2 || '   ' || f3 || '   ' || f4 || '   ' || f5 || '   ' || f6);
    end loop;
    close cur_pass;

    open cur_fail;
    dbms_output.put_line('LIST OF STUDENTS WHO HAVE GOT RESULT FAIL');
    loop
        fetch cur_fail into f1, f2, f3, f4, f5, f6;
        exit when cur_fail%notfound;
        dbms_output.put_line(f1 || '   ' || f2 || '   ' || f3 || '   ' || f4 || '   ' || f5 || '   ' || f6);
    end loop;
    close cur_fail;
end;
/