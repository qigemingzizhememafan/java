package com.com.dd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CreateDynamic implements InvocationHandler {

    //对真实对象的引用
    private Object targetObejct;

    public CreateDynamic(Object obj){
        this.targetObejct = obj;
    }

    //创建动态代理对象
    public Object newInstanceProxyObejctFuncion(){
        return Proxy.newProxyInstance(this.targetObejct.getClass().getClassLoader(),
                this.targetObejct.getClass().getInterfaces(),
                this);
    }

    /**
     * 生成动态代理对象之后系统默认调用的第一个方法就是invoke方法
     * @param proxy ：目标对象
     * @param method：目标对象中的方法
     * @param args ：目标对象方法中的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        try {
            this.securityCheck();//横切关注点
            obj = method.invoke(this.targetObejct,args);
//            if(method.equals("addUser")){
//
//            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    public void securityCheck(){
        System.out.println("=======securityCheck()==========");
    }

//    public void logCheck(){
//        System.out.println("=======securityCheck()==========");
//    }
}
