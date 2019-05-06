package www.bittech;

import java.util.concurrent.Callable;

// 线程启动通过实现Callable

//线程启动通过实现Runnable接口
//class MyThread implements Runnable{
//    private String titile;
//    public MyThread(String title){
//        this.titile = title;
//    }
//    @Override
//    public void run() {
//        for(int i = 0;i < 10;i++){
//            System.out.println(this.titile+"、"+i);
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread("线程一");
//        MyThread myThread1 = new MyThread("线程二");
//        MyThread myThread2 = new MyThread("线程三");
//         new Thread(myThread).start(); //Thread源码463行
//         new Thread(myThread1).start();
//         new Thread(myThread2).start();
//    }
//}
//// 匿名内部类实现
//public class Test{
//    public static void main(String[] args) {
////        Runnable runnable = new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("helloworld");
////            }
////        };
////        Runnable runnable  = () -> System.out.println("helloworld");
////        Thread thread = new Thread(runnable);
////        thread.start();
////    }
////}
//
//// 线程启动通过继承Thread
////class MyThread extends Thread{
////    private String title;
////
////    public MyThread(String title) {
////        this.title = title;
////    }
////
////    @Override
////    public void run() {
////        for(int i = 0;i < 10;i++){
////            System.out.println(this.title+"、"+i);
////        }
////    }
////}
////public class Test {
////    public static void main(String[] args) {
////        MyThread thread = new MyThread("线程一");
////        MyThread thread1 = new MyThread("线程二");
////        MyThread thread2 = new MyThread("线程三");
////        thread.start();
////        thread1.start();
////        thread2.start();
////    }
////}
//
//// 方法重写
////class Father{
////    private String name;
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public void print(){
////        System.out.println("姓名"+name);
////    }
////}
////class Son extends Father{
////    private int age;
////
////    public int getAge() {
////        return age;
////    }
////
////    public void setAge(int age) {
////        this.age = age;
////    }
////
////    public void print(){
////        System.out.println("姓名"+this.getName()+"年龄"+age);
////    }
////}
////public class Test{
////    public static void main(String[] args) {
////        Son son = new Son();
////        son.print();
////    }
////}
//
//// 方法重写
////class Person{
////    public void test(){
////        this.fun();
////    }
////    private void fun(){   // private与public结果会不同
////        System.out.println("我是爸爸");
////    }
////}
////class Student extends Person{
////    public void fun(){
////        System.out.println("我是儿子");
////    }
////}
////public class Test{
////    public static void main(String[] args) {
////        new Student().test();
////    }
////}
//
//// super.print
////class Person{
////    public void print(){
////        System.out.println("father");
////    }
////}
////class Son extends Person{
////    public void print(){
////        super.print();
////        System.out.println("child");
////    }
////}
////public class Test{
////    public static void main(String[] args) {
////        Son son = new Son();
////        son.print();
////    }
////}
//
//// 方法重写返回值类型可以是其子类
////class Pet{
////    public Pet print(){
////        System.out.println("pet");
////        return new Pet();
////    }
////}
////class Dog extends Pet{
////    public Dog print(){
////        System.out.println("Dog");
////        return new Dog();
////    }
////}
////public class Test{
////    public static void main(String[] args) {
////        Dog dog = new Dog();
////        dog.print();
////    }
////}

// 重写equals方法
//class   Student{
//    private String name;
//    private int age;
//    private int id;
//
//    public Student(String name, int age, int id) {
//        this.name = name;
//        this.age = age;
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", id=" + id +
//                '}';
//    }
//
//    public boolean equals(Object obj){
//        if(!(obj instanceof Student)){
//            return false;
//        }
//        if(obj == this){
//            return true;
//        }
//        Student per = (Student) obj;
//        return per.name.equals(this.name) && (per.age == this.age) &&(per.id == this.id);
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        Student per1 = new Student("张三",18,22);
//        Student per2 = new Student("张四",18,23);
//        System.out.println(per1.equals(per2));
//    }
//}