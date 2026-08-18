set verify off;
set serveroutput on;
declare 
 n number(2); 
 i number(2); 
 f1 number(3); 
 f2 number(3); 
 next number(3); 
 begin 
 n:=&n; 
 f1:=0; 
 f2:=1; 
 i:=0; 
 dbms_output.put_line('Fibonacci series'); 
 while i<=n loop 
 dbms_output.put_line(f1); 
 next:=f1+f2; 
 f1:=f2; 
 f2:=next; 
 i:=i+1; 
 end loop; 
 end;
/