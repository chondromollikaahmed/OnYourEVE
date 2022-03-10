/*
 * *
 *  * Created by JehadurRE on 3/9/22, 4:18 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 3/9/22, 4:16 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/sql/onyourevev2.sql
 *  *OnYourEVE
 *
 */



create database  onyourevev2;
use onyourevev2;
create table customer (
                          cust_id char(5) PRIMARY KEY,
                          name varchar(30),
                          nid varchar(20),
                          age double,
                          phone_no varchar(30),
                          email varchar(30),
                          account_number varchar(20),
                          priority_status numeric(38,0)
);




create table customerPass (
                              cust_id char(5) PRIMARY KEY,
                              password varchar(30)
);


ALTER TABLE customerPass
    ADD FOREIGN KEY (cust_id) REFERENCES Customer(cust_id);




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



create table employeePass (
                              emp_id char(5) PRIMARY KEY,
                              password varchar(30)
);

ALTER TABLE employeePass
    ADD FOREIGN KEY (emp_id) REFERENCES Employee(emp_id);




create table menu (
                      menu_id char(5) PRIMARY KEY,
                      rice varchar(100),
                      bread varchar(100),
                      protein varchar(100),
                      coke tinyint,
                      mirinda tinyint,
                      sprite tinyint,
                      water tinyint,
                      dryfruit tinyint,
                      sugarfree tinyint,
                      icecream tinyint,
                      cake tinyint,
                      cost numeric(38,0)
);



create table studio (
                        studio_id char(5) PRIMARY KEY,
                        name varchar(30),
                        contact_info varchar(30),
                        cost numeric(38,0)
);



create table venue (
                       venue_id char(5) PRIMARY KEY,
                       name varchar(20),
                       location varchar(50),
                       address varchar(100),
                       max_capacity numeric(38,0),
                       description varchar(200),
                       category varchar(30),
                       contact_info varchar(30),
                       cost numeric(38,0)
);


create table media_requirements (
                                    media_id char(5) PRIMARY KEY,
                                    photography tinyint,
                                    videography tinyint,
                                    album tinyint,
                                    drone tinyint,
                                    crane tinyint
);




create table event (
                       event_id char(5) PRIMARY KEY,
                       name varchar(30),
                       type varchar(30),
                       event_date date,
                       guests numeric,
                       total_cost numeric,
                       starting_time varchar(30),
                       ending_time varchar(30),
                       cust_id char(5),
                       venue_id char(5),
                       studio_id char(5),
                       menu_id char(5),
                       catering_id char(5),
                       media_id char(5),
                       approved tinyint
);

ALTER TABLE event
    ADD FOREIGN KEY (cust_id) REFERENCES customer(cust_id);

ALTER TABLE event
    ADD FOREIGN KEY (venue_id) REFERENCES venue(venue_id);

ALTER TABLE event
    ADD FOREIGN KEY (studio_id) REFERENCES studio(studio_id);

ALTER TABLE event
    ADD FOREIGN KEY (menu_id) REFERENCES menu(menu_id);

ALTER TABLE event
    ADD FOREIGN KEY (catering_id) REFERENCES catering(catering_id);

ALTER TABLE event
    ADD FOREIGN KEY (media_id) REFERENCES media_requirements(media_id);