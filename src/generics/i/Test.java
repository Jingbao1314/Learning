package generics.i;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingbao on 18-7-16.
 */
class Basic{//junit单元测试
    private int flag=7721;
}
class Student extends Basic{

}
class Teacher extends Basic{

}
public class Test <T extends Basic>{
    private T stu;
    public<T> Test(){

    }
    public void xx(){
        System.out.println("7721");
    }
    public static void main(String[] args) {
        new Test<>();


    }

}
