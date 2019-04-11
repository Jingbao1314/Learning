package reflaction.cglib;

/**
 * @author jijngbao
 * @date 19-3-28
 */
public class Test {
    public static void main(String[] args) {
        Dog dog=new Dog();
        DogCglib cglib=new DogCglib();
        Dog cglibDog= (Dog) cglib.getInstance(dog);
        cglibDog.eat();
    }
}
