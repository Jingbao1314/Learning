package jdk18.org.nio.nio2.file;

/**
 * Created by andilyliao on 16-8-23.
 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {
        Path file=Paths.get("/opt/", "test1");
        System.out.format("file:%s \n", file);

        //是否以所给的字符或者Path结尾
        System.out.println(file.endsWith("test1"));

        //在当前path下增加 输出:/opt/test/abc.txt
        Path file2=file.resolve("abc.txt");
        System.out.format("file2:%s \n",file2);

        //在当前path所在的目录中增加 输出:/opt/test/1
        Path file3=file2.resolveSibling("1");
        System.out.format("file3:%s \n",file3);

        // 相对路径 输出:file3相对于file2的路径
        Path file4=file2.relativize(file3);
        System.out.format("file4:%s \n",file4);

        // 获取名字数量
        System.out.format("file3 namecount:%d \n",file3.getNameCount());
        System.out.format("file4 namecount:%d \n",file4.getNameCount());

        // opt
        System.out.format("file3 getName(0):%s \n",file3.getName(0));

        // 返回/opt/\  /opt/\新建文件夹\1 可见nameCount只记录 新建文件夹 和 1 /opt/\需要通过getRoot获取
        System.out.format("file3 getRoot():%s \n",file3.getRoot());
        // 相对路径没有root 返回null 并且 ..\1  他的namecount记录的就是 ..和1
        System.out.format("file4 getRoot():%s \n",file4.getRoot());


    }

}  
