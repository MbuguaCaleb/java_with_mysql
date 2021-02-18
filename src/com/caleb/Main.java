package com.caleb;

import tables.Posts;

import java.sql.*;

public class Main {

    private static  final String SQL = "SELECT * FROM posts WHERE is_published =?";

    public static void main(String[] args) throws SQLException {

       int isPublished;

       try{
           isPublished= Input.getInt("Enter if Published");

       }catch (Exception e){
           System.err.println("Error!Contact Admin");
           return;
       }

       ResultSet rs = null;

       try{
           Connection conn = DbConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

           stmt.setInt(1,isPublished);

           rs = stmt.executeQuery();
           Posts.getPosts(rs);


       }catch (Exception e){
           System.err.println(e);
       }finally {
           if(rs !=  null){
               rs.close();
           }
       }
    }
}
