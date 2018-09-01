package reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {
    public static void main(String[] args) {
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        String regStr = "Java is very easy!";
        System.out.println("dist string is：" + regStr);
        Matcher m = Pattern.compile("\\w+")
                .matcher(regStr);
        while (m.find()) {
            System.out.println(m.group() + " start："
                    + m.start() + "，end：" + m.end());
        }
    }
}
