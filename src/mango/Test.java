//package mango;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.io.IOUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import java.io.FileInputStream;
//import java.security.MessageDigest;
//import java.util.Base64;
//import java.util.Date;
//
///**
// * Created by jingbao on 18-8-5.
// */
//public class Test {
//    public static String aiuiWebApi(FileInputStream fileInputStream) throws Exception{
//        String appid = "XXXXXXXX";
//        String appKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
//        String curTime = String.valueOf(new Date().getTime()/1000);
//
//        String url = "http://api.xfyun.cn/v1/aiui/v1/iat";
//
//        String xParam = "{\"auf\":\"16k\",\"aue\":\"raw\",\"scene\":\"main\"}";
//        String param = Base64.getEncoder().encodeToString(xParam.getBytes("UTF-8"));
//
//        String body = "data=" + Base64.getEncoder().encodeToString(IOUtils.toByteArray(fileInputStream));
//
//        String checkSum = RobotMethod.EncoderByMd5(appKey + curTime + param + body);
//
//        HttpPost httpPost = new HttpPost(url);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        StringEntity entity = new StringEntity(body,"utf-8");
//        entity.setContentType("application/x-www-form-urlencoded");
//        httpPost.setEntity(entity);
//        httpPost.setHeader("X-Appid", appid);
//        httpPost.setHeader("X-CurTime", curTime);
//        httpPost.setHeader("X-Param", param);
//        httpPost.setHeader("X-CheckSum", checkSum);
//
//        HttpResponse response = httpClient.execute(httpPost);
//        if(response.getStatusLine().getStatusCode() == 200){
//            HttpEntity responseEntity = response.getEntity();
//            String resJson = EntityUtils.toString(responseEntity,"utf-8");
//            JSONObject jsonObject = JSONObject.fromObject(resJson);
//            String code = jsonObject.getString("code");
//            if(code.equals("00000")) { // 成功
//                String dataJson = jsonObject.getString("data");
//                JSONObject dataObject = JSONObject.fromObject(dataJson);
//                String result = dataObject.getString("result");
//                return result;
//            }
//            else { // 失败
//                String desc = jsonObject.getString("desc");
//                throw new BaseException("讯飞语音接口调用失败："+desc);
//            }
//        }
//        return "调用讯飞语音接口失败";
//    }
//    public static String EncoderByMd5(String str){
//        if(StringUtils.isEmpty(str)) {
//            return "";
//        }
//        String result = "";
//        try {
//            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            byte[] encode = messageDigest.digest(str.getBytes("utf-8"));
//            result = toString(encode);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//
//
//
//}
