package myhibernamte;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Iterator;



/**
 * Created by jingbao on 18-12-7.
 */
public class TestDao {
    public static void main(String[] args) throws HibernateException {
        //2.获取configuration
        Test test=new Test();
        test.setName("qqq");
        test.setId("133");

        Configuration con=new Configuration().configure();

        //3.获取sessionfactory

        SessionFactory sf = con.buildSessionFactory();

        //4.获取session,打开事务

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.find(Test.class,"from Test as t");

        //5.用面向对象的方式操作数据库
        //select
//        Test t=session.get(Test.class,test.getName());
//        System.out.println(t.getId());
        //delete
//        session.delete(test);
        //insert
//        session.save(test);

        tx.commit();

        //6.关闭事务,关闭session

        session.close();
        sf.close();
    }
}
