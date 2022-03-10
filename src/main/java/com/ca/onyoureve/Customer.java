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

import java.util.*;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class will store the customer's information when he decides to book an event.
// The information will be stored in DBCustomer
// Initially user is given password by default which they can edit later on
// The next time user logs in, they can do it by entering their id and pass
// Customer -> DBCustomer
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Customer
{
    private String name;
    private String nid;
    private int age;
    private String contact_info;
    private String email_address;
    private String account_number;
    private int priority_status;

    public Customer()
    {
        this.name = "";
        this.nid = "";
        this.age = 0;
        this.contact_info = "";
        this.email_address = "";
        this.account_number = "";
        this.priority_status = 0;
    }

    public Customer(String name, String nid, int age, String contact_info, String email_address, String account_number, int priority_status)
    {
        this.name = name;
        this.nid = nid;
        this.age = age;
        this.contact_info = contact_info;
        this.email_address = email_address;
        this.account_number = account_number;
        this.priority_status = priority_status;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getnid()
    {
        return nid;
    }
    public void setnid(String nid)
    {
        this.nid = nid;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public String getContact_info()
    {
        return contact_info;
    }
    public void setContact_info(String contact_info)
    {
        this.contact_info = contact_info;
    }

    public String getEmail_address()
    {
        return email_address;
    }
    public void setEmail_address(String email_address)
    {
        this.email_address = email_address;
    }

    public String getAccount_number()
    {
        return account_number;
    }
    public void setAccount_number(String account_number)
    {
        this.account_number = account_number;
    }

    public int getPriority_status()
    {
        return priority_status;
    }
    public void setPriority_status(int priority_status)
    {
        this.priority_status = priority_status;
    }

    public void display() {
        System.out.print("Name: ");
        System.out.println(name);

        System.out.print("Age: ");
        System.out.println(age);

        System.out.print("Phone number ");
        System.out.println(contact_info);

        System.out.print("Email: ");
        System.out.println(email_address);

        System.out.print("nid: ");
        System.out.println(nid);

        System.out.print("Account Number: ");
        System.out.println(account_number);

        System.out.print("Priority Status: ");
        System.out.println(priority_status);
    }

    ///////////// CUSTOMER DATABASE ACCESS METHODS BEING CALLED //////////////

    // Customer creating their account with default password
    public void createCustomerAccount()
    {
        DBCustomer obj = new DBCustomer();
        obj.insertCustomer();
    }

    // Customer creating their account with custom password
    public String createCustomerAccountWithPass(String pass)
    {
        DBCustomer obj = new DBCustomer();
        return obj.insertCustomerWithPassword(this, pass);
    }

    // Customer editing their account
    public void editCustomerAccount(String id)
    {
        DBCustomer obj = new DBCustomer();
        obj.editCustomer(id);
    }

    // Customer editing their account
    public void editCustomerAccountWithObj(String id)
    {
        DBCustomer obj = new DBCustomer();
        obj.editCustomer(this, id);
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
        this.setnid(temp.getnid());
        this.setEmail_address(temp.getEmail_address());
        this.setAccount_number(temp.getAccount_number());
        this.setAge(temp.getAge());
        this.setContact_info(temp.getContact_info());
        this.setPriority_status(temp.getPriority_status());
    }

    // resetting customer object
    public void clear() {
        this.name = "";
        this.nid = "";
        this.age = 0;
        this.contact_info = "";
        this.email_address = "";
        this.account_number = "";
        this.priority_status = 0;
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