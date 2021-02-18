package com.caleb;

import tables.AddPosts;
import tables.Posts;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static  final String SQL = "SELECT * FROM posts WHERE is_published =?";

    public static void main(String[] args) throws SQLException {

       int isPublished;

//       try{
//           isPublished= Input.getInt("Enter if Published");
//
//       }catch (Exception e){
//           System.err.println("Error!Contact Admin");
//           return;
//       }

       ResultSet rs = null;

       try{
           Connection conn = DbConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

           //stmt.setInt(1,isPublished);

           //rs = stmt.executeQuery();
           //Posts.getPosts(rs);

           //Insert data

           Scanner input = new Scanner(System.in);
           String ans = input.nextLine();

           if(ans.equalsIgnoreCase("yes")){
               System.out.println("Enter Id:");
               Integer id = Integer.parseInt(input.nextLine());
               System.out.println("Title:");
               String title = input.nextLine();
               System.out.println("Body:");
               String body = input.nextLine();
               System.out.println("Author:");
               String author = input.nextLine();
               System.out.println("is_published");
               Integer is_published =Integer.parseInt(input.nextLine());
               System.out.println("created_at");
               Date created_at = null;

               AddPosts create = new AddPosts();
               create.add(id,title,body,author,is_published,null);

           }else {
               System.exit(1);
           }

       }catch (Exception e){
           System.err.println(e);
       }finally {
           if(rs !=  null){
               rs.close();
           }
       }
    }
}
