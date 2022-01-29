package com.ca.onyoureve;



import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import javax.swing.plaf.nimbus.State;

public class ConnectDB {


    


        Connection conn = null;
        public static Connection ConnectDb(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/onyoureve","root","");

              //  String connectionUrl = "jdbc:sqlserver://JEHADUR\\SQLEXPRESS;databaseName=onyoureve;encrypt=true;trustServerCertificate=true;";
              //  Connection conn = DriverManager.getConnection(connectionUrl, "sa", "passpass28");

                JOptionPane.showMessageDialog(null, "Connection Established");
                return conn;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }

        }

        public static ObservableList<Events> getDataEvents(){
            Connection conn = ConnectDb();
            ObservableList<Events> list = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = conn.prepareStatement("select * from events");

            //    Statement st = conn.createStatement();
                ResultSet rs = ps.executeQuery();
             //   ResultSet rs = st.executeQuery("select * from events");

                while (rs.next()){
                    System.out.println("rs found");
                    list.add(new Events(Integer.parseInt(rs.getString("eventID")),rs.getString("eventName"), Integer.parseInt(rs.getString("venueID")), Integer.parseInt(rs.getString("mediaID")), Integer.parseInt(rs.getString("cateringID")),Double.parseDouble(rs.getString("cost") )));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return list;
        }

    }


