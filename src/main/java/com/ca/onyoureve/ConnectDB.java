
/*
 * *
 *  * Created by Chondromollika Ahmed on 2/14/22, 6:45 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 1/26/22, 4:25 PM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/ConnectDB.java
 *  *OnYourEVE
 *
 */

package com.ca.onyoureve;

import java.sql.*;

import com.ca.onyoureve.trialClass.Events;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.JOptionPane;

public class ConnectDB {
    Connection conn = null;

    public static Connection ConnectDb(int value) {
        try {
            if (value == 1) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/garbase", "root", "");
                return conn;
            } else if (value == 2) {
                String connectionUrl = "jdbc:sqlserver://JEHADUR\\SQLEXPRESS;databaseName=onyoureve;encrypt=true;trustServerCertificate=true;";
                Connection conn = DriverManager.getConnection(connectionUrl, "sa", "passpass28");
                return conn;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public static ObservableList<Events> getDataEvents() {
        Connection conn = ConnectDb(1);
        ObservableList<Events> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from events");
            //    Statement st = conn.createStatement();
            ResultSet rs = ps.executeQuery();
            //   ResultSet rs = st.executeQuery("select * from events");
            while (rs.next()) {
                System.out.println("rs found");
                list.add(new Events(Integer.parseInt(rs.getString("eventID")), rs.getString("eventName"), Integer.parseInt(rs.getString("venueID")), Integer.parseInt(rs.getString("mediaID")), Integer.parseInt(rs.getString("cateringID")), Double.parseDouble(rs.getString("cost"))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}


