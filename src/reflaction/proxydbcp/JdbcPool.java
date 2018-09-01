package reflaction.proxydbcp;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * Created by jingbao on 18-8-18.
 */
public class JdbcPool {
    /**
     * @Field: abqcon
     *         使用ArrayBlockingQueue来存放数据库链接，
     */
    private static ArrayBlockingQueue abqcon = new ArrayBlockingQueue(200);

    static{

        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/share";
            String username = "root";
            String password = "507721";
            //数据库连接池的初始化连接数大小
            int jdbcPoolInitSize =6;
            //加载数据库驱动
            Class.forName(driver);
            for (int i = 0; i < jdbcPoolInitSize; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("获取到了链接" + conn);
                //将获取到的数据库连接加入到Connections集合中，Connections此时就是一个存放了数据库连接的连接池
                abqcon.put(conn);
            }

        } catch (SQLException e) {
            System.out.println(" 创建数据库连接失败！ " + e.getMessage());
            try {
                throw new SQLException();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static Object get(){
        //如果数据库连接池中的连接对象的个数大于0
        //从Connections集合中获取一个数据库连接
        Connection conn;
        Object con= null;
        try {
            con = abqcon.poll(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(con==null){
            return null;
        }else {
            conn= (Connection) con;
        }
        System.out.println("Connections数据库连接池大小是" + abqcon.size());
        return Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                if(!method.getName().equals("close")){
                    return method.invoke(conn, args);
                }else{
                    //如果调用的是Connection对象的close方法，就把conn还给数据库连接池
                    abqcon.put(conn);
                    System.out.println(conn + "被还给Connections数据库连接池了！！");
                    System.out.println("Connections数据库连接池大小为" + abqcon.size());
                    return null;
                }
            }
        });

    }

    public static void main(String[] args) throws SQLException {
        Connection con= (Connection) JdbcPool.get();
        con.close();
    }
}
