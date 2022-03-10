/*
 * *
 *  * Created by JehadurRE on 3/10/22, 9:02 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 3/10/22, 9:02 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/sql/query.sql
 *  *OnYourEVE
 *
 */

create table customer (
                          cust_id char(5) PRIMARY KEY,
                          name varchar(30),
                          nid varchar(20) unique ,
                          age double,
                          phone_no varchar(30),
                          email varchar(30),
                          account_number varchar(20),
                          priority_status numeric(38,0)
);



alter table  customer
    add constraint phone_no_check
        check (REGEXP_LIKE(phone_no,'^[0-9]{11}$'));



ALTER TABLE customer
    ADD CONSTRAINT emailvalidation
        CHECK (email LIKE '%_@_%._%');


insert into customer(cust_id, name, nid, age, phone_no, email, account_number, priority_status)
values('601', 'Chondromollika Ahmed', '6666666', 23, '01993522240', 'chondromollikaahmed@gmail.com', '666666', 1);



insert into customer(cust_id, name, nid, age, phone_no, email, account_number, priority_status)
values('602', 'Ahmed Chondromollika', '88888', 22, '01993522240', '190104082@aust.edu', '88888', 2);


insert  into customer(cust_id, name, nid, age, phone_no, email, account_number, priority_status)
values('603', 'Ahmed Chondro', '688888', 24, '01993522240', 'ahmedchondromollika@gmail.com', '688888', 3);


insert into customer(cust_id, name, nid, age, phone_no, email, account_number, priority_status)
values('604', 'Customer One', '234567', 28, '01732022561', 'customerone@gmail.com', '234567', 1);


insert into customer(cust_id, name, nid, age, phone_no, email, account_number, priority_status)
values('605', 'Customer Two', '25628728', 28, '01723567890', 'customertwo@gmail.com', '234567', 2);



insert into customer(cust_id, name, nid, age, phone_no, email, account_number, priority_status)
values('606', 'Customer Three', '8964532', 28, '01789654320', 'customerthree@gmail.com', '8964532', 3);



create table customerPass (
                              cust_id char(5) PRIMARY KEY,
                              password varchar(30)
);

ALTER TABLE customerPass
    ADD FOREIGN KEY (cust_id) REFERENCES Customer(cust_id);

insert into customerPass(cust_id, password)
values('601', '601');

insert into customerPass(cust_id, password)
values('602', '602');

insert into customerPass(cust_id, password)
values('603', '603');

insert into customerPass(cust_id, password)
values('604', '604');

insert into customerPass(cust_id, password)
values('605', '605');

insert into customerPass(cust_id, password)
values('606', '606');



create table employee (
                          emp_id char(5) PRIMARY KEY,
                          name varchar(30),
                          dob date,
                          email varchar(30),
                          phone_no varchar(30),
                          nid varchar(20),
                          account_number varchar(20),
                          wage_type varchar(10),
                          wage_rate numeric(10),
                          points numeric(10),
                          mgr_id char(5) REFERENCES employee(emp_id)
);


alter table employee
    add constraint emailvalidationemployee
        CHECK (email LIKE '%_@_%._%');

alter table employee
    add constraint phone_no_checkemployee
        check (REGEXP_LIKE(phone_no,'^[0-9]{11}$'));




create table employeePass (
                              emp_id char(5) PRIMARY KEY,
                              password varchar(30)
);

ALTER TABLE employeePass
    ADD FOREIGN KEY (emp_id) REFERENCES Employee(emp_id);




insert into employee(emp_id, name, dob, email, phone_no, nid, account_number, wage_type, wage_rate, points, mgr_id)
values('201', 'Chondromollika Ahmed', '1999-11-25', 'chondromollikaahmed@gmail.com', '01993522240', '9844689', 934545, 'Monthly', 20000, 800, NULL);

insert into employee(emp_id, name, dob, email, phone_no, nid, account_number, wage_type, wage_rate, points, mgr_id)
values('202', 'Ahmed Chondromollika', '1999-11-25', 'ahmedchondromollika@gmail.com', '01993522240', '86785676', 765434567, 'Hourly', 20, 600, '201');

insert into employee(emp_id, name, dob, email, phone_no, nid, account_number, wage_type, wage_rate, points, mgr_id)
values('203', 'EMP ONE ', '1990-11-25', 'empone@gmail.com', '01145678902', '89076577', 456945543, 'Monthly', 1000, 0, '202');

insert into employee(emp_id, name, dob, email, phone_no, nid, account_number, wage_type, wage_rate, points, mgr_id)
values('204', 'EMP TWO', '1996-08-25', 'emptwo@gmail.com', '01189456802', 'Nothing', 65434654, 'Daily', 100, 150, '202');

insert into employee(emp_id, name, dob, email, phone_no, nid, account_number, wage_type, wage_rate, points, mgr_id)
values('205', 'EMP THREE', '1999-11-25', 'IamTrash@gmail.com', '0300-6684727', '144-2948820', '794-3553', 'Daily', 1000, 475, '202');


