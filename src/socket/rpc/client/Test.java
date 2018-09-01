package socket.rpc.client;

//import org.socket.rpc.idl.Client;

import socket.rpc.idl.Client;

import java.io.IOException;

/**
 * Created by andilyliao on 17-4-9.
 */
public class Test {
    public static void main(String[] args) {
        Client client=new Client();
        try {
            boolean res=client.login("localhost",8888,"aaa","aaa");
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
