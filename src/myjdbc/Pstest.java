package myjdbc;

import java.sql.*;

/**
 * Created by jingbao on 18-7-22.
 */
public class Pstest {
    public static void main(String[] args) throws SQLException {
        Connection con=null;
        PreparedStatement pre=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/share","root","507721");
            String sql="select * from user where uid=?";
            pre=con.prepareStatement(sql);
            pre.setString(1,"17602648919");
            ResultSet res=pre.executeQuery();
            while (res.next()){
                System.out.println(res.getString("tpsw"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            pre.close();
            con.close();
        }
    }
}
