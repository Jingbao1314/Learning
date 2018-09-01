package org2;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by jingbao on 18-2-1.
 */
public class Transfer extends Thread{
    private Route route=null;//传输对象的信息
    Socket socket;
    private  static int TIMEOUT=1000;//超时时间
    private static int BUFSIZE=1024;//缓冲区大小
    public Transfer(Socket socket,Route route){
        this.socket=socket;
        this.route=route;
        this.start();
    }
    public void run(){
        Socket outbound=null;
        try {
            outbound=new Socket(route.getDestHost(),route.getDestPort());
            socket.setSoTimeout(TIMEOUT);
            InputStream is=socket.getInputStream();
            outbound.setSoTimeout(TIMEOUT);
            OutputStream os=socket.getOutputStream();
            pipe(is,outbound.getInputStream(),os,socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    private void pipe(InputStream is, InputStream inputStream, OutputStream os,
                      OutputStream outputStream) {
        int flag;
        byte buffer[]=new byte[BUFSIZE];
        while (true){
            try {
                if((flag=is.read(buffer))>0){
                    os.write(buffer,0,flag);
                }else if(flag<0){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if((flag=inputStream.read(buffer))>0){
                    outputStream.write(buffer,0,flag);
                }else if(flag<0){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void closeSocket(Socket s){
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
