/*
 * *
 *  * Created by Chondromollika Ahmed on 2/17/22, 3:09 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/17/22, 3:09 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/LoggedUser.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

public class LoggedUser {

    private static String cust_id;
    private static Customer cust = new Customer();

    private static String emp_id;
    private static Employee emp = new Employee();

    ////////////// CUST METHODS ////////////////////

    public static String getCust_id() {
        return cust_id;
    }
    public static void setCust_id(String cust_id) {
        LoggedUser.cust_id = cust_id;
    }

    public static void initCust(String idOrEmail) {
        if (idOrEmail.indexOf('@') == -1)
            cust_id = idOrEmail;

        else {
            cust_id = cust.getCustomerIDbyEmail(idOrEmail);
        }

        cust.getCustomerDetails(cust_id);
    }

    public static void clearCust() {
        cust_id = "";
        cust.clear();
    }

    public static Customer getCust() {
        return cust;
    }
    public static void setCust(Customer cust) {
        LoggedUser.cust = cust;
    }

    ///////////// EMP METHODS //////////////////

    public static String getEmp_id() {
        return emp_id;
    }
    public static void setEmp_id(String emp_id) {
        LoggedUser.emp_id = emp_id;
    }

    public static Employee getEmp() {
        return emp;
    }
    public static void setEmp(Employee emp) {
        LoggedUser.emp = emp;
    }

    public static void initEmp(String id) {
        emp_id = id;
        emp.getEmployeeRecord(emp_id);
    }

    public static void clearEmp() {
        emp_id = "";
        emp.clear();
    }



}
