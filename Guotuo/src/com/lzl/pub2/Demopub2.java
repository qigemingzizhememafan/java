package com.lzl.pub2;  // pub2包
import com.lzl.pub1.*; // 导入pub1包，就可以看到pub1包里的内容了，但能否访问取决于Pub1包里类的权限

// 两个包中的类并没有继承关系
public class Demopub2 {
    public static void main(String[] args) {
        // 1,实例化pub1包中Demopublic1类，产生一个aDemo1对象
        Demopublic1 aDemo1= new Demopublic1();
        // 2,调用aDemo1对象的method方法，会输出那句话，能调用是因为类中方法是public属性的
        aDemo1.method();
        // 3,给属性赋值，因为public才能赋值
        aDemo1.varValue= 10;
        int aTep = aDemo1.varValue;
        System.out.println("aTep="+aTep);
    }}
