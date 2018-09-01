package org2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by jingbao on 18-2-1.
 */
public class Main {
    private static List<Server> serverList=new ArrayList<>();
    private static List<Route> routeList=new ArrayList<>();
    public static void startServer(){
        if(!loadCfgFile()){
            System.exit(1);
        }
        while (serverList.size()>0){
            Server server=serverList.remove(0);
            server.closeServer();
        }
        for(int i=0;i<routeList.size();i++){
            Route route=routeList.get(i);
            Server server=new Server(route,i);
            serverList.add(server);
        }
    }
    public static void stop(){
        while (serverList.size()>0){
            Server server=serverList.remove(0);
            server.closeServer();
        }
    }

    private static boolean loadCfgFile() {
        String userHome=System.getProperties().getProperty("user.dir");
        if(userHome==null){
            userHome="";
        }else {
            userHome=userHome+ File.separator;
        }
        userHome+="cfg" +File.separator+"jPortMap.cfg";
        try {
            InputStream is=new FileInputStream(userHome);
            Properties pt=new Properties();
            pt.load(is);
            System.out.println();

            int ServericeCount=Integer.parseInt(pt.getProperty
                    ("TransferCount"));
            for(;ServericeCount>0;ServericeCount--){
                Route route=new Route();
                route.setLocalIP(pt.getProperty("LocalIP."+ServericeCount)
                        .trim());
                route.setLocalPort(Integer.parseInt(pt.getProperty("LocalPort" +
                        "."+ServericeCount)
                        .trim()));
                route.setDestHost(pt.getProperty("DestHost."+ServericeCount)
                        .trim());
                route.setDestPort(Integer.parseInt(pt.getProperty("DestPort."
                        +ServericeCount)
                        .trim()));
                route.setAllowCline(pt.getProperty("AllowCline."+ServericeCount)
                        .trim());
                routeList.add(route);
            }
            is.close();
            SysLog.info("Read cfg OK");
        } catch (FileNotFoundException e) {
            SysLog.error("Open LoadcfgFile false"+e);
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;


    }

    public static void main(String[] args) {
        startServer();//https://blog.csdn.net/samxx8/article/details/344280723
    }

}
