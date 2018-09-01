package reflaction;

import java.io.*;

/**
 * Created by jingbao on 18-4-25.
 */
public class ProcessTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] javac_flag={"javac AnalysisTest"};
        File path=new File("/home/jingbao/IdeaProjects/untitled4/src" +
                "/reflaction");
        Process process=Runtime.getRuntime().exec("javac   " +
                "/home/jingbao/IdeaProjects/untitled4/src/reflaction" +
                "/AnalysisTest.java", null, path);
        process.waitFor();
        InputStream inputStream=process.getInputStream();
        BufferedReader read=new BufferedReader(new InputStreamReader
                (inputStream));
        String line="";
        while (read.readLine()!=null){
            line+=read.readLine();
            System.out.println(line);

        }
    }
}
