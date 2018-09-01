package mybatistest.dao;

import mybatistest.pojo.User;

import java.util.List;

/**
 * Created by jingbao on 18-8-31.
 */
public interface IUser {
    public List<User> getUserList();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int id);
}
