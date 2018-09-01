package reflaction;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.security.acl.AclNotFoundException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingbao on 18-4-22.
 */

public class Analysis {
    public static HashMap<String,String> map=new HashMap<>();
    public void analysis(String path) throws IOException {
        String key="set";
        File root =new File(path);
        FileChannel inChnall=new FileInputStream(root).getChannel();
        FileChannel outChnall=new FileOutputStream(new File
                ("/home/jingbao/IdeaProjects/untitled4/src/reflaction" +
                        "/AnalysisTest.java"))
                .getChannel();
        ByteBuffer buff=ByteBuffer.allocate(1024);
        Charset charset=Charset.forName("utf-8");
        //CharsetEncoder encoder=charset.newEncoder();
        //CharBuffer charBuffer=CharBuffer.allocate(1024);
        String result=null;
        while (inChnall.read(buff)>0){
            result=new String(buff.array(),"utf-8");
        }
        //System.out.println(result.trim());
        String[] list=result.split("[=;]");
        String head="package reflaction;"+"\r\n"+"public class AnalysisTest{"
                +"\r\n"+"    public AnalysisTest(){}";
        String body="private String ";
        String shadow="}";
        String getMethod="public String get";
        String setMethod="public void set";
        for (int i=0;i<list.length;i+=2) {
            if(i<list.length-1){
                key=key+list[i].trim().substring(0,
                        1).toUpperCase()+list[i].trim().substring(1,list[i]
                        .trim().length());
                map.put(key,list[i+1]);
                head=head+"\r\n"+"    "+body+list[i].trim()+"=null;"+"\r\n";
                head=head+"\r\n"+"    "+getMethod+list[i].trim().substring(0,
                        1).toUpperCase()+list[i].trim().substring(1,list[i]
                        .trim().length())
                        +"()" +
                        "{"+"\r\n"+"        return this."+list[i].trim()
                        +";"+"\r\n"+"    "+"}"+"\r\n";
                head=head+"\r\n"+"    "+setMethod+list[i].trim().substring(0,
                        1).toUpperCase()+list[i].trim().substring(1,list[i]
                        .trim().length())
                        +"(String value)" +
                        "{"+"\r\n"+"        this."+list[i].trim()
                        +"= value"+";"+"\r\n"+"    "+"}"+"\r\n";
            }
        }
        result=head+"\r\n"+shadow;
        buff.clear();
        //buff=encoder.encode(charBuffer.get(result.toCharArray()));
        outChnall.write(charset.encode(result));

//        outChnall.close();
//        inChnall.close();
    }
    public static void classLoad() throws ClassNotFoundException,
            IOException, InterruptedException {
        File file=new File("/home/jingbao/IdeaProjects/untitled4/src" +
                "/reflaction");
        Process process=Runtime.getRuntime().exec("javac   " +
                "/home/jingbao/IdeaProjects/untitled4/src/reflaction" +
                "/AnalysisTest.java", null, file);
        process.waitFor();
//        Runtime.getRuntime().exec("cp ./AnalysisTest.class " +
//                "/home/jingbao/IdeaProjects/untitled4/out/production" +
//                "/untitled4/reflaction");
//        TimeUnit.SECONDS.sleep(2);
//        ClassLoader load=ClassLoader.getSystemClassLoader();
////        ClassPath path1 = new ClassPath();
////
////        System.out.println(ClassPath.getClassPath()+"=====");
//        load.loadClass(path);
//        Class analysis=Class.forName(path);
//        return analysis;
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, InterruptedException {
        Analysis analysis=new Analysis();
        analysis.analysis("/home/jingbao/桌面/in");
        analysis.classLoad();
//        c.getMethods()\
        String name="reflaction.AnalysisTest";
        Class c=null;
        MyAppClassLoad classLoad=new MyAppClassLoad();
        c=classLoad.loadClass(name);
        c.newInstance();


//        Class analysis=Analysis.classLoad
//                ("reflaction.AnalysisTest");
//        Constructor constructor=analysis.getConstructor();
//        AnalysisTest root= (AnalysisTest) constructor.newInstance();
//




   }
}





