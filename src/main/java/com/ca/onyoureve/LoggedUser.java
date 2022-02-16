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

    private static String customer_id;
    private static Customer cust = new Customer();

    private static String employee_id;
    private static Employee emp = new Employee();

    public static String getCustomer_id() {
        return customer_id;
    }

    public static void setCustomer_id(String customer_id) {
        LoggedUser.customer_id = customer_id;
    }

    public static Customer getCust() {
        return cust;
    }

    public static void setCust(Customer cust) {
        LoggedUser.cust = cust;
    }

    public static String getEmployee_id() {
        return employee_id;
    }

    public static void setEmployee_id(String employee_id) {
        LoggedUser.employee_id = employee_id;
    }

    public static Employee getEmp() {
        return emp;
    }

    public static void setEmp(Employee emp) {
        LoggedUser.emp = emp;
    }




    public static void initCust(String idOrEmail) {
        if (idOrEmail.indexOf('@') == -1)
            customer_id = idOrEmail;

        else {
            customer_id = cust.getCustomerIDbyEmail(idOrEmail);
        }

        cust.getCustomerDetails(customer_id);
    }

    public static void clearCust() {
        customer_id = "";
        cust.clear();
    }


    public static void initEmp(String id) {
        employee_id = id;
        emp.getEmployeeRecord(employee_id);
    }

    public static void clearEmp() {
        employee_id = "";
        emp.clear();
    }

}
