/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package com.gcx.sql;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

public class ConnectionSQL {

    public static Connection getConnection() { 
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databasename=test;" 
                + "user=test;"
                + "password=test;"
                + "loginTimeout=30;"
                + "encrypt=true;trustServerCertificate=true;"; 
        try {
            Connection connectionSQL = DriverManager.getConnection(connectionUrl);
            return connectionSQL;
        } catch (SQLException ex) {
            System.out.println("Error in ConnectionSQL, getConnection(): " + ex.toString());
            return null;
        } 
    }
}
