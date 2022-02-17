/*
 * *
 *  * Created by JehadurRE on 2/17/22, 9:59 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/17/22, 9:59 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/MCustomer.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

public class MCustomer {
    private int customer_id;
    private String name;
    private String email;
    private String phone_no;
    private double age;
    private String address;
    private String nid;
    private String membership_status;
    private String acc_no;

    public MCustomer(int customer_id, String name, String email, String phone_no, double age, String address, String nid, String membership_status, String acc_no) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.age = age;
        this.address = address;
        this.nid = nid;
        this.membership_status = membership_status;
        this.acc_no = acc_no;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getMembership_status() {
        return membership_status;
    }

    public void setMembership_status(String membership_status) {
        this.membership_status = membership_status;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }
}
