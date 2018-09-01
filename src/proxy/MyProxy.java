package proxy;

import java.io.*;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by jingbao on 18-5-7.
 */
//class Test implements MyInvocationHabdler{
//
//    @Override
//    public Object invoke() {
//        System.out.println("********");
//        return new Object();
//    }
//}
public class MyProxy {
//    private static ClassLoader loader;
//    private static Class<?>[] byAgency;
//    private static MyInvocationHabdler agency;
//    public static Object myNewProxyInstance( ClassLoader loader,Class<?>[] byAgency,MyInvocationHabdler agency)
//    {
//        return new Object();
//
//    }
//    public static void makeClass(Class<?>[] byAgency,MyInvocationHabdler agency){
//       String temp=byAgency[0].toString().replace(".","-");
//       String  []interFace=temp.split("-");
////       System.out.println(interFace[1]);
//        String key="set";
//        //File root =new File(path);
//        try {
//            //FileChannel inChnall=new FileInputStream(root).getChannel();
//            FileChannel outChnall= null;
//            outChnall = new FileOutputStream(new File
//                    ("/home/jingbao/IdeaProjects/untitled4/src/proxy" +
//                            "/Proxy0.java"))
//                    .getChannel();
//            ByteBuffer buff=ByteBuffer.allocate(1024);
//            Charset charset=Charset.forName("utf-8");
//            //CharsetEncoder encoder=charset.newEncoder();
//            //CharBuffer charBuffer=CharBuffer.allocate(1024);
//            String result=null;
////        while (inChnall.read(buff)>0){
////            result=new String(buff.array(),"utf-8");
////        }
//            //System.out.println(result.trim());
//            String[] list=result.split("[=;]");
//            String head="package proxy;"+"\r\n"+"public final class " +
//                    "Proxy0 implements"+interFace[1]+"{"
//                    +"\r\n"+"    public Proxy0(MyInvocationHabdler agency)" +
//                    "{"+"\r\t"+"this.agency=agency"+"\r\t"+"}";
//            String body="private static MyInvocationHabdler=null ;" +
//                    ""+"\r\t"+"private static Method m1 ;" +
//                    ""+"static{"+"\r\t"+"  try{"+"\r\t"+"    m1=Class.forName" +
//                    "("+"\""+agency.getClass();
//            String shadow="}";
//            String getMethod="public String get";
//            String setMethod="public void set";
//            for (int i=0;i<list.length;i+=2) {
//                if(i<list.length-1){
//                    key=key+list[i].trim().substring(0,
//                            1).toUpperCase()+list[i].trim().substring(1,list[i]
//                            .trim().length());
//                    // map.put(key,list[i+1]);
//                    head=head+"\r\n"+"    "+body+list[i].trim()+"=null;"+"\r\n";
//                    head=head+"\r\n"+"    "+getMethod+list[i].trim().substring(0,
//                            1).toUpperCase()+list[i].trim().substring(1,list[i]
//                            .trim().length())
//                            +"()" +
//                            "{"+"\r\n"+"        return this."+list[i].trim()
//                            +";"+"\r\n"+"    "+"}"+"\r\n";
//                    head=head+"\r\n"+"    "+setMethod+list[i].trim().substring(0,
//                            1).toUpperCase()+list[i].trim().substring(1,list[i]
//                            .trim().length())
//                            +"(String value)" +
//                            "{"+"\r\n"+"        this."+list[i].trim()
//                            +"= value"+";"+"\r\n"+"    "+"}"+"\r\n";
//                }
//            }
//            result=head+"\r\n"+shadow;
//            buff.clear();
//            //buff=encoder.encode(charBuffer.get(result.toCharArray()));
//            outChnall.write(charset.encode(result));
//
////        outChnall.close();
////        inChnall.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        //MyProxy.makeClass(new Test().getClass().getInterfaces());
////        Test e=new Test();
////        System.out.println(e.getClass().getMethods()[0].toString().trim());
//        //System.out.println("\"\"");
//    }
}
