/*
 * *
 *  * Created by JehadurRE on 2/15/22, 7:09 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/15/22, 7:09 PM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/Customer.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

public class Customer {
    private String name;
    private String email;
    private String phone_no;
    private int age;
    private String address;
    private String nid;
    private int membership_status;
    private String acc_no;

    public Customer() {
    }

    public Customer(String name, String email, String phone_no, int age, String address, String nid, int membership_status, String acc_no) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.age = age;
        this.address = address;
        this.nid = nid;
        this.membership_status = membership_status;
        this.acc_no = acc_no;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public int getMembership_status() {
        return membership_status;
    }

    public void setMembership_status(int membership_status) {
        this.membership_status = membership_status;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }
}
