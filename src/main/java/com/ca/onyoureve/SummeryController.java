/*
 * *
 *  * Created by JehadurRE on 3/10/22, 10:03 AM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 3/10/22, 10:03 AM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/SummeryController.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SummeryController implements Initializable{

    @FXML
    private TextField employee_total;

    @FXML
    private TextField salary_max;

    @FXML
    private TextField salary_minimum;

    @FXML
    private TextField salary_total;

    @FXML
    private TextField salary_average;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ResultSet rs;
        String total_employee ="select count(employee_id) as total employee from employee";
        String salary_maxX ="select max(salary_rate) as maximum salary from employee";
        String salary_min ="select min(salary_rate) as minimum salary from employee";
        String total_salary ="select sum(salary_rate) as total salary from employee";
        String average_salary ="select avg(salary) as average salary from employee";
        Connection connection = ConnectDB.ConnectDb(1);
        try {
             rs= connection.prepareStatement(total_employee).executeQuery();

            while (rs.next()){
                employee_total.setText(rs.getString("total"));
            }

            rs= connection.prepareStatement(salary_maxX).executeQuery();

            while (rs.next()){
                salary_max.setText(rs.getString("maximum"));
            }
            rs= connection.prepareStatement(salary_min).executeQuery();
            while (rs.next()){
                salary_minimum.setText(rs.getString("minimum"));
            }

            rs= connection.prepareStatement(total_salary).executeQuery();
            while (rs.next()){
                salary_total.setText(rs.getString("total"));
            }

            rs= connection.prepareStatement(average_salary).executeQuery();
            while (rs.next()){
                salary_average.setText(rs.getString("average"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
