package jdk18.org.nio.nio2.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.Date;

/**
 * Created by andilyliao on 16-8-23.
 */
public class WatchServiceTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path file= Paths.get(".").toRealPath();
        Path watchDir=file.resolveSibling("/opt/test1");
        System.out.println(watchDir.toRealPath());

        WatchService ws= FileSystems.getDefault().newWatchService();

        WatchKey wk=watchDir.register(ws, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("watching......");
        while(true){
            wk=ws.take();
            for(WatchEvent event:wk.pollEvents()){
                System.out.println((new Date())+":"+((Path)event.context()).getFileName().toString()+":"+event.kind());
            }
            wk.reset();
        }
    }
}
