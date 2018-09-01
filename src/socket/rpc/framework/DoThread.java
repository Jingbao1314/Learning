package socket.rpc.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by andilyliao on 17-4-9.
 */
public class DoThread extends Thread {
    public IDoSomethingIntf getiDosomething() {
        return iDosomething;
    }//Login

    public void setiDosomething(IDoSomethingIntf iDosomething) {
        this.iDosomething = iDosomething;
    }

    private IDoSomethingIntf iDosomething=null;
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private Socket socket=null;
    @Override
    public void run() {
        try {
            System.out.println("=================");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            String str[]=line.split("\\|");
            String classname=str[0];
            String methodname=str[1];
            String res="";
            Method[] m = iDosomething.getClass().getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                String name = m[i].getName();
                System.out.println(name);
                if (name.equals(methodname)) {
                    res = iDosomething.doSomething(m[i], line);
                }
            }
            PrintStream ps = new PrintStream(socket.getOutputStream());
            System.out.println(res);
            ps.println(res);
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
