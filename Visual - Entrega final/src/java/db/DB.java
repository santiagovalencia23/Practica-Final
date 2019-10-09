/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mateo.llano
 */
public class DB {

    private static Connection connection;

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mysql";
    private static String user = "root";
    private static String password = "root";

    private DB() {
    }
    
    
    public static Connection getConexion() {
        if (connection == null) {

            try {
                Class.forName(driver);
                connection = (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return connection;
    }

}
