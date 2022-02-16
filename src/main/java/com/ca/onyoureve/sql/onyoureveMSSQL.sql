

/*
 * *
 *  * Created by Chondromollika Ahmed on 2/16/22, 10:08 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/16/22, 10:08 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/onyoureve.sql
 *  *OnYourEVE
 *
 */


drop database if exists onyoureve;

SELECT * FROM SYS.DATABASES
create database  onyoureve;
use onyoureve;

create table customer
(
    customer_id       int IDENTITY(1,1) PRIMARY KEY,
    name              varchar(30),
    email             varchar(20),
    phone_no          varchar(30),
    age               float,
    address           varchar(30),
    nid               varchar(30),
    membership_status numeric(20, 0),
    acc_no            varchar(20)
);



ALTER TABLE customer
    ADD CONSTRAINT emailvalidation
        CHECK (email LIKE '%_@_%._%');

create table customerpass
(
    customer_id int PRIMARY KEY,
    password    varchar(30)
);

drop table customerpass;

alter table customerpass
    add constraint fk_customer_id foreign key (customer_id) references customer (customer_id);



create table employee
(
    employee_id int IDENTITY(1,1) PRIMARY KEY,
    name        varchar(30),
    dob         date,
    phone_no    varchar(30),
    email       varchar(30) UNIQUE,
    nid         varchar(20),
    acc_no      varchar(20),
    emp_type    varchar(10),
    salary_rate numeric(10),
    address     numeric(10),
    mgr_id      int REFERENCES employee (employee_id)
);

alter table employee
    add constraint emailvalidationemployee
        CHECK (email LIKE '%_@_%._%');

create table employeepass
(
    employee_id int PRIMARY KEY,
    password    varchar(30)
);

alter table employeepass
    add constraint fk_employee_id foreign key (employee_id) references employee (employee_id);