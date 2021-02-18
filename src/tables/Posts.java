package tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Posts {

    public  static  void  getPosts(ResultSet rs) throws SQLException {
        while (rs.next()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Posts ID" + rs.getInt("id")+"");
            buffer.append(rs.getString("title") + "");
            buffer.append(rs.getString("body")+ "");
            buffer.append(rs.getString("author")+"");
            buffer.append(rs.getBoolean("is_published")+"");

            System.out.println(buffer.toString());

        }

    }

}
