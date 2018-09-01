package myenum.ii_2;

public class GenderTest {
    public static void main(String[] args) {
        Gender g = Gender.valueOf("FEMALE");
        g.setSex("nv");
        System.out.println(g + " is: " + g.getSex());
        g.setSex("nan");
        System.out.println(g + " is: " + g.getSex());
    }
}
