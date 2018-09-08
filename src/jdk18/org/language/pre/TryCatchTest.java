package jdk18.org.language.pre;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by andilyliao on 16-8-24.
 */
public class TryCatchTest {
    private static void printFileJava7() throws IOException {
        try(FileInputStream input         = new FileInputStream("file.txt");
            BufferedInputStream bufferedInput = new BufferedInputStream(input)
        ) {
            int data = bufferedInput.read();
            while(data != -1){
                System.out.print((char) data);
                data = bufferedInput.read();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        printFileJava7();
    }
}
