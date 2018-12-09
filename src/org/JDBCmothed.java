package org;

import java.sql.*;

/**
 * Created by jingbao on 18-1-3.
 */
public class JDBCmothed {
    public static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/data?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "507721";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int insert(Student student){
        Connection conn = getConn();//Image,Title,Details,Price,Place,Tel,Date
        int i = 0;
        String sql = "insert into  student(id,name,state,major,sex,entrance) values(?,?,?,?,?,?);";
        PreparedStatement pstmt;
        Student stu=JDBCmothed.select(Integer.toString(student.getId()));
        //student=null;
        if(stu.getFlag()==1){
            //System.out.println("查询失败，请检查用户名");
            System.out.println("用户已存在");
        }else{
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setInt(1, student.getId());
                pstmt.setString(2,student.getName());
                pstmt.setString(3,student.getState());
                pstmt.setString(4,student.getMajor());
                pstmt.setString(5,student.getSex());
                pstmt.setString(6,student.getEntrance());
                i = pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return i;
    }
    public static int delete(String ID){
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from student where id=" +"'"+ ID +"'";
        PreparedStatement pst;
        Student stu=JDBCmothed.select(ID);
        //student=null;
        if(stu.getFlag()==1){
            //System.out.println("查询失败，请检查用户名");
            try {
                pst = (PreparedStatement) conn.prepareStatement(sql);
                i = pst.executeUpdate();
                System.out.println("resutl: " + i);
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("用户不存在");
        }

        return i;
    }
    public static int update(Student student) {//update t_test t set t.password = '*', t.remark = '*' where t.bs = 1;
        String sql = null;
        Connection conn = getConn();
        int i = 0;
        if(!student.getState().isEmpty()&student.getMajor().isEmpty()){
            sql = "update student stu set stu.state="+"'" + student.getState() +"'"+","+"stu.major="+"'"+student.getMajor()+"'" + "where stu.id="+"'"+student.getId()+"'";

        }else if(!student.getState().isEmpty()){
            sql = "update student stu set stu.state="+"'" + student.getState() +"'" + "where stu.id="+"'"+student.getId()+"'";
        }else{
            sql = "update student stu set stu.major="+"'"+student.getMajor()+"'" + "where stu.id="+"'"+student.getId()+"'";
        }

        System.out.println(sql);
        // PreparedStatement pstmt;
        try {
            Statement statement=conn.createStatement();
            //  pstmt = (PreparedStatement) conn.prepareStatement(sql);
            // i = pstmt.executeUpdate();
            i=statement.executeUpdate(sql);
            System.out.println("resutl: " + i);
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


        public static Student select(String ID) {
        Student stu=new Student();
        //stu=null;
        String result="";
        int flag=0;
        Connection conn = getConn();//title="+"'"+title+"'"
        String sql = "select * from student where id="+"'"+ID+"'";
        System.out.println(sql);
        try {
            Statement statement=conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(!rs.wasNull()){
                while (rs.next()) {
                    //news.setTitle(title);
                    stu.setFlag(1);
                    stu.setState(rs.getString("state"));
                    stu.setId(rs.getInt("id"));
                    stu.setName(rs.getString("name"));
                    stu.setEntrance(rs.getString("entrance"));
                    stu.setMajor(rs.getString("major"));
                    stu.setSex(rs.getString("sex"));
                    System.out.println("**************************************");
                }
            }else{
                System.out.println("++++++++++++++++++++++");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }


    public static int myImport(String string){

        Connection connection=getConn();
        int i = 0;
        String sql="source "+string+";";
        try {
            Statement statement=connection.createStatement();
            //  pstmt = (PreparedStatement) conn.prepareStatement(sql);
            // i = pstmt.executeUpdate();
            i=statement.executeUpdate(sql);
            System.out.println("resutl: " + i);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;

    }

}
