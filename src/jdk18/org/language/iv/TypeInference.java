package jdk18.org.language.iv;

/**
 * Created by andilyliao on 16-8-23.
 */
class Value<T> {
    public static<T> T defaultValue() {
        return null;
    }
    public T getOrDefault( T value, T defaultValue ) {
        return ( value != null ) ? value : defaultValue;
    }
}

public class TypeInference {
    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        //在java 7, 相同的代码不会被编译，需要写成：Value.< String >defaultValue()
        System.out.println(value.getOrDefault( null, Value.defaultValue() ));
    }

}
