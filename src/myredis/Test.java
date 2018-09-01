package myredis;

//import redis.clients.jedis.Jedis;

//import java.util.List;

/**
 * Created by jingbao on 18-7-20.
 */

import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test {

    public static void main(String[] args)throws Exception
    {

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://utf8.api.smschinese.cn");
        post.addRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=utf8");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", "jingbao7721"),new
                NameValuePair("Key", "d41d8cd98f00b204e980"),new
                NameValuePair("smsMob","17602648919"),new NameValuePair
                ("smsText","验证码：7721")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes
                ("utf8"));
        System.out.println(result); //打印返回消息状态


        post.releaseConnection();

    }

}