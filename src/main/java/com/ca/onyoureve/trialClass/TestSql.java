package com.ca.onyoureve.trialClass;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestSql {



    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://JEHADUR\\SQLEXPRESS;databaseName=test2;encrypt=true;trustServerCertificate=true;";

        try {
             Connection conn = DriverManager.getConnection(connectionUrl, "sa", "passpass28");
            System.out.println("cestablished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
