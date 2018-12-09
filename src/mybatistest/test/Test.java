package mybatistest.test;

import mybatistest.dao.IGoods;
import mybatistest.dao.IUser;
import mybatistest.pojo.Goods;
import mybatistest.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by jingbao on 18-8-31.
 */
public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //sqlSessionFactory.getConfiguration().addMapper(IUser.class);
            //User user = (User) session.selectOne( "com.yiibai.mybatis.models.UserMapper.getUserByID", 1);

            // 用户数据列表
//            System.out.println(testInsert());
            // 插入数据
            // testInsert();

            // 更新用户
            testUpdate();

            // 删除数据
            //testDelete();

        } finally {
            session.close();
        }
    }

    //
    public static int testInsert()
    {
        try
        {
            // 获取Session连接
            SqlSession session = sqlSessionFactory.openSession();
            // 获取Mapper
            IUser userMapper = session.getMapper(IUser.class);
            System.out.println("Test insert start...");
            // 执行插入
            User user = new User();
            user.setId(400);
            user.setName("Google");
            user.setSex("xx");
            user.setPhone("18256127721");
            userMapper.insertUser(user);
            // 提交事务
            session.commit();

            // 显示插入之后User信息
            System.out.println("After insert"+user.getId());
//            getUserList();
            System.out.println("Test insert finished...");
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }

//    // 获取用户列表
    public static void getUserList() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            IUser iuser = session.getMapper(IUser.class);
//            IGoods iGoods = session.getMapper(IGoods.class);
            // 显示User信息
            System.out.println("Test Get start...");
            printUsers(iuser.getUserList());
//            printUsers(iGoods.getGoodsList());
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    private static void printUsers(final List<Goods> goods) {
//        int count = 0;
//
//        for (Goods good : goods) {
//            System.out.println(MessageFormat.format(
//                    "============= User[{0}]=================", ++count));
//            System.out.println("goods Id: " + good.getId());
//
//        }
//    }
//
    public static void testUpdate()
    {
        try
        {
            SqlSession session = sqlSessionFactory.openSession();
            IUser iuser = session.getMapper(IUser.class);
            System.out.println("Test update start...");
            printUsers(iuser.getUserList());
            // 执行更新
//            User user =iuser.getUser(1);
            User user = new User();
            user.setName("xxx name");
//            user.setSex("man");
//            user.setPassword("12346789");
//            user.setId(1);
            iuser.updateUser(user);
            // 提交事务
            session.commit();
            // 显示更新之后User信息
            System.out.println("After update");
            printUsers(iuser.getUserList());
            System.out.println("Test update finished...");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
//
//    // 删除用户信息
//    public static void testDelete()
//    {
//        try
//        {
//            SqlSession session = sqlSessionFactory.openSession();
//            IUser iuser = session.getMapper(IUser.class);
//            System.out.println("Test delete start...");
//            // 显示删除之前User信息
//            System.out.println("Before delete");
//            printUsers(iuser.getUserList());
//            // 执行删除
//            iuser.deleteUser(2);
//            // 提交事务
//            session.commit();
//            // 显示删除之后User信息
//            System.out.println("After delete");
//            printUsers(iuser.getUserList());
//            System.out.println("Test delete finished...");
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     *
//     * 打印用户信息到控制台
//     *
//     * @param users
//     */
    private static void printUsers(final List<User> users) {
        int count = 0;

        for (User user : users) {
            System.out.println(MessageFormat.format(
                    "============= User[{0}]=================", ++count));
            System.out.println("User Id: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User sex: " + user.getSex());
            System.out.println("User phone: " + user.getPhone());
        }
    }


}
