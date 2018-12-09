package myaop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jingbao on 18-12-5.
 */
public class Init {
    public static void main(String[] args){
        try {
            String[] arg={"hadoop","hbase","pig","hive","mahout","hdfs","mapreduce","yarn"};
            Object[] objs=new Object[1];
            objs[0]=arg;
            Class busClass=Class.forName(TestAnnotation.class.getName());
            Method busMethod=busClass.getMethod("setParameter", String[].class);
            busMethod.invoke(busClass.newInstance(), objs);
            MyAOPUtils.excuteAdvicer(busMethod,objs,new Object());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
