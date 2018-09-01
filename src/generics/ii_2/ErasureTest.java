package generics.ii_2;

class Apple<T extends Number> {
    T size;

    public Apple() {
    }

    public Apple(T size) {
        this.size = size;
    }

    public void setSize(T size) {
        this.size = size;
    }

    public T getSize() {
        return this.size;
    }
}

public class ErasureTest {
    public static void main(String[] args) {
        Apple<Integer> a = new Apple<>(6);
        Integer as = a.getSize();
        Apple b = a;//b没有定义类型，因此就是number类型
        Number size1 = b.getSize();
        // 下面代码会报错
//        Integer size2 = b.getSize();
    }
}
