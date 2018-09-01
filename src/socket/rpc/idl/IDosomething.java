package socket.rpc.idl;

//import org.socket.rpc.framework.IDoSomethingIntf;

import socket.rpc.framework.IDoSomethingIntf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by andilyliao on 17-4-9.
 */
public abstract class IDosomething implements IDoSomethingIntf {
    public String doSomething(Method m, String param) throws InvocationTargetException, IllegalAccessException {
        String str[]=param.split("\\|");
        boolean b= (boolean) m.invoke(this,str[2],str[3]);
        System.out.println("********");
       if (b){
           System.out.println("TTTTTTT");
           return "TRUE";
       }else{
           System.out.println("FFFFFFF");
           return "FALSE";
       }
    }
}
