set verify off;
set serveroutput on;
declare 
 n number(2); 
 i number(2); 
 fact number(7); 
 begin 
 n:=&n; 
 fact:=1; 
 i:=1; 
 while i<=n loop 
 fact:=fact*i; 
 i:=i+1; 
 end loop; 
 dbms_output.put_line('Factorial of '||n||' = '||fact); 
 end; 
/