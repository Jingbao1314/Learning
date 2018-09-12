package org;

/**
 * Created by jingbao on 18-1-3.
 */
public class Student {
    private int flag=7721;
    private int id;
    private String name;
    private String sex;//性别
    private String major;//专业
    private String entrance;//入学时间
    private String state;//在学状态

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Student(int id, String name, String sex, String major, String entrance, String state) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.entrance = entrance;
        this.state = state;
    }
    public Student(){}

    public static void main(String[] args) {
        System.out.println("qqqqqqqqqqqq");
    }
}
