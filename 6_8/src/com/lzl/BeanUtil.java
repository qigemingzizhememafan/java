package com.lzl;

import java.lang.reflect.Method;

// 操作简单类属性设置的工具类，一定要用反射，
// 不然每个类都有不同的属性，我们需要很多个xxxUtil类
// 用反射只需要传入类的Class类就可以了
public class BeanUtil {
    private BeanUtil(){ }
    // actionObj：拿到提供给用户使用的xxAction类，xxAction包含了具体要操作的属性
    // beanValue：要设置的具体值
    // beanValue的值是这种形式：emp.name:zhangsan| emp.job：coder,需要拆分它
    public static void setEmpValue(Object actionObj,String beanValue) throws Exception{
        String[] temp = beanValue.split("\\|"); // |是位操作符，需要转义
        // emp.name:zhangsan
        // emp.job:coder
        for(int i = 0; i < temp.length; i++) {
            String[] result = temp[i].split(":");
            // emp.name
            // zhangsan
            String realValue = result[1]; // 真正的值
            // 将emp.name再拆分，拿到类名称
            String className = result[0].split("\\.")[0]; // .也需要转义
            String attrName = result[0].split("\\.")[1];
            Object realObj = getRealObject(actionObj,className);
            // 调用真正类的setter方法设置属性值
            // 取得真正主题类的class对象
            Class<?> cls = realObj.getClass();
            // 拼装setter方法名
            String setName = "set" + initCap(attrName);
            // 取得setter方法的method对象
            Method setMethod = cls.getMethod(setName,String.class);
            // 调用invoke通过反射设置值
            setMethod.invoke(realObj,realValue);
        }
    }
    // 根据XXAction类取得真正操作的主题类Emp
    // 通过反射调用getEmp()
    private static Object getRealObject(Object actionObj,String className) throws Exception{
        // 1,取得xxAction Class对象
        Class<?> cls = actionObj.getClass();
        // 2，拼装getXX()方法名称
        String methodName = "get"+initCap(className);
        // 3, 取得该方法名称的Method对象
        Method method = cls.getMethod(methodName);
        // 4, 通过反射调用该方法
        // 等同于empAction.getEmp();
        return method.invoke(actionObj);
    }
    private static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
