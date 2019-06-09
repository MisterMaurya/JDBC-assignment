package com.assignment2;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.username}")
    private String usr;

    @Value("${mysql.password}")
    private String pwd;

    @Value("${mysql.driver}")
    private String driver;

    @Override
    public String toString() {
        return "JDBCConnection{" +
                "url='" + url + '\'' +
                ", usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }

    private void displayConnectionProperties() {
        System.out.println("JDBC properties " + toString());
    }

    void getJDBCConnection() {

        displayConnectionProperties();

        Connection con = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not loaded : " + driver + "\nException Catch : " + e);
        }
        try {
            con = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            System.out.println("Connection not establish due to : " + e);
        }
        System.out.println("Connection Successfully created");
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Unable to close connection due to " + e);
        }
        System.out.println("Connection Successfully closed now");

    }


}
