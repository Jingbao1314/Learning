package generics.i;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andilyliao on 17-1-7.
 */
interface Obj{
    void run();
}

class Person implements Obj{
    public void run(){
        System.out.println("Person");
    }
}

class Car implements Obj{
    public void run(){
        System.out.println("Car");
    }
}

public class ArrayListtest {
    public static void doOpt(List<Person> l){
        for(int i=0;i<l.size();i++){
            Person p=(Person)l.get(i);
            p.run();
        }
    }
    public static void main(String[] args) {
        Person p=new Person();
        Car c=new Car();
        ArrayList<Person> list=new ArrayList();
        list.add(p);

        doOpt(list);
    }
}
