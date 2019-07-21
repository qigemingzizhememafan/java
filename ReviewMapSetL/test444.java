package com.lzl;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//public class test444 {
//    public static void main(String[] args) {
//        Vector<String> vec = new Vector();
//        vec.add("0");
//        vec.add("hkg");
//        vec.add("po");
//        vec.add("hnui");
//        Enumeration enumeratio = vec.elements();
//        String s = (String) enumeratio.nextElement();
//        System.out.println(s);
//        while(enumeratio.hasMoreElements()){
//            System.out.println(enumeratio.nextElement());
//        }
//    }
//}
//class A{}
//interface B{}
//interface C{}
//class D extends A implements B,C{
//
//}
//public class test444{
//    public static void main(String[] args) {
//        Class<?> clf = int.class;
//        Class<?> clf1 = Integer.class;
//        System.out.println(clf);
//        System.out.println(clf1);
//        System.out.println(clf.equals(clf1));
//        System.out.println(clf == clf1);
//          Class<?> cls = D.class;
//        System.out.println(cls.getSuperclass());
//        System.out.println(cls.getSuperclass().getName());
//        Class<?>[] classes = cls.getInterfaces();
//        for(Class clss: classes){
//            System.out.println(clss);
//            System.out.println(clss.getName());
//        }
//        List<String> list = new ArrayList<>();
//        Collections.addAll(list,"A","B","C","D","A","B");  //modCount = 6
//        Iterator<String> iterator = list.iterator();  //取得集合迭代器，expectedModCount = 6
//        while(iterator.hasNext()){
////调用checkForComodification检查副本中的expectModeCount是否等于集合的ModCount
//            String str = iterator.next();
//            if(str.equals("B")){
//// 集合类提供的remove
//                list.remove("B");   // 改为iterator.remove就不会报错  modCount = 7
//                continue;
//            }
//            System.out.println(str);
//        }
//    }
//}
class Per{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class test444{
    public static void main(String[] args) throws Exception {

    }
}