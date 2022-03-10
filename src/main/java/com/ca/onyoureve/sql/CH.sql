create database  Garbage;
use  Garbage;


create table EmployeeDetails
(

    EmpId         int,
    FullName      varchar(50),
    ManagerId     int,
    DateOfJoining date,
    City          varchar(50),
    primary key (EmpId)

)


create table EmployeeSalary
(
    EmpId    int,
    Project  varchar(20),
    Salary   int,
    Variable int
)

delete
from EmployeeDetails;
insert into EmployeeDetails
values (121, 'John Doe', 321, '2014-01-31', 'Toronto'),
       (321, 'Samanta Simpson', 986, '2015-01-30', 'California'),
       (421, 'kuldep rana', 876, '2016-11-27', 'New Delhi'),
       (621, 'James Hoog', 598, '2010-08-17', 'Miami'),
       (821, 'Nail Knite', 621, '2017-09-10', 'Orlando'),
       (221, 'Pit Alex', 986, '2018-07-27', 'Las Vegas'),
       (521, 'Mc Lion', 889, '2018-09-10', 'California'),
       (921, 'Paul Adam', 489, '2012-10-10', 'Las Vegas'),
       (131, 'Lausen Hen', 115, '2018-10-10', 'California'),
       (531, 'Albert Thomson', 921, '2015-06-27', 'Orlando'),
       (631, 'Robert Ford', 321, '2017-01-31', 'Torento'),
       (831, 'Alex Gomez', 321, '2016-04-25', 'Torento')


insert into EmployeeSalary
values (121, 'P1', 8000, 500),
       (321, 'P2', 10000, 10000),
       (421, 'P1', 12000, 0),
       (121, 'P3', 20000, 600),
       (921, 'P3', 10000, 100),
       (321, 'P2', 15000, 300)
--
-- update EmployeeSalary
-- set Project='P1'
-- where EmpId = 121

select *
from EmployeeDetails;
select *
from EmployeeSalary;


-- -- 1st question
-- 1. From the following table, write an SQL query to fetch employee ids having a
-- salary greater than or equal to 5000 and less than or equal to 10000 and who
-- work on Project other than P1. Return employee id, project.

select EmpId, Project
from EmployeeSalary
where (Salary >= 5000 and Salary <= 10000)
  and Project != 'p1'


/*
 * *
 *  * Created by JehadurRE on 3/8/22, 2:29 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 3/8/22, 2:28 PM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/sql/CH.sql
 *  *OnYourEVE
 *
 */


-- --2nd question
-- 2. From the following table, write an SQL query to find the employee ids who get
-- more than the average of total salary (total salary = salary+variable). Return
-- employee id, employee salary.


select *
from EmployeeSalary
select EmpId, Salary,Variable
From EmployeeSalary
where Salary >=
      (select avg(Salary + Variable) as Average from EmployeeSalary)


-- select EmpId, count(EmpId) as Count
-- from EmployeeSalary
-- group by EmpId
-- having count(EmpId) > 1



-- --3rd question
--     3. From the following table, write an SQL query to find the employees who are
--     assigned to more than 2 projects. Return employee name, count.


-- without using join
select FullName, count(EmployeeSalary.EmpId) as count
from EmployeeDetails,
     EmployeeSalary
where EmployeeDetails.empid = EmployeeSalary.empid
group by FullName, EmployeeDetails.EmpId
having count(EmployeeSalary.EmpId) > 1
;


--using join
select FullName, count(EmployeeSalary.EmpId) as count
from EmployeeDetails
         right join EmployeeSalary on EmployeeDetails.EmpId = EmployeeSalary.EmpId
group by FullName, EmployeeDetails.EmpId
having count(EmployeeSalary.EmpId) > 0



select *
from EmployeeDetails
         left join EmployeeSalary on EmployeeDetails.EmpId = EmployeeSalary.EmpId




-- --4th question
--     4. From the following table, write an SQL query to fetch all the Employees who
-- are also managers and have been working in this company for more than 4
-- years. Return employee id, employee name.


select *
from EmployeeDetails
SELECT EmployeeDetails.EmpID, EmployeeDetails.FullName
FROM EmployeeDetails as emp
         right JOIN EmployeeDetails
                    ON emp.ManagerId = EmployeeDetails.EmpId
WHERE DATEDIFF(year, emp.DateOfJoining, getdate()) > 4



-- 121 John Doe 321 2014-01-31 Toronto
-- 321 SamanthaSimpson986 2015-01-30 California
-- 421 Kuldeep Rana 876 2016-11-27 New Delhi
-- 621 James Hoog 598 2010-08-17 Miami
-- 821 Nail Knite 621 2017-09-10 Orlando
-- 221 Pit Alex 986 2018-07-27 Las Vegas
-- 521 Mc Lyon 889 2018-09-10 California
-- 921 Paul Adam 489 2012-10-10 Las Vegas
-- 131 Lauson Hen 115 2018-10-10 California
-- 531 Albert Thomson 921 2015-06-27 Orlando
-- 631 Robert Ford 567 2015-08-17 Toronto
-- 831 Alex Gomez 867 2016-04-25 Toronto


-- 121 P1 8000 500
-- 321 P2 10000 1000
-- 421 P1 12000 0
-- 121 P3 20000 600
-- 921 P3 10000 100
-- 721 P2 15000 300