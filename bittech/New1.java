package com.bittech;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

class MyThread implements Runnable{
    private Object object = new Object();
    public void run(){
        synchronized(object){
            System.out.println("wait方法开始");
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait方法结束");
        }
    }
}
public class New1 {
    public static void main(String[] args) {
        Thread MyThread = new Thread();
        Thread thread  = new Thread("mt");
        thread.start();
        object.notify();
    }
}
       /* sb.append("a");  //为了避免三个append频繁的加锁解锁
        sb.append("b");//锁粗化将这三个捆绑在一起，只在开始时加一次锁
        sb.append("c");*/

/*class People{
    public People(String name){
        System.out.println(name);
    }
    public People(){

    }
}
class Student extends People{
    public Student(String name){
        super("张三");
        System.out.println("子类有参构造");
    }
    public Student(){
        super();
        System.out.println("子类无参构造");
    }
}
public class New1{
    public static void main(String[] args) {
        new Student();
    }
}*/
/*class Father{
    public Father(String name){
        System.out.println(name);
    }
}
class Son extends Father{
    public Son(){
        super("zhangsan");
        System.out.println("子类无参构造");
    }
}
public class New1{
    public static void main(String[] args) {
        new Son();
    }
}*/
/*class Person{
    private String name;
    public int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Student extends Person{

}
public class New1{
    public static void main(String[] args) {
        Student Person = new Student();
        Person.setName("张三");
        Person.age = 19;
        System.out.println(Person.getName());
        System.out.println(Person.age);
    }
}*/
/*class Person{
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private String name;
    private int age;
}
class Student extends Person{
    private String school;
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
}*/
/*class Person{
    public Person(){
        System.out.println("父类的构造方法");
    }
    static{
        System.out.println("父类的静态代码块");
    }
}
class Student extends Person{
    public Student(){
        System.out.println("子类的构造方法");
    }
    static{
        System.out.println("子类的静态代码块");
    }
}
public class New1{
    static{
        System.out.println("主类的静态代码块");
    }
    public static void main(String[] args) {
      new Student();
    }
}*/
        /*Student stu = new Student();
        stu.setName("张三");
        stu.setAge(18);
        stu.setSchool("北大");
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getSchool());
    }
}
        // new Person();
       // new Person();
/*class Person{
    public void print(){
        //this表示当前对象
        System.out.println("[Person类的print方法]"+this);
    }
}
public class New1{
    public static void main(String[] args){
        Person per1 = new Person();
        System.out.println("[main方法的输出]"+per1);//此时per1中存放的是堆空间的地址
        per1.print();								//print被Per1调用，上面print方法中的this就指的是per1
        System.out.println("------------------分割线------------------");
        Person per2 = new Person();
        System.out.println("[main方法的输出]"+per2);
        per2.print();
    }
}*/
/*class Person{
    private String name;
    private int age;
    public Person(){
        System.out.println("***********");
    }
    public Person(String name){
        this();
        this.name = name;
    }
    public Person(String name,int age){
        this(name);
        this.age = age;
    }
    public void getPersoninfo(){
        System.out.println("姓名为"+name+"年龄为"+age);
    }
}
public class New1{
    public static void main(String[] args) {
        Person per = new Person();
        Person per1 = new Person("张三");
        Person per2 = new Person("李四",20);
        per.getPersoninfo();
        per1.getPersoninfo();
        per2.getPersoninfo();
    }
}*/
/*class Person{
    public String name;
    public int age;
    public void eat(){
        System.out.println(name+"在吃饭");
    }
    public void sleep(){
        System.out.println(name+"在睡觉");
    }
    public void work(){
        if(age<18){
            System.out.println(name+age+"老老实实上学");
        }else{
            System.out.println(name+age+"老老实实工作");
        }
    }
}*/
/*class Person{
    private String name;
    private int age;
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void getPersoninfo(){
        System.out.println("姓名为"+name+"年龄为"+age);
    }
}*/
/*class Person{
    private String name;
    /*public void getPersoninfo(){
        System.out.println("姓名为"+name);
    }*/
 /*   public void setName(String name) {
        this.name = name;
    }
    public Person(String name){
        System.out.println("姓名为"+name);
    }
}*/
 /*class Person{
     private String name;
     private int age;
     public Person(){
         System.out.println("********");
     }
     public Person(String name){
         this();
         this.name = name;
     }
     public Person(String name,int age){
         this(name);
         this.age = age;
     }
     public void getPersoninfo(){
         System.out.println("姓名为"+name+"年龄为"+age);
     }*/
    /* public void Arr(){
         System.out.println("******");     }*/
/*class Person{
    public void print(){
        System.out.println(this);
    }
}
public class New1{
    public static void main(String[] args) {
        Person per1 = new Person();
        String a ="per1.print()";
        String b = "per1";
        System.out.println(a.equals(per1));
        System.out.println(a.equals("com.bittech.Person@1540e19d"));
        System.out.println(a.equals(b));
        System.out.println(per1);
        per1.print();
    }
}*/
      /* Person per1 = new Person();
        System.out.println(per1.getAge());*/
       /*per1.setName("张三");
       per1.setAge(18);
       per1.getPersoninfo();*/
        /* Person per1 = new Person();
        per1.name = "张三";
        per1.age = 17;
        per1.work();
        Person per2 = new Person();
        per2.name = "李四";
        per2.age = 23;
        per2.work();*/
        /*if(3>0 || 10/0>0){
            System.out.println("表达式为真");
        }*/
        /*int x = 3;
        int y = 4;
        System.out.println((x>y)?x+y:x-y);*/
        /*int num1 = 10;
        int num2 = 20;
        System.out.println("a"+10+20);
        System.out.println(""+10+20);
        System.out.println("结果是"+(10+20));*/
       /* System.out.println('0');
        System.out.println(0);
        System.out.println('0'==0);*/
        /*char a = 'A';
        int num = a;
        System.out.println('B');
        System.out.println(a+32);*/
        /*System.out.println(10/4);
        System.out.println(10F/4);
        System.out.println(10/4.0);*/
       /* float a = 1.1f;
        System.out.println(a*a);*/

