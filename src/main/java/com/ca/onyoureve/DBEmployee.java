/*
 * *
 *  * Created by Chondromollika Ahmed on 2/16/22, 10:19 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/16/22, 10:19 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/DBEmployee.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import java.sql.*;
import java.util.ArrayList;

public class DBEmployee {
    public int sqlType = Custom.getSQLtype();

    public Employee getEmployee(String id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - getting an employee");
                String query = "select * from employee where employee_id = " + id;  // query to be sent
                ResultSet rs = conn.prepareStatement(query).executeQuery();
                while (rs.next()) {                                            // reads a row
                    String name = rs.getString("name");             // finds a column in the row
                    String dob = rs.getString("dob");
                    String phone = rs.getString("phone_no");
                    String email = rs.getString("email");
                    String nid = rs.getString("nid");
                    String acc = rs.getString("acc_no");
                    String emp_type = rs.getString("emp_type");
                    String salary_rate = rs.getString("salary_rate");
                    String address = rs.getString("address");
                    String mid = rs.getString("mgr_id");
                    Employee emp = new Employee(id, name, dob, phone, email, nid, acc, emp_type, Integer.parseInt(salary_rate), address, mid);
                    return emp;
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Employee empty = new Employee();
        return empty;
    }

    public void insertEmployee(Employee emp, String id) {
        emp.setEmployee_id(id);
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - inserting employee with id");
                String query2 = "insert into employee values(?,?,STR_TO_DATE(?, '%d/%m/%y'),?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(query2);
                pstmt.setString(1, emp.getEmployee_id());
                pstmt.setString(2, emp.getName());
                pstmt.setString(3, emp.getDob());
                pstmt.setString(4, emp.getEmail());
                pstmt.setString(5, emp.getPhone_no());
                pstmt.setString(6, emp.getNid());
                pstmt.setString(7, emp.getAcc_no());
                pstmt.setString(8, emp.getEmp_type());
                pstmt.setInt(9, emp.getSalary_rate());
                pstmt.setString(10, emp.getAddress());
                pstmt.setString(11, emp.getMgr_id());
                pstmt.execute();
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeEmployee(String id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - removing employee");
                String query = "delete from employee where employee_id = " + id;  // selects all data from database
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

    public void changeManager(String emp_id, String mgr_id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - changing manager id");
                String query = "UPDATE EMPLOYEE SET mgr_id = " + mgr_id + " WHERE employee_id = " + emp_id;
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

    public void updateField(String id, String field, String new_value, boolean isNumeric) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - updating employee field");
                String query = new String();
                if (!isNumeric)
                    query = "update EMPLOYEE set " + field + " = '" + new_value + "' where employee_id = " + id;
                else
                    query = "update EMPLOYEE set " + field + " = " + new_value + " where employee_id = " + id;
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
    ///
    ////
    //////

    // Returns true if password correct against that id, false otherwise
    public boolean employeeLogin(String id, String pass) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - attempting employee login");
                String query = "select * from EMPLOYEEPASS where emplyee_id = " + id;  // query to be sent
                ResultSet rs = conn.prepareStatement(query).executeQuery();
                String db_pass = "";
                while (rs.next()) {
                    db_pass = rs.getString("password");
                }
                if (pass.equals(db_pass))
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

    // Returns true if password changed successfully, false otherwise
    public boolean changeEmployeePassword(String id, String old_pass, String new_pass) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - changing employee password");
                String query = "update EMPLOYEEPASS set PASSWORD = " + new_pass + " where EMPloyee_ID = " + id + " and PASSWORD = " + old_pass;
                conn.prepareStatement(query).execute();
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

    public void deletePasswordRecord(String id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - deleting employee password record");
                String query = "delete from EMPLOYEEPASS where employee_ID = " + id;  // selects all data from database
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

    // Default password is same as emp_id when employee is created
    public void addPasswordRecord(String id, String pass) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - adding employee password record");
                String query = "insert into EMPLOYEEPASS(EMPloyee_ID, PASSWORD)" + "values('" + id + "','" + pass + "')";
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

    public boolean isManager(String id) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - checking if employee is a manager");
                String query = "select mgr_id from employee";  // query to be sent
                ResultSet rs = conn.prepareStatement(query).executeQuery();
                while (rs.next()) {
                    String mgr_id = rs.getString("mgr_id");
                    if (mgr_id != null) {
                        if (mgr_id.equals(id))
                            return true;
                    }
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

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - getting list of all employees");
                String query = "select * from employee";  // query to be sent
                ResultSet rs = conn.prepareStatement(query).executeQuery();
                while (rs.next()) {
                    // reads a row
                    String name = rs.getString("name");             // finds a column in the row
                    String dob = rs.getString("dob");
                    String phone = rs.getString("phone_no");
                    String email = rs.getString("email");
                    String nid = rs.getString("nid");
                    String acc = rs.getString("acc_no");
                    String emp_type = rs.getString("emp_type");
                    String salary_rate = rs.getString("salary_rate");
                    String address = rs.getString("address");
                    String mid = rs.getString("mgr_id");
                    String id = rs.getString("emp_id");
                    Employee emp = new Employee(id, name, dob, phone, email, nid, acc, emp_type, Integer.parseInt(salary_rate), address, mid);
                    employeeList.add(emp);
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public String insertEmployee(Employee emp) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - inserting an employee object");
                String sql = "insert into employee( name, dob, phone_no, email, nid, acc_no, emp_type, salary_rate, address, mgr_id) values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, emp.getName());
                pstmt.setString(2, emp.getDob());
                pstmt.setString(3, emp.getPhone_no());
                pstmt.setString(4, emp.getEmail());
                pstmt.setString(5, emp.getNid());
                pstmt.setString(6, emp.getAcc_no());
                pstmt.setString(7, emp.getEmp_type());
                pstmt.setInt(8, emp.getSalary_rate());
                pstmt.setString(9, emp.getAddress());
                pstmt.setString(10, emp.getMgr_id());
                pstmt.executeUpdate();
                String sql2 = "select employee_id from employee where email = ?";
                PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, emp.getEmail());
                ResultSet rs = pstmt2.executeQuery();
                String id = "";
                while (rs.next()) {
                    id = rs.getString("employee_id");
                }
                return id;
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

    public Employee getEmployeeByEmail(String email) {
        try {
            Connection conn = ConnectDB.ConnectDb(sqlType);
            if (conn != null) {
                System.out.println("Database - getting an employee by email");
                String query = "select * from employee where email = '" + email + "'";  // query to be sent
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {                                            // reads a row
                    String name = rs.getString("name");             // finds a column in the row
                    String dob = rs.getString("dob");
                    String phone = rs.getString("phone_no");
                    String nid = rs.getString("nid");
                    String acc = rs.getString("acc_no");
                    String emp_type = rs.getString("emp_type");
                    String salary_rate = rs.getString("salary_rate");
                    String address = rs.getString("address");
                    String mid = rs.getString("mgr_id");
                    String id = rs.getString("emp_id");
                    Employee emp = new Employee(id, name, dob, phone, email, nid, acc, emp_type, Integer.parseInt(salary_rate), address, mid);
                    return emp;
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Employee emptyObj = new Employee();
        return emptyObj;
    }
}
