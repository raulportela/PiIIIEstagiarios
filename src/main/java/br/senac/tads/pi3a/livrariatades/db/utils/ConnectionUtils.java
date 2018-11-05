/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.livrariatades.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raul de Paula
 */
public class ConnectionUtils {
    
    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        Connection connection = null;

        // Passo 1: Registrar driver JDBC
        Class.forName("com.mysql.jdbc.Driver");
        // Passo 2: Obter a conexao
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/LivrariaSenacultural",
                "root",
                "");
        return connection;
    }
}
