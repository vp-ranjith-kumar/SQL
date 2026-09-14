set serveroutput on;
declare
    n number(2);
    i number(2);
    s number(5);
begin
    n := &n;
    s := 0;
    i := 1;
    while i <= n loop
        s := s + i;
        i := i + 1;
    end loop;
    dbms_output.put_line('Sum of ' || n || ' natural numbers : ' || s);
end;