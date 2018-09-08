package jdk18.org.nio.nio2.file;

/**
 * Created by andilyliao on 16-8-23.
 */
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVistorTest {

    public static void main(String[] args) throws IOException {
        Path file=Paths.get("/opt/","test");
        Files.walkFileTree(file, new FileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                System.out.format("visit file %s \n",file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir,
                                                     BasicFileAttributes attrs) throws IOException {
                System.out.format("preVisitDirectory %s \n",dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc)
                    throws IOException {
                System.out.format("visitFileFailed %s \n",file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                    throws IOException {
                System.out.format("postVisitDirectory %s \n",dir);
                return FileVisitResult.CONTINUE;
            }
        });

    }

}