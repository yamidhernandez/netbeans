/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author WAlvarezV
 */
public class Conexion {

    Connection connection = null;

    public Connection conectar() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.236:1521:XE", "PWN_TEST", "123456");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR CONEXION BASE DE DATOS " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public boolean cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
