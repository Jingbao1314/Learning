package reflaction.remoteExecution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jingbao on 18-5-8.
 */
public class JavaClassExecuter {
    public static String execute(byte[] classByte){
        HackSystem.clearBuffer();
        ClassModifier cm=new ClassModifier(classByte);
        byte[] modiBytes=cm.modifyUTF8Constant("java/long/System",
                "reflaction/remoteExecution/HackSystem");
        HotSwapClassLoder loder=new HotSwapClassLoder();
        Class clazz=loder.loadByte(modiBytes);
        try {
            Method method=clazz.getMethod("main",new Class[]{String[].class});
            method.invoke(null,new String[] {null});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();

    }
}
