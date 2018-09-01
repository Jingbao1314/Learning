package myenum.i;

/**
 * Created by andilyliao on 17-1-5.
 */
abstract public class Person {
    private String str;
    public Person(String str){
        this.str=str;
    }
    public static Person XM= new Person("XL") {
        @Override
        public void xxxx() {
            System.out.println("adfadfasdf");
        }
    };
    public static Person XH=new Person("XH") {
        @Override
        public void xxxx() {
            System.out.println("adfaddddddfasdf");
        }
    };
    public static Person XL=new Person("XL") {
        @Override
        public void xxxx() {
            System.out.println("eeeeee");
        }
    };
    public static Person XZ=new Person("XZ") {
        @Override
        public void xxxx() {
            System.out.println("aaaaa");
        }
    };

    @Override
    public String toString() {
        return str;
    }
    abstract public void xxxx();
    public static void main(String[] args) {
        System.out.println(Person.XH);
    }
}
