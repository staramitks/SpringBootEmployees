create tabe employee(
Id varchar2(10) not null,
Name varchar2(40) not null,
Salary Number(10,0) not null,
Age Number(2,0) not null,
Designation varchar2(20) not null,
Constraint employee_pk primary key (Id)
);