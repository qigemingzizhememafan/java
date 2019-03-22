package com.bittech;
/*class Person{
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    private void fun(){}
}
class Student extends Person{

}*/
/*class Person{
    public void fun(){
        System.out.println("father...");
    }
}
class Student extends Person{
    public void fun(){
        System.out.println("son...");
    }
}*/
/*class Person{
    public void test(){
        this.fun();
    }
    private void fun(){  //输出为我是爸爸，若将private改成public则是儿子
        System.out.println("我是爸爸");
    }
}
class Student extends Person{
    public void fun(){
        System.out.println("我是儿子");
    }
}*/
/*class Person{
    public String name = "爸爸";
}
class Student extends Person{
    public String name = "儿子";
    public void fun(){
        System.out.println(super.name);
    }
}*/
/*class  Person{
    public void fun(){
        System.out.println("我是爸爸");
    }
}
class Student extends Person{
    public void fun(){
        System.out.println("我是儿子");
        super.fun();
    }
}*/
/*class Person{
    //不加static修饰时，若是多次new Person(),造成空间浪费
    //因此加上static，放在全局数量区，可直接使用
    public final String COUNTRY = "中国"; //public static final
}*/
public class Test{
    byte b1 = 1,b2 = 2,b3,b6,b8;
    final byte b4 = 4,b5 = 5,b7 = 7;
    public void test(){
        //1  b3 = b1+b2;
        //2  b6 = b4+b5;
        //3  b7 = b1+b3;
        //4  b8 = b1+b4;
        //以上4个中哪个输出是错的.参考数据转换部分笔记
    }
    public static void main(String[] args) {
        new Test().test();
    }
}
/*final class Person{
    public  void fun(){
        System.out.println("1");
    }
}
class Student extends Person{  //此句冒红，会报错
    public void fun(){
        System.out.println("2");
    }
}
public class Test{
    public static void main(String[] args) {
        new Student().fun();
    }
}*/
/*class Person{
    public String name;
}
public class Test{
    public static void main(String[] args) {
        //此处final修饰指的是地址不能变，类中属性可以改变
        //final修饰基本数据类型不可变，即常量的值不能改变
        //修饰引用类型，即堆内存地址不能变
        final Person per = new Person();
        per.name = "张三";
        System.out.println(per.name);
        per.name = "李四";
        System.out.println(per.name);
        //per = new Person(); 这样会报错
    }
}*/
        //new Student().fun();
       /* Student student = new Student();
        student.setName("z");
        System.out.println(student.getName());*/
/*interface MyInterface{
    void test();
}
 class Oueetr{
    private int num = 5;
    public void display(int temp){
        new MyInterface(){
            public void test(){
                System.out.println("匿名实现MyInterface接口");
                System.out.println(temp);
                System.out.println(num);
            }
        }.test();
    }
}
 public class Test{
    public static void main(String[] args) {
        new Oueetr().display(3);
    }
}*/
/*class Outter{
    private int num;
    private int temp = 3;
    public void display( int num){
        class Inner{
            public void fun(){
                System.out.println(num);
                System.out.println(temp);
            }
        }
        new Inner().fun();
    }
}

public class Test {
    public static void main(String[] args) {
        new Outter().display(50);
    }
}*/
