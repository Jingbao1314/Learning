package myjdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jingbao on 18-7-22.
 */
public class Test {
    public static void main(String[] args) {
        java.sql.Connection con=null;
        java.sql.Statement sta=null;//(com.mysql.jdbc.Statement)
        // enableStreamingResult()//服务端游标
        ResultSet res=null;
        String line="";
        try {//"aaa 'or 1=1"
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/share","root","507721");
            con.setAutoCommit(false);
            sta= con.createStatement();

            res= (ResultSet) sta.executeQuery("select uid from user order " +
                    "BY uid limit 2,2" );
//            sta.setMaxRows(1);//设置数据的最大数量
            while (res.next()){
                System.out.println(res.getString("uid"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {//setFetchSize();
            e.printStackTrace();
        }finally {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
