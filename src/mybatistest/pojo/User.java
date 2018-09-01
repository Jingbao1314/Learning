package mybatistest.pojo;

/**
 * Created by jingbao on 18-8-31.
 */
public class User {
    private int id;
    private String name;
    private String sex;
    private String balance;
    private String password;
    private String paypassword;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(int id, String name, String sex, String balance, String password, String paypassword, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.balance = balance;
        this.password = password;
        this.paypassword = paypassword;
        this.phone = phone;
    }

    public User() {
    }
}
