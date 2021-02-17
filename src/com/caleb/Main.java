package com.caleb;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        //simpler way to write my syntax and refactor my code
        //this is called a try with resources block which closes the connection automatically
        //we do not have to add finally
        try(
                //opening the connection
                Connection con =  DbConnection.getConnection();
                //used to fetch data
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs =stmt.executeQuery("SELECT * FROM posts");
                ) {
            rs.last();
            System.out.println(rs.getRow());
        }catch (SQLException e){
            System.err.print(e);
        }
    }
}
