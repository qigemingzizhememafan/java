package com.lzl.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanOpreation {
    private BeanOpreation(){ }
    // 把传进来的emp.name:zhangsan|emp.job:coder进行拆分
    //  value：emp.name:zhangsan|emp.job:coder
    //  actionObj：xxAction
    public static void setBeanValue(Object actionObj,String value) throws Exception {
        // 1,进行字符串拆分
        String[] temp = value.split("\\|");
        for(int i = 0; i < temp.length; i++){
            String[] result = temp[i].split(":");
            // 取得真实要设置的内容 -- zhangsan
            String realValue = result[1];
            // 取得要设置的真实类名称-- emp
            String realClassName = result[0].split("\\.")[0];
            // 取得要设置的属性名称 -- name
            String attrName = result[0].split("\\.")[1];
            // 通过反射取得xxAction中的真实对象
            // 取得了emp对象
            Object realObj = getRealObject(actionObj,realClassName);
            // 1,取得emp的Class对象
            Class<?> cls = realObj.getClass();
            // 2,取得setter方法对象
            // 拼装setter方法名称
            String setName = "set" + initCap(attrName);
            Method setMethod = cls.getDeclaredMethod(setName,String.class);
            setMethod.invoke(realObj,realValue);
        }
    }
    // 取得真实操作的类对象
    // emp.name:zhangsan| emp.age:18
    // car.name:cc|car.price:230000
    // 可能是emp类，也可能是car类或其他别的类
    // 因为这个类对象现在在EmpAction中封装着，我们可以通过getEmp来获得该对象
    private static Object getRealObject(Object actionObj,String realClassName) {
        // 取得action对象的class对象
        Class<?> cls = actionObj.getClass();
        // 拼接getEmp方法名
        String methodName = "get" + initCap(realClassName);
        Object realObj = null;
        // 取得Method对象
        try {
            // 取得getEmp的Method对象
            Method method = cls.getDeclaredMethod(methodName);
            // 相当于调用empaction.getEmp();
            try {
                //invoke就相当于调用emp.getEmp
                realObj = method.invoke(actionObj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return realObj;
    }
        // 首字母大写
        private static String initCap(String str){
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }

