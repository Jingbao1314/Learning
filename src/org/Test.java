package org;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jingbao on 18-10-25.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {

        Process process=Runtime.getRuntime().exec("java " +"Test");
        BufferedReader read=new BufferedReader(new InputStreamReader(process
                .getErrorStream()));
        process.waitFor();
        String res="";
        String line="";
        while ((line=read.readLine())!=null){
            res=res+line;
        }
        System.out.println(res);
    }
}
