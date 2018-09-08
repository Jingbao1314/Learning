package jdk18.org.nio.nio2.file;

/**
 * Created by andilyliao on 16-8-23.
 */

import java.io.IOException;
import java.nio.file.*;

public class DirectoryStreamTest {
    public static void newFileList() {
        long begin = System.currentTimeMillis();
        try {
            Path path = Paths.get("/opt/1");
            String newPath = "/opt/2";
            DirectoryStream<Path> streamList = Files.newDirectoryStream(path);
            for (Path pathSun : streamList) {
                Files.copy(pathSun, Paths.get(newPath + pathSun.getFileName()), StandardCopyOption.COPY_ATTRIBUTES);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println("time:" + (System.currentTimeMillis() - begin));
    }

    public static void main(String[] args) throws IOException {
        newFileList();
    }

}
