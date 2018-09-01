package org2;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by jingbao on 18-2-1.
 */
public class Server extends Thread{
    private ServerSocket myServer=null;//服务器
    private boolean isStop=false;//控制连接队列
    private Vector connectonQueue=null;//连接队列
    private int connCounter=0;
    private Route route=null;//路由对象
    private static int myId=0;//连接ID

    public Server(Route route,int id){
        this.route=route;
        myId=id;
        connectonQueue=new Vector();
        start();
    }
    
    public void closeServer(){
        isStop=true;
        if(myServer!=null){
            closeServerSocket();
        }
        while (this.connectonQueue.size()>0){
            Transfer transfer=(Transfer) connectonQueue.remove(0);
            transfer.closeSocket(transfer.socket);
            transfer=null;

        }
    }
    public void run(){
        try {
            SysLog.info("start Transfer..........."+route.toString());
            ServerSocket myServer=null;
            InetAddress myAD= Inet4Address.getByName(route.getLocalIP());
            myServer=new ServerSocket(route.getLocalPort(),4,myAD);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        SysLog.info("Transfer :"+route.toString());
        while (!isStop){
            String clineIp=null;
            try {
                Socket socket=myServer.accept();
                clineIp=socket.getInetAddress().getHostAddress();
                if(checkIp(route,clineIp)){
                    SysLog.warning("transfer Server:"+route.toString()
                            +"Incoming:"+socket.getInetAddress());
                    socket.setSoTimeout(0);
                    connCounter++;
                    Transfer myTransfer=new Transfer(socket,route);
                    connectonQueue.add(myTransfer);
                    //++++++

                }else{
                    SysLog.warning("transfer Server:"+route.toString()
                            +"Refuse:"+socket.getInetAddress());
                    closeSocket(socket);
                    //++++++++++++++++++++++++++++++++++
                }
            } catch (IOException e) {
                SysLog.error("Transfer Server:"+route.toString()+"accept " +
                        "error"+ e);
                e.printStackTrace();
            }
        }
    }

    private void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkIp(Route route, String clineIp) {
        String[] cline=myGetStringArray(clineIp,".");
        String[] server=myGetStringArray(route.getAllowCline(),".");
        if(cline.length!=server.length){
            SysLog.error("Transfer Server Error : "+route.toString());
            return false;
        }
        for(int i=0;i<cline.length;i++){
            if((!cline[i].equals(server[i]))&&(server[i].equals("*"))){
                System.out.println(":" + cline[i]+":   "+server[i]);
                return false;
            }
        }

        return true;//+++++++++++++++++++
    }
    private static final String[] myGetStringArray(String Input,String
            Delimiter){
        int index=0;
        String []result;
        StringTokenizer st=new StringTokenizer(Input,Delimiter);//(原字符，分割符)
        result=new String[st.countTokens()];//分割后令牌（Token）的个数
        while (st.hasMoreTokens()){
            result[index]=st.nextToken().trim();
            index++;
        }
        return result;


    }


    private void closeServerSocket() {
        try {
            this.myServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
