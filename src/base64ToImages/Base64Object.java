package base64ToImages;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author jijngbao
 * @date 19-3-6
 */
public class Base64Object {
    /**
       * 把base64的String码转换成正常显示的字符串
       */
      public static String base64ToString(String base64) throws IOException {
//        byte[] decode = Base64Utils.decode(base64);
        BASE64Decoder decoder=new BASE64Decoder();
        String s = new String(decoder.decodeBuffer(base64),"utf8");
        return s;
      }
      /**
       * 把String的转换成base64码
       */
      public static String stringToBase64(String ss) {
        byte[] bytes = ss.getBytes();
        BASE64Encoder encoder=new BASE64Encoder();
//        String encode = Base64Utils.encode(bytes);
        return encoder.encode(bytes);
      }

    public static void main(String[] args) throws IOException {
        BASE64Decoder decoder=new BASE64Decoder();
        BASE64Encoder encoder=new BASE64Encoder();
        String data="我是xxx";
        String baseDate=encoder.encode(data.getBytes());
        System.out.println(baseDate);
        data=new String(decoder.decodeBuffer(baseDate),"utf8");
        System.out.println(data);

    }

}
