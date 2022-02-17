/*
 * *
 *  * Created by JehadurRE on 2/17/22, 10:04 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/17/22, 10:04 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/MEmployee.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

public class MEmployee {
    private int emplyee_id;
    private String name;
    private String dob;
    private String phone_no;
    private String email;
    private String nid;
    private String acc_no;
    private String emp_type;
    private double salary_rate;
    private String address;
    private String mgr_id;

    public MEmployee(int emplyee_id, String name, String dob, String phone_no, String email, String nid, String acc_no, String emp_type, double salary_rate, String address, String mgr_id) {
        this.emplyee_id = emplyee_id;
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
    }

    public int getEmplyee_id() {
        return emplyee_id;
    }

    public void setEmplyee_id(int emplyee_id) {
        this.emplyee_id = emplyee_id;
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

    public double getSalary_rate() {
        return salary_rate;
    }

    public void setSalary_rate(double salary_rate) {
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
}
