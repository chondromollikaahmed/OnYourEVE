/*
 * *
 *  * Created by Chondromollika Ahmed on 2/15/22, 8:46 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/15/22, 8:46 PM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/CustomerDB.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import java.sql.*;

public class DBCustomer {
    Connection con;
    int sqlType = Custom.getSQLtype();
    //1=mysql
    //2=mssql

    public void CreateCustomerTable() {
        try {
            con = ConnectDB.ConnectDb(sqlType);
            String sql = "create table customer (\n" +
                    "customer_id char(5) AUTO_INCREMENT PRIMARY KEY,\n" +
                    "name varchar(30),\n" +
                    "email varchar(20),\n" +
                    "phone_no varchar(30),\n" +
                    "age double,\n" +
                    "address varchar(30),\n" +
                    "nid varchar(30),\n" +
                    "membership_status numeric(20,0)\n" +
                    "acc_no varchar(20),\n" +
                    ")";
            con.prepareStatement(sql).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CreateCustomerpassTable()
    {
        try {
            con = ConnectDB.ConnectDb(sqlType);
            String sql = "create table customerpass (\n" +
                    "customer_id char(5)  PRIMARY KEY,\n" +
                    "password varchar(30)\n" +
                    ")";
            con.prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(String id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - getting a customer");
                String query = "select * from customer where customer_id = " + id;  // query to be sent
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone_no");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    String nid = rs.getString("nid");
                    int ms = rs.getInt("membership_status");
                    String acc_no = rs.getString("acc_no");
                    Customer cust = new Customer(name, email, phone, age, address, nid, ms, acc_no);
                    return cust;
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Customer emptyObj = new Customer();
        return emptyObj;
    }

    public Customer getCustomerByEmail(String email) {
        return getCustomer(email);
    }

    public void insertCustomer(Customer cust) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - inserting customer + id!");
                String query = "insert into customer(name,email,phone_no,age,address,nid,membership_status,acc_no)" +
                        "values('" + cust.getName() + "','" + cust.getEmail() + "','" + cust.getPhone_no() + "','" +
                        cust.getAge() + "','" + cust.getAddress() + "','" + cust.getNid() + "','" +
                        cust.getMembership_status() + "','" + cust.getAcc_no() + "')";
                conn.prepareStatement(query).execute();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCustomer(String id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - deleting customer");
                String query = "delete from customer where customer_id = " + id;
                conn.prepareStatement(query).execute();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns true if password correct against that id, false otherwise
    public boolean customerLogin(String idOrEmail, String pass) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - logging in customer");
                String query;
                if (idOrEmail.indexOf('@') == -1) {
                    query = "SELECT password FROM customerpass WHERE cust_id = \'" + idOrEmail + "\'";
                } else {
                    query = "SELECT password FROM customerpass WHERE customer_id IN " +
                            "(SELECT customer_id FROM customer WHERE email = \'" + idOrEmail + "\')";
                }
                ResultSet rs = conn.prepareStatement(query).executeQuery();
                String db_pass = "";
                while (rs.next()) {
                    db_pass = rs.getString("password");
                    if (pass.equals(db_pass))
                        return true;
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateField(String id, String field, String new_value) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - updating a field for customer");
                String query = "update CUSTOMER set " + field + " = '" + new_value + "' where customer_id = " + id;
                conn.prepareStatement(query).executeUpdate();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Returns true if password changed successfully, false otherwise
    public boolean changeCustomerPassword(String id, String old_pass, String new_pass) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - changing customer password");
                String query = "update CUSTOMERPASS set PASSWORD = '" + new_pass + "' where customer_id = '" + id + "' and PASSWORD = '" + old_pass + "'";
                conn.prepareStatement(query).executeUpdate();
                return true;
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Changes password without checking
    public void changeCustomerPassword(String id, String new_pass) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - changing customer password");
                String query = "update CUSTOMERPASS set PASSWORD = '" + new_pass + "' where customer_ID = '" + id + "'";
                conn.prepareStatement(query).executeUpdate();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePasswordRecord(String id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - deleting password record");
                String query = "delete from CUSTOMERPASS where customer_id = " + id;  // selects all data from database
                conn.prepareStatement(query).executeUpdate();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Default password is same as cust when customer is created
    public void addPasswordRecord(String id, String pass) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - adding password record!");
                String query = "insert into CUSTOMERPASS(customer_ID, PASSWORD)" + "values('" + id + "','" + pass + "')";
                conn.prepareStatement(query).execute();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCustomerIDbyEmail(String email) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - returning customer ID against an email");
                String query;
                query = "SELECT customer_id FROM customer WHERE email = '" + email + "'";
                ResultSet rs = conn.prepareStatement(query).executeQuery();
                while (rs.next()) {
                    return rs.getString("customer_id");
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getCustomerEmailByID(String ID) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - returning customer email against an ID");
                String query;
                query = "SELECT email FROM customer WHERE customer_id = '" + ID + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    return rs.getString("email");
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
