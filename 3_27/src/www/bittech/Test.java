package www.bittech;
import java.util.Date;
//class Person {
//    private String name;
//    private Integer age;
//    private Double salary;
//
//    public Person() {
//    }
//
//    public Person(String name, Integer age, Double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", salary=" + salary +
//                '}';
//    }
//
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Person)) {
//            return false;
//        } else if (obj == this) {
//            return true;
//        }
//        Person per = (Person) obj;
//        return this.name.equals(per.name)&&
//                this.age.equals(per.age)&&
//                this.salary.equals(per.salary);
//    }
//}
//interface Compute{
//    public int Compute(int m,int n);
//}
//abstract class A implements Compute{
//    public int Compute(int m,int n){
//        return (m+n);
//    }
//}
//abstract class B implements Compute{
//    public int Compute(int m,int n){
//        return (m-n);
//    }
//}
//abstract class C implements Compute{
//    public int Compute(int m,int n){
//        return (m*n);
//    }
//}
//abstract class D implements Compute{
//    public int Compute(int m,int n){
//            return (m / n);
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//
//    }
//}
//        Person per = new Person("张三",122,200.0);
//        Person per1 = new Person("李四",100,2000.0);
//        Person per2 = new Person("李四",100,2000.0);
//        System.out.println(per);
//        System.out.println(per1);
//        System.out.println(per2);
//        System.out.println(per.equals(per1));
//        System.out.println(per1.equals(per2));
//class Node{
//    private Object data;
//    private Node next;
//    public Node(Object data){
//        this.data = data;
//    }
//    public Object getData(){
//        return data;
//    }
//    public void setData(Object data){
//        this.data = data;
//    }
//    public Node getNext(){
//        return next;
//    }
//    public void setNext(Node next){
//        this.next = next;
//    }
////}
//class Myclass<T>{
//    privapublic class Test{
////    public static void main(String[] args) throws ClassNotFoundException {
////        Class<?> cls = Class.forName("java.util.Date");
////        System.out.println(cls.getName());
//////        Date date = new Date();
//////        System.out.println(date);
//////        System.out.println(date.getClass());
////    }
////}te T value1;
//    public T getValue1(){
//        return value1;
//    }
//    public void setValue1(T value1){
//        this.value1 = value1;
//    }
//}
//
//        Myclass<String> myclass = new Myclass<String>();
//        myclass.setValue1("hello");
//        System.out.println(myclass.getValue1());
//        Myclass<Integer> myclass1 = new Myclass<Integer>();
//        myclass1.setValue1(123);
//        System.out.println(myclass1.getValue1());
//        Node head = new Node("火车头");
//        Node first = new Node("车厢一");
//        Node second = new Node("车厢二");
//        Node last = new Node("车厢尾");
//        head.setNext(first);
//        first.setNext(second);
//        second.setNext(last);
//        printLink(head);
//    }
//    public static void printLink(Node node){
//        if(node != null){
//            System.out.println(node.getData());
//            node = node.getNext();
//            printLink(node);
//        }
//class Singleton{
//    private static final Singleton singleton = new Singleton();
//    private Singleton(){
//
//    }
//    public static Singleton getSingleton(){
//        return singleton;
//    }
//    public void test(){
//        System.out.println(this);
//    }
//}
//class Singleton{
//    private static Singleton singleton;
//    private Singleton(){}
//    public void test(){
//        System.out.println(this);
//    }
//    public static Singleton getSingleton(){
//        if(singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
//}
//class Sex{
//    private String title;
//    public static final int MALE_FLAG = 1;
//    public static final int FEMALE_FLAG = 2;
//    private static final Sex MALE = new Sex("男");
//    private static final Sex FEMALE = new Sex( "女");
//    private Sex(String title){
//        this.title = title;
//    }
//    public static Sex getInstance(int flag){
//        switch (flag){
//            case MALE_FLAG:
//                return MALE;
//            case FEMALE_FLAG:
//                return FEMALE;
//            default:
//                return null;
//        }
//    }
//    @Override
//    public String toString() {
//        return this.title;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        System.out.println("数学计算开始前");
//        try {
//            System.out.println("数学计算中" + (10 / 0));
//        }catch (ArithmeticException e){
//          e.printStackTrace();
//        }finally {
//            System.out.println("我会被执行");
//        }
//        System.out.println("数学计算结束");
//        digui(10);
//    }
//    public static int  digui(int num){
//        return digui(num);
//    }
//        Sex male = Sex.getInstance(Sex.MALE_FLAG);
//        Sex female = Sex.getInstance(Sex.FEMALE_FLAG);
//        System.out.println(male);
//        System.out.println(female);
//    }
//}
//    Singleton singleton1 = Singleton.getSingleton();
//        Singleton singleton2 = Singleton.getSingleton();
//       singleton1.test();
//        singleton2.test();
//class intDemo{
//    private int value;
//    public intDemo(int value){
//        this.value = value;
//    }
//    public int value(){
//        return this.value;
//    }
//}
//      String str = String.valueOf(10);
//      System.out.println(str+10);
//      String str = "123";
//      int i = Integer.parseInt(str);
//      System.out.println(str+10);
//      System.out.println(i+10);
//      Integer i1 = 10;
//      Integer i2 = new Integer(10);
//      Integer i3 = 10;
//      Integer i4 = 128;
//      Integer i5 = 128;
//      System.out.println(i1 == i2);
//      System.out.println(i1 == i3);
//      System.out.println(i4 == i5);
//      //手动装箱
//      Integer i = new Integer(20);
//      //手动拆箱
//      int result = i.intValue();
//      System.out.println(result+10);
//      //自动装箱
//      Integer i1 = 20;
//      System.out.println(i1);
//      System.out.println(i == i1);
//      System.out.println(i.equals(i1));
//          intDemo demo = new intDemo(10);
//          int result = demo.value();
//          System.out.println(demo.value()+20);
//        Object obj = new int[] {1,2,3,4,5};
//        int[] data = (int[])obj;
//        for(int data1:data) {
//            System.out.println(data1);
//        }
//class Person{
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//    private String name;
//    private int age;
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//    public boolean equals(Object obj){
//        if(!(obj instanceof Person)){
//            return false;
//        }
//        if(obj == this){
//            return true;
//        }
//        Person per = (Person) obj;
//        return per.name.equals(this.name) && (per.age == this.age);
//    }
//}
//        Person per1 = new Person("张三",18);
//        Person per2 = new Person("李四",19);
//        System.out.println(per1.equals(per2));
//       System.out.println(obj);
//    }
//    public static void main(String[] args) {
//            fun("hello");
//            fun(new Person("张三",18));
//        StringBuffer sb = new StringBuffer("hello");
//        String rusult = sb.toString();
//        System.out.println(result.isEmpty());
//        sb.append("hello").append("world").append(10);
//        System.out.println(sb);
//        String str = "  hello world";
//        System.out.println(str);
//        String str1 = str.trim();
//        System.out.println(str1);
//        String str = "hello bithellojava";
//        System.out.println(str);
//        String[] result = str.split(" ");
//        for(String str1: result){
//            System.out.println(str1);
//        }
//        String str1 = "he";
//        String str2 = "hello";
//        System.out.println(str2.contains(str1));
//        System.out.println(str1.compareTo(str2));
//        String str = "hello";
//        byte[] data = str.getBytes();
//        System.out.println(data);
//        for(byte b: data){
//            System.out.println(b);
//        }
//        byte[] data = new byte[]{1,3,5,7};
//        String str = new String(data);
//        System.out.println(data);



