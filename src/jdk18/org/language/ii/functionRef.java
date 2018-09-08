package jdk18.org.language.ii;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by andilyliao on 16-8-23.
 */



public class functionRef {
    public static class Car {
        public static Car create( final Supplier< Car > supplier ) {
            return supplier.get();
        }
        public static void collide( final Car car ) {
            System.out.println( "Collided " + car.toString() );
        }
        public void follow( final Car another ) {
            System.out.println( "Following the " + another.toString() );
        }
        public void repair() {
            System.out.println( "Repaired " + this.toString() );
        }
        public int runing(int b){
            System.out.println("Running "+b);
            return b;
        }
    }

    public static void main(String[] args) {
//        第一种方法引用是构造方法引用
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );
//        第二种方法引用是静态方法引用
        cars.forEach( Car::collide );
//        第三种方法引用是类实例的方法引用
        cars.forEach( Car::repair );
//        最后一种方法引用是引用特殊类的方法
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );




    }
}
