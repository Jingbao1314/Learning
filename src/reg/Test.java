package reg;
//https://blog.csdn.net/imu2008/article/details/49632843
/**
 * @author jijngbao
 * @date 18-12-9
 */
public class Test {
    public static void main(String[] args) {
        /**
         * it is a test for \utest.
         */
        // \u0022 是双引 号的 Unicode 转义字符
        System.out.println("a\u0022.length() + \u0022b".length());

        String msg = "JJJJ ppp@baidu.com xxx regular expressions in 11.4 啊啊啊啊啊 13811111111";
        System.out.println("(1) "+msg.replaceFirst("re\\w*?", "999"));//不建议写
        System.out.println("(2) "+msg.replaceFirst("re\\w*", "999"));
        System.out.println("(3) "+msg.replaceFirst("re\\w?", "999"));
        System.out.println("(4) "+msg.replaceFirst("\\D","999"));//匹配非数字
        System.out.println("(5) "+msg.replaceFirst("\\D*","999哈"));
        System.out.println("(5) "+msg.replaceFirst("\\D*?","999"));
        System.out.println("(6) "+msg.replaceFirst("\\d","999"));//匹配数字
        System.out.println("(7) "+msg.replaceFirst("\\d\\.\\d","999"));
        System.out.println("(8) "+msg.replaceFirst("(\\d)|(\\.)","999"));
        System.out.println("(9) "+msg.replaceFirst("[a-z]+","999"));
        System.out.println("(10) "+msg.replaceFirst("[A-z]?","999"));
        System.out.println("(11) "+msg.replaceFirst("[A-z]+","999"));
        System.out.println("(12) "+msg.replaceFirst("[\u4E00-\u9FA5]+","999"));//U+4E00..U+9FA5.\u ascii码
        System.out.println("(13) "+msg.replaceFirst("((131)|(138)|(186))\\d{7}","999"));
        System.out.println("(14) "+msg.replaceFirst("\\w*@\\w*.\\w*","999"));
        System.out.println("(15) "+msg.replaceFirst("[0-z]+@[0-z]+.[0-z]{2,3}","999"));
    }
}
