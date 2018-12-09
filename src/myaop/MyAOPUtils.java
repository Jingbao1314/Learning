package myaop;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jingbao on 18-12-5.
 */
public class MyAOPUtils {
    private static boolean parameterAdvicerUtils(Annotation advicerManagerClass,int indexArg,Object[] paraValues, Class<?>... paraTypes){
        if(advicerManagerClass instanceof MyPointcutAnnotation){
            //接口参数验证通过后执行
            //切点通知处理
            MyPointcutAnnotation AdvicerClass=(MyPointcutAnnotation)advicerManagerClass;
            Class<?> adviceClass=AdvicerClass.className();
            try {
                Method adviceMethod=adviceClass.getMethod(AdvicerClass.method(),paraTypes);
                adviceMethod.invoke(adviceClass.newInstance(), paraValues);
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

        }else if(advicerManagerClass instanceof MyParameterAnnotation){
            //对输入的参数做一些通用处理和安全性检查等等
            //一般用在DAO层sql拼装特殊字符检查，数据格式合法性检查，转码或对调用者使用定义切点接口使用权限，安全性，等信息进行检查和确认等场合；当切点参数通过通知类中定义的接口处理后再调用切点方法；如MyBatis中通过注解@SelectProvider方式生成合法的SQL语句需要对拼装的sql语句传入的参数进行验证等，还有就是从安全新考虑对传入的模块调用者身份进行检查，MyBatis通过注解方式定义接口实现动态SQL生成中关键就是对数据类型的解析
            if(indexArg<0){
                return true;
            }
            MyParameterAnnotation AdvicerClass=(MyParameterAnnotation)advicerManagerClass;
            //处理切点方法参数的通知，大概思路如下：
            //1.解析参数类型
            //2.获取参数值
            //3.调用通知处理接口检查参数合法性
            //4.返回检查结果 true:false
        }
        return true;
    }
    private static boolean methodAdvicerUtils(Annotation advicerManagerClass,Object[] paraValues, Class<?>... paraTypes){
        return parameterAdvicerUtils(advicerManagerClass,-1,paraValues,paraTypes);
    }
    private static boolean excuteMethodAdvicers(Method pointJoinMethod,Object[] paraValues){
        boolean result=true;
        Annotation[] methodAnns=pointJoinMethod.getAnnotations();
        for(Annotation methodAnn:methodAnns){
            result=methodAdvicerUtils(methodAnn, paraValues,pointJoinMethod.getParameterTypes());
            if(!result){
                break;
            }
        }
        return result;
    }
    private static boolean excuteParameterAdvicers(Method pointJoinMethod,Object[] paraValues){
        boolean result=true;

        Annotation[][] parameterAnns=pointJoinMethod.getParameterAnnotations();
        if(parameterAnns==null||parameterAnns.length==0){
            return result;
        }
        for(int index=0;index<parameterAnns.length;index++){
            if(!result){
                break;
            }
            Annotation[] argAnns=parameterAnns[index];
            for(Annotation argAnn:argAnns){
                result=parameterAdvicerUtils(argAnn,index, paraValues,pointJoinMethod.getParameterTypes());
                if(!result){
                    break;
                }
            }
        }
        return result;
    }
    public static boolean excuteAdvicer(Method pointJoinMethod, Object[] paraValues, Object methodResultObj){
        boolean result=false;
        if(excuteParameterAdvicers(pointJoinMethod,paraValues))//切点函数定义的需要验证的通知验证通过后执行
        {
            result=excuteMethodAdvicers(pointJoinMethod, paraValues);
        }
        return result;
    }
}
