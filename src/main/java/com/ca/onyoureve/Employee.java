/*
 * *
 *  * Created by JehadurRE on 2/16/22, 1:50 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/16/22, 1:50 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/Employee.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    protected String employee_id;                 //5-digit unique id
    protected String name;
    protected String dob;
    protected String phone_no;
    protected String email;
    protected String nid;
    protected String acc_no;          //Bank Details
    protected String emp_type;               //Hourly/Daily/Monthly
    protected int salary_rate;
    protected String address;
    protected String mgr_id;
    String fname, lname;

    public Employee() {
        this.employee_id = "";
        this.name = "";
        this.dob = "";
        this.phone_no = "";
        this.email = "";
        this.nid = "";
        this.acc_no = "";
        this.emp_type = "";
        this.salary_rate = 0;
        this.address = "";
        this.mgr_id = "";
        this.fname = "";
        this.lname = "";
    }

    public Employee(String employee_id, String name, String dob, String phone_no, String email,
                    String nid, String acc_no, String emp_type, int salary_rate, String address, String mgr_id) {
        this.employee_id = employee_id;
        this.name = name;
        this.dob = dob;
        this.phone_no = phone_no;
        this.email = email;
        this.nid = nid;
        this.acc_no = acc_no;
        this.emp_type = emp_type;
        this.salary_rate = salary_rate;
        this.address = address;
        this.mgr_id = mgr_id;
        fname = name.contains(" ") ? name.split(" ")[0] : name;
        lname = name.contains(" ") ? name.split(" ")[1] : "";
    }

    public Employee(String name, String dob, String phone_no, String email,
                    String nid, String acc_no, String emp_type, int salary_rate, String address, String mgr_id) {
        this.name = name;
        this.dob = dob;
        this.phone_no = phone_no;
        this.email = email;
        this.nid = nid;
        this.acc_no = acc_no;
        this.emp_type = emp_type;
        this.salary_rate = salary_rate;
        this.address = address;
        this.mgr_id = mgr_id;
        fname = name.contains(" ") ? name.split(" ")[0] : name;
        lname = name.contains(" ") ? name.split(" ")[1] : "";
    }

    public Employee(Employee emp) {
        this.employee_id = emp.getEmployee_id();
        this.name = emp.getName();
        this.dob = emp.getDob();
        this.phone_no = emp.getPhone_no();
        this.email = emp.getEmail();
        this.nid = emp.getNid();
        this.acc_no = emp.getAcc_no();
        this.emp_type = emp.getEmp_type();
        this.salary_rate = emp.getSalary_rate();
        this.address = emp.getAddress();
        this.mgr_id = emp.getMgr_id();
        fname = name.contains(" ") ? name.split(" ")[0] : name;
        lname = name.contains(" ") ? name.split(" ")[1] : "";
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public int getSalary_rate() {
        return salary_rate;
    }

    public void setSalary_rate(int salary_rate) {
        this.salary_rate = salary_rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(String mgr_id) {
        this.mgr_id = mgr_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    //unnessesary
    //......
    ////////// CALLING DATABASE METHODS /////////////

    public void getEmployeeRecord(String id) {
        DBEmployee obj = new DBEmployee();
        Employee emp = obj.getEmployee(id);
        this.employee_id = emp.getEmployee_id();
        this.name = emp.getName();
        this.dob = emp.getDob();
        this.phone_no = emp.getPhone_no();
        this.email = emp.getEmail();
        this.nid = emp.getNid();
        this.acc_no = emp.getAcc_no();
        this.emp_type = emp.getEmp_type();
        this.salary_rate = emp.getSalary_rate();
        this.address = emp.getAddress();
        this.mgr_id = emp.getMgr_id();
    }

    public void editEmployee() {
        DBEmployee obj = new DBEmployee();
     //  obj.editEmployee(this.employee_id);
    }
    // Employee logging in

    public boolean employeeLogin(String id, String pass) {
        DBEmployee obj = new DBEmployee();
        return obj.employeeLogin(id, pass);
    }
    // Employee changing password

    public boolean changePassword(String curr, String neww) {
        DBEmployee obj = new DBEmployee();
        return obj.changeEmployeePassword(employee_id, curr, neww);
    }

    // edit one field
    public void editEmployeeAccountField(String id, String field, String new_value, boolean isNumeric) {
        DBEmployee obj = new DBEmployee();
        obj.updateField(id, field, new_value, isNumeric);
    }

    // reset employee object
    public void clear() {
        this.employee_id = "";
        this.name = "";
        this.dob = "";
        this.phone_no = "";
        this.email = "";
        this.nid = "";
        this.acc_no = "";
        this.emp_type = "";
        this.salary_rate = 0;
        this.address = "";
        this.mgr_id = "";
    }

    // check is an employee is a manager
    public static boolean isManager(String id) {
        DBEmployee obj = new DBEmployee();
        return obj.isManager(id);
    }

    public ArrayList<Employee> getListOfEmployees() {
        DBEmployee obj = new DBEmployee();
        return obj.getAllEmployees();
    }

    public void addEmployee() {
        DBEmployee obj = new DBEmployee();
        employee_id = obj.insertEmployee(this);
    }

    public void deleteEmployee() {
        DBEmployee obj = new DBEmployee();
        obj.removeEmployee(this.employee_id);
    }

    public Employee getEmployee(String id) {
        DBEmployee obj = new DBEmployee();
        return obj.getEmployee(id);
    }

    public static boolean checkIfEmailRegistered(String email) {
        DBEmployee obj = new DBEmployee();
        return !(obj.getEmployeeByEmail(email).getEmployee_id().isEmpty());
    }
}
