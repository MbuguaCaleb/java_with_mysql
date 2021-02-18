package tables;

import com.caleb.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class AddPosts {


    public  void  add(Integer id, String title, String body, String author, Integer is_published, Date created_at){

        String sql = "INSERT INTO posts('id','title', 'body','author','is_published','created_at') VALUES(?,?,?,?,?,?)";

        try(
                Connection conn = DbConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){

            stmt.setInt(1,id);
            stmt.setString(2,title);
            stmt.setString(3,body);
            stmt.setString(4,author);
            stmt.setInt(5,is_published);
            stmt.setDate(6, (java.sql.Date) created_at);

            stmt.execute();

        }catch (Exception e){

        }

    }

}
