package com.caleb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final  String USERNAME ="mysql";
    private static  final String PASSWORD = "MbuguasWork!1";
    private  static  final  String CONN = "jdbc:mysql://localhost:3306/pdoposts?autoReconnect=true&useSSL=false";

    public  static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(CONN, USERNAME,PASSWORD);
    }
}
