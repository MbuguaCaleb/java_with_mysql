package com.caleb;

import tables.Posts;

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

            //getting posts
             Posts.getPosts(rs);

            //retrieving a particular POST
            //Moving the cursor to last row in database
            rs.last();
            System.out.println("This is Last Post:" + rs.getInt("id")+""+ rs.getString("title")+""+rs.getString("body")+ ""+ rs.getString("author")+"");

            rs.first();
            System.out.println("This is First Post:" + rs.getInt("id")+""+ rs.getString("title")+""+rs.getString("body")+ ""+ rs.getString("author")+"");

            //getting data from a row  in between
            rs.absolute(3);
            System.out.println("This is Post:" + rs.getInt("id")+""+ rs.getString("title")+""+rs.getString("body")+ ""+ rs.getString("author")+"");


        }catch (SQLException e){
            System.err.print(e);
        }
    }
}
