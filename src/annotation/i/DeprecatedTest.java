package annotation.i;
@Deprecated
class Apple1 {
    @Deprecated//重构的时候用到  右键找Find usages  看那地方用到该方法
    public void info() {
        System.out.println("aaaa");
    }

    @Deprecated
    private String str;
}

public class DeprecatedTest {
    public static void main(String[] args) {

        new Apple1().info();
        
    }
}

