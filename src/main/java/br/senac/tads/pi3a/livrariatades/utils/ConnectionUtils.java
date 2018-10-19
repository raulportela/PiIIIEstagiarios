/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Raul de Paula
 */
public class ConnectionUtils {
   public static Connection getConnection() throws SQLException {
        Connection connection = null;

        String dbURL = "jdbc:mysql://localhost:3306/floricultura";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        properties.put("serverTimezone", "UTC");
        connection = DriverManager.getConnection(dbURL, properties);

        return connection;
    }   
        
}
