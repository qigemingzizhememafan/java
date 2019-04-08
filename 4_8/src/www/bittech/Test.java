package www.bittech;

import java.io.File;
import java.lang.reflect.Field;

//class Singleton{
//    //产生了唯一一个对象
//    private static final Singleton singleton = new Singleton(); //静态私有属性，类加载时产生
//    // 限制在外部产生对象的方法
//    private Singleton(){}
//    public static Singleton getInstance(){ //普通方法需要通过对象调用，
//        System.out.println("hello");
//        return singleton;   // 外部无法取得对象，故要加static,静态方法通过类名称调用即可
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Singleton singleton1 = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//        System.out.println(singleton1 == singleton2); //true
//    }
//}
//class Singleton{
//    private Singleton(){}
//    private static Singleton singleton = new Singleton();
//    public static Singleton getSingleton(){
//        System.out.println("hi");
//        return  singleton;
//
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//            Singleton singleton1 = Singleton.getSingleton();
//            Singleton S = Singleton.getSingleton();
//            System.out.println(singleton1 == S);
//    }
//}
//懒汉式单例
//class Singleton{
//    private static Singleton singleton;
//    private Singleton(){}
//     public static Singleton getInstance() {
//         if(singleton == null){
//             singleton = new Singleton();
//         }
//         return singleton;
//     }
//     public void print(){
//         System.out.println("hello java");
//     }
//}
//public class Test{
//    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
//        singleton.print();
//    }
//}
// 接收任意个整数，返回它们相加的结果
//public class Test{
//    public static void main(String[] args) {
//        System.out.println(add(new int[]{1,2,3}));
//        System.out.println(add(new int[]{4,5,6}));
//    }
//    public static int add(int... data){ // 可变参数类型
//        int result = 0;
//        for(int i = 0; i < data.length; i++){
//            result += data[i];
//        }
//        return result;
//    }
//}
// 泛型
//class MyClass<T>{
//    private T val1;
//    public T getVal1() {
//        return val1;
//    }
//    public void setVal1(T val1) {
//        this.val1 = val1;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyClass<String> myClass = new MyClass<String>();
//        myClass.setVal1("hello");
//        myClass.getVal1();
//        MyClass<Integer> myClass1 = new MyClass<Integer>();
//        myClass1.setVal1(123);
//        myClass1.getVal1();
//    }
//}
// 定义两个类型不同的参数
//class MyClass<T,E>{
//    private T val1;
//    private E val2;
//    public T getVal1() {
//        return val1;
//    }
//    public void setVal1(T val1) {
//        this.val1 = val1;
//    }
//    public E getVal2() {
//        return val2;
//    }
//    public void setVal2(E val2) {
//        this.val2 = val2;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyClass<String,Integer> myClass = new MyClass<>();
//        myClass.setVal1("hi");
//        myClass.setVal2(123);
//        System.out.println(myClass.getVal1());
//        System.out.println(myClass.getVal2());
//    }
//}
// 泛型方法
//class MyClass{
//    public<T> void print(T t){
//        System.out.println(t);
//    }
//}
//class Test{
//    public static void main(String[] args) {
//        MyClass myClass = new MyClass();
//        myClass.print("hello");
//        myClass.print(123);
//        myClass.print(123.45);
//    }
////}
//class MyClass<T> {
//    private T value1;
//    public T getValue1() { return value1; }
//    public void setValue1(T value1) { this.value1 = value1; }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyClass<String> myClass = new MyClass<>(); //若要改成Integer，下面的print方法也要改
//        myClass.setValue1("hello");                 //若有N个类型，则需要写N个重载方法，故产生了通配符
//        print(myClass);
//    }
//    public static void print(MyClass<String> myClass){
//        System.out.println(myClass.getValue1());
//    }
//}
class MyClass<T,E>{
    private T message;
    private E text;
    public T getMessage() {
        return message;
    }
    public void setMessage(T message) {
        this.message = message;
    }
    public E getText() {
        return text;
    }
    public void setText(E text) {
        this.text = text;
    }
    public void testMethod1(T t){
        System.out.println(t);
    }
}
public class Test{
    public static void main(String[] args) {
        MyClass<String,Integer> myClass1 = new MyClass<>();
        Class cls = myClass1.getClass();
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType());
        }
    }
}