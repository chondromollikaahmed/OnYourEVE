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

import java.util.Scanner;

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




    ///////////// CUSTOMER DATABASE ACCESS METHODS BEING CALLED //////////////

    // Customer creating their account with default password
    public void createCustomerAccount()
    {
        DBCustomer obj = new DBCustomer();
    }

    // Customer creating their account with custom password
    public String createCustomerAccountWithPass(String pass)
    {
        DBCustomer obj = new DBCustomer();
        return null;
    }

    // Customer editing their account
    public void editCustomerAccount(String id)
    {
        DBCustomer obj = new DBCustomer();
    }

    // Customer editing their account
    public void editCustomerAccountWithObj(String id)
    {
        DBCustomer obj = new DBCustomer();
      //  obj.editCustomer(this, id);
    }

    // edit one field
    public void editCustomerAccountField(String id, String field, String new_value) {
        DBCustomer obj = new DBCustomer();
        obj.updateField(id,field,new_value);
    }

    // Customer deleting their account
    public void deleteCustomerAccount()
    {
        DBCustomer obj = new DBCustomer();
        String id;
        System.out.print("Deleting your account. Enter your customer id: ");
        Scanner input = new Scanner(System.in);
        id = input.nextLine();

        obj.removeCustomer(id);
    }

    // Customer logging in - returns true or false
    public boolean customerLogin(String id, String pass) {
        DBCustomer obj = new DBCustomer();
        return obj.customerLogin(id, pass);
    }

    // Customer changing password
    public void changePassword() {
        String id, old_pass, new_pass;

        Scanner input = new Scanner(System.in);

        System.out.print("Changing password. Enter your customer ID: ");
        id = input.nextLine();

        System.out.print("Enter your current password: ");
        old_pass = input.nextLine();

        System.out.print("Enter your new password: ");
        new_pass = input.nextLine();

        DBCustomer obj = new DBCustomer();
        obj.changeCustomerPassword(id, old_pass, new_pass);
    }

    // Customer changing password
    public boolean changePassword(String id, String old_pass, String new_pass) {
        DBCustomer obj = new DBCustomer();
        return obj.changeCustomerPassword(id, old_pass, new_pass);
    }

    // Changing password without comparing
    public void changePassword(String id, String new_pass) {
        DBCustomer obj = new DBCustomer();
        obj.changeCustomerPassword(id, new_pass);
    }

    // Filling Customer object from db
    public void getCustomerDetails(String id) {
        DBCustomer obj = new DBCustomer();
        Customer temp = obj.getCustomer(id);

        this.setName(temp.getName());
        this.setNid(temp.getNid());
        this.setEmail(temp.getEmail());
        this.setPhone_no(temp.getPhone_no());
        this.setAge(temp.getAge());
        this.setAddress(temp.getAddress());
        this.setMembership_status(temp.getMembership_status());
        this.setAcc_no(temp.getAcc_no());

    }

    // resetting customer object
    public void clear() {
        this.name = "";
        this.nid = "";
        this.email = "";
        this.phone_no = "";
        this.age = 0;
        this.address = "";
        this.membership_status = 0;
        this.acc_no = "";

    }

    // provide email, get ID
    public String getCustomerIDbyEmail(String email) {
        DBCustomer obj = new DBCustomer();
        return obj.getCustomerIDbyEmail(email);
    }

    // provide ID, get email
    public String getCustomerEmailByID(String id) {
        DBCustomer obj = new DBCustomer();
        return obj.getCustomerEmailByID(id);
    }

    // check if the email is already registered (returns true if it does)
    public static boolean checkIfEmailRegistered(String email) {
        DBCustomer obj = new DBCustomer();
        return !(obj.getCustomerByEmail(email).getName().isEmpty());
    }
}
