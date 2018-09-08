package jdk18.org.nio.nio2.file;

/**
 * Created by andilyliao on 16-8-23.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttribute {

    public static void main(String[] args) throws IOException {
        Path file=Paths.get("/opt/", "test","abc.txt");
        BasicFileAttributeView bav=Files.getFileAttributeView(file, BasicFileAttributeView.class);

        BasicFileAttributes ba=bav.readAttributes();
        //或者:
        //BasicFileAttributes ba=Files.readAttributes(file, BasicFileAttributes.class);
        System.out.format("File size: %s \n" , ba.size());
        System.out.format("File creation time: %s \n" , ba.creationTime());
        System.out.format("File was last accessed at: %s \n" , ba.lastAccessTime());
        System.out.format("File was last modified at: %s \n" , ba.lastModifiedTime());
        System.out.format("Is directory? %s \n" , ba.isDirectory());
        System.out.format("Is regular file? %s \n" , ba.isRegularFile());
        System.out.format("Is symbolic link? %s \n" , ba.isSymbolicLink());
        System.out.format("Is other? %s \n" , ba.isOther());
    }

}  
