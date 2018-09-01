package reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesTest {
    public static void main(String[] args) {
        String[] mails = {
                        "kongyeeku@163.com",
                        "kongyeeku@gmail.com",
                        "ligang@crazyit.org",
                        "wawa@abc.xx"
                };
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = mailPattern.matcher(mail);
//                System.out.println(matcher.group());
            } else {
                matcher.reset(mail);//不换式样 只换值 这样的话 速度更快一点
            }
            String result = mail + (matcher.matches() ? " is" : " is not")
                    + " a real email addr！";
            System.out.println(result);
        }
    }
}

