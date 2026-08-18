set verify off;
set serveroutput on;
declare 
 string1 varchar2(20); 
 string2 varchar2(20); 
 n number(2); 
 begin 
 string1:='&string1'; 
 n:=length(string1); 
 string2:=''; 
 while n>0 loop 
 string2:=concat(string2,substr(string1,n,1)); 
 n:=n-1; 
 end loop; 
 dbms_output.put_line('Original string : '||string1); 
 dbms_output.put_line('Reversed string : '||string2); 
 end; 
/