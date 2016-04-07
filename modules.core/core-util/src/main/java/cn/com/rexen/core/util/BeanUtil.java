package cn.com.rexen.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author  chenyanxu
 */
public final class BeanUtil {
    public static Object getBeanFieldValue(Object bean,String fieldName){
        Object rtn=null;

        try {
            Method method= bean.getClass().getMethod("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));

            rtn= method.invoke(bean);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return rtn;
    }

    public static Map getBeanListFieldValues(List list, String fieldName){
        Map rtnMap=new Hashtable<Object,Object>();

        for(int index=0;index<list.size();++index){
            Object bean=list.get(index);

            rtnMap.put((getBeanFieldValue(bean,"id").toString()),getBeanFieldValue(bean,fieldName));
        }

        return rtnMap;
    }

    public static void setBeanFieldValue(Object bean,String fieldName,Object fieldValue){
        try {
            Method method=null;

            if(fieldName.equals("id")){
                method= bean.getClass().getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1),Long.TYPE);
            }
            else{
                Field field = bean.getClass().getDeclaredField(fieldName);

                method= bean.getClass().getMethod("set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1),field.getType());
            }

            method.invoke(bean,fieldValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void setBeanListFieldValues(List beanList,String fieldName,List fieldValues){
        if(beanList!=null){
            for(int index=0;index<beanList.size();++index){
                Object bean=beanList.get(index);

                setBeanFieldValue(bean,fieldName,fieldValues.get(index));
            }
        }
    }
}
