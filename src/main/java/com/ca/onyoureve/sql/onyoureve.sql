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

create  database if not exists onyoureve;
use onyoureve;

create table  customer (
    customer_id char(5) AUTO_INCREMENT PRIMARY KEY,
    name varchar(30),
    email varchar(20),
    phone_no varchar(30),
    age double,
    address varchar(30),
    nid varchar(30),
    membership_status numeric(20,0)
    acc_no varchar(20),
    )



ALTER TABLE customer
    ADD CONSTRAINT emailvalidation
        CHECK (email REGEXP "^[a-zA-Z0-9][a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]*?[a-zA-Z0-9._-]?@[a-zA-Z0-9][a-zA-Z0-9._-]*?[a-zA-Z0-9]?\\.[a-zA-Z]{2,63}$");

create table customerpass (
    customer_id char(5) PRIMARY KEY,
    password varchar(30)
    )

alter customerpassword
add constraint fk_customer_id foreign key (customer_id) references customer(customer_id);


create table employee (
                          employee_id char(5) AUTO_INCREMENT PRIMARY KEY,
                          name varchar(30),
                          dob date,
                          phone_no varchar(30),
                          email varchar(30) UNIQUE,
                          nid varchar(20),
                          acc_no varchar(20),
                          emp_type varchar(10),
                          salary_rate numeric(10),
                          address numeric(10),
                          mgr_id char(5) REFERENCES employee(emp_id)
);

alter table employee
add constraint emailvalidation;


