/*
 * *
 *  * Created by JehadurRE on 2/17/22, 4:33 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/17/22, 4:33 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/sql/onyoureveMSSQL.sql
 *  *OnYourEVE
 *
 */


drop database if exists onyoureve;

SELECT *
FROM SYS.DATABASES
create database onyoureve;
use onyoureve;

create table customer
(
    customer_id       int IDENTITY (1,1) PRIMARY KEY,
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
    employee_id int IDENTITY (1,1) PRIMARY KEY,
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


create table media_requirements
(
    media_id    int IDENTITY (1,1) PRIMARY KEY,
    photography tinyint,
    videography tinyint,
    album       tinyint,
    drone       tinyint,
    crane       tinyint
);


create table catering
(
    catering_id int identity (1,1) PRIMARY KEY,
    name        varchar(30),
    contact     varchar(30),
    specialty   varchar(30),
    days        numeric(38, 0),
    charges     numeric(38, 0)
);


create table menu
(
    menu_id   int IDENTITY (1,1) PRIMARY KEY,
    rice      varchar(100),
    bread     varchar(100),
    protein   varchar(100),
    coke      tinyint,
    miranda   tinyint,
    sprite    tinyint,
    water     tinyint,
    dryfruit  tinyint,
    sugarfree tinyint,
    icecream  tinyint,
    cake      tinyint,
    cost      numeric(38, 0)
);


create table studio
(
    studio_id    int identity (1,1) PRIMARY KEY,
    name         varchar(30),
    contact_info varchar(30),
    cost         numeric(38, 0)
);

create table venue
(
    venue_id     int identity (1,1) PRIMARY KEY,
    name         varchar(20),
    location     varchar(50),
    address      varchar(100),
    max_capacity numeric(38, 0),
    description  varchar(200),
    category     varchar(30),
    contact_info varchar(30),
    cost         numeric(38, 0)
);

drop table event;
create table event
(
    event_id      int identity (1,1) PRIMARY KEY,
    name          varchar(30),
    type          varchar(30),
    event_date    date,
    guests        numeric,
    total_cost    numeric,
    starting_time varchar(30),
    ending_time   varchar(30),
    cust_id       int,
    venue_id      int,
    studio_id     int,
    menu_id       int,
    catering_id   int,
    media_id      int,
    approved      tinyint
);



ALTER TABLE event
    ADD FOREIGN KEY (cust_id) REFERENCES customer (customer_id);

ALTER TABLE event
    ADD FOREIGN KEY (venue_id) REFERENCES venue (venue_id);

ALTER TABLE event
    ADD FOREIGN KEY (studio_id) REFERENCES studio (studio_id);

ALTER TABLE event
    ADD FOREIGN KEY (menu_id) REFERENCES menu (menu_id);

ALTER TABLE event
    ADD FOREIGN KEY (catering_id) REFERENCES catering (catering_id);

ALTER TABLE event
    ADD FOREIGN KEY (media_id) REFERENCES media_requirements (media_id);