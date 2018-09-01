package reflaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jingbao on 18-4-26.
 */
public class MyAppClassLoad extends ClassLoader{
    private final static String
            file_path="/home/jingbao/IdeaProjects/untitled4/src/";
    private ByteBuffer getByte(String fileName) throws IOException {
        File file=new File(fileName);
        ByteBuffer buff=ByteBuffer.allocate(1024);
        FileChannel channel=new FileInputStream(file).getChannel();
        buff.clear();
        channel.read(buff);
        //System.out.println();
        return buff;
    }
    private boolean compile(String file) throws IOException, InterruptedException {
        System.out.println("compile"+file);
        Process process=Runtime.getRuntime().exec("javac " +file);
        process.waitFor();
        return process.exitValue()==0?true:false;

    }
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        int i=0;
        Class  analysisTest=null;
        String fileStub=name.replace(".","/");
        String fileName=file_path+fileStub+".java";
        String classFileName=file_path+fileStub+".class";
        File javaFile=new File(fileName);
        File classFile=new File(classFileName);
        if(javaFile.exists()&&(!classFile.exists()||javaFile.lastModified()
                >classFile.lastModified())){
            int a=0;
            try {

                if(!compile(fileName)||!classFile.exists()){

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(classFile.exists()){
            System.out.println("xxxxx");
            try {
                ByteBuffer buff=getByte(classFileName);
                //buff.flip();

                analysisTest=defineClass(name,buff.array(),0,buff.position());
                //System.out.println(buff.get());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(analysisTest==null){
            throw new ClassNotFoundException(name);
        }else {
            return analysisTest;
        }


    }




}
