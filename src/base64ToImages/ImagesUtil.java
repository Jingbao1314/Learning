package base64ToImages;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author jijngbao
 * @date 19-3-6
 */
public class ImagesUtil {
    /**
     * 字符串转图片
     * @param imgStr --->图片字符串
     * @param filename    --->图片名
     * @return
     */
    public static boolean generateImage(String imgStr, String filename) {

        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            ByteBuffer buff=null;
            int lenth=imgStr.length();
            System.out.println(lenth);
            int limit=1024;
            int position=0;
            File file=new File(filename);
            FileChannel channel=null;
            FileOutputStream out=null;
            out=new FileOutputStream(file);
            channel=out.getChannel();
            if (limit<lenth){
                while (position<lenth){
                    if (position+limit<lenth){
//                        buff= Charset.forName("utf8").encode(imgStr.substring
//                                (position,position+limit));
                        buff=ByteBuffer.allocate(1024);
                        System.out.print("position+limit:");
                        System.out.println(position+limit);
                        byte[] b = decoder.decodeBuffer(imgStr.substring
                                (position,position+limit));
                        // 处理数据
                        for(int i = 0; i < b.length; ++i) {
                            if (b[i] < 0) {
                                b[i] += 256;
                            }
                        }
                        buff.put(b);
                        position+=1024;//162045-161792
                        buff.flip();
                        int i=channel.write(buff);//1235
                    }else {
//                        buff= Charset.forName("utf8").encode(imgStr.substring
//                                (position,lenth));
                        buff=ByteBuffer.allocate(position+limit-lenth);
                        System.out.println("lenth:"+lenth);
                        byte[] b = decoder.decodeBuffer(imgStr.substring
                                (position,lenth));
                        // 处理数据
                        for(int i = 0; i < b.length; ++i) {
                            if (b[i] < 0) {
                                b[i] += 256;
                            }
                        }
                        buff.put(b);
                        position+=1024;
                        buff.flip();
                        int i=channel.write(buff);//1235
                    }
                }
            }else {
//                buff= Charset.forName("utf8").encode(imgStr);
                buff=ByteBuffer.allocate(1024);
                byte[] b = decoder.decodeBuffer(imgStr);
                // 处理数据
                for(int i = 0; i < b.length; ++i) {
                    if (b[i] < 0) {
                        b[i] += 256;
                    }
                }
                buff.put(b);
                buff.flip();
                int i=channel.write(buff);
            }
            channel.close();
            out.close();
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

//        if (imgStr == null) {
//            return false;
//        }
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            byte[] b = decoder.decodeBuffer(imgStr);
//            // 处理数据
//            for(int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {
//                    b[i] += 256;
//                }
//            }
//            OutputStream out = new FileOutputStream(filename);
//            out.write(b);
//            out.flush();
//            out.close();
//            return true;
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return false;

    }

    /**
     * 图片转字符串
     * @param filePath    --->文件路径
     * @return
     */
    public static String getImageStr(String filePath) throws IOException {
        InputStream inputStream = null;
        FileInputStream fin = new FileInputStream(new File(filePath));
        FileChannel channel = fin.getChannel();
        int capacity = 1024;// 字节
        ByteBuffer bf = ByteBuffer.allocate(capacity);
        int length = -1;
        bf.clear();
        String base64Str="";
        BASE64Encoder encoder = new BASE64Encoder();
        while ((length = channel.read(bf)) != -1) {
            bf.flip();
            byte[]  bytes= bf.array();
            base64Str+=encoder.encode(bytes);
            bf.clear();
        }
        channel.close();
        return base64Str;
    }
    /*
     * 测试代码
     */
    public static void main(String[] args) throws IOException {
        String imageStr = getImageStr("/home/jingbao/IdeaProjects/untitled4/src/base64ToImages/preview.jpg");
//        BASE64Decoder decoder = new BASE64Decoder();
//        System.out.println(new String(decoder.decodeBuffer(imageStr),"utf8"));
//        System.out.println(imageStr);
        boolean generateImage = generateImage(imageStr, "/home/jingbao/IdeaProjects/untitled4/src/base64ToImages/preview(副本).jpg");
        System.out.println(generateImage);
    }

}
