package myhibernamte;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.ArrayList;

/**
 * Created by jingbao on 18-12-9.
 */
public class TestUtils {
    public static SessionFactory sf=null;
    static {
        Configuration con=new Configuration().configure();

        //3.获取sessionfactory

        sf= con.buildSessionFactory();
    }
    /* *
     *@describe 获得连接
     */
    private static Session getSession(){
        Session session=sf.openSession();
        return session;
    }
    /* *
     *@describe 关闭连接
     */
    private static void close(Session session){
        session.close();
    }
    /* *
     *@describe 根据主键查询
     */
    public static Test get(Test test){
        Session session=getSession();
        Transaction tx = session.beginTransaction();
        Test t=session.get(Test.class,test.getName());
        tx.commit();
        close(session);
        return t;
    }
    /* *
     *@describe 批量查询
     */
    public static ArrayList<Test> list(){
        Session session=getSession();
        Transaction tx = session.beginTransaction();
        String sql="from Test";
        Query query=session.createQuery(sql).setFirstResult(0).setMaxResults
                (50);
        ArrayList<Test> list= (ArrayList<Test>) query.list();
        System.out.println(list.size());
        tx.commit();
        close(session);
        return list;
    }
    /* *
     *@describe 带有占位符的查询<根据id>
     */
    public static ArrayList<Test> get(String id){
        Session session=getSession();
        Transaction tx = session.beginTransaction();
        String hql="from Test where id= ?0";
        Query query=session.createQuery(hql);
        query.setParameter(0, id);
        ArrayList<Test> list= (ArrayList<Test>) query.list();
        System.out.println(list.size());
        tx.commit();
        return list;
    }

    /* *
     *@describe 删除数据
     */
    public static void delete(Test test){
        Session session=getSession();
        Transaction tx=session.beginTransaction();
        session.delete(test);
        tx.commit();
        close(session);
    }
    /* *
     *@describe 添加数据
     */
    public static void insert(Test test){
        Session session=getSession();
        Transaction tx=session.beginTransaction();
        session.save(test);
        tx.commit();
        close(session);
    }

    public static void main(String[] args) {
//          get("7721");
//        Test t=new Test();
//        t.setId("7721");
//        for(int i=0;i<10;i++){
//            t.setName(Integer.toString(i));
//            insert(t);
//        }
        list();
    }

}
