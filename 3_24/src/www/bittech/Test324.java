package www.bittech;
//interface MyInterface{
//    void test();
//}
//class Outter {
//    int num = 5;
//    public void fun(final int temp){
//        new MyInterface(){
//            public void test(){
//                System.out.println("匿名实现MyInterface接口");
//                System.out.println(num);
//                System.out.println(temp);
//            }
//        }.test();
//    }
//}

//public  void fun(){ //final修饰的方法不能被覆写
//        System.out.println("父类final方法");
//    }
//     public String country = "CHINA";
//      static String country = "中国";
//class Student extends Person{ //被final修饰的类不能被继承
//    public void fun(){
//        System.out.println("a");
//    }
//}
//abstract class Person{
//    private String name;
//    public String getName() {
//        return name;
//    }
//    public void fun(){
//        System.out.println("父类fun方法");
//    }
////    public void test(){}
//}
//class Student extends Person{
//    public void fun(){
//        System.out.println("子类方法覆写");
//    }
//    @Override
//    public void fun() {
//        System.out.println("子类fun方法");
//    }
//    @Override
//    public void test() {
//        System.out.println("子类test方法");
//    }
//abstract class Person{
//    private String name;
//    public void fun(){
//        System.out.println("父类fun方法");
//    }
//    public Person(){
//        System.out.println("*********");
//    }
//    public String getName() {
//        return name;
//    }
//}
//class Student extends Person{
//    public Student(){
//        System.out.println("##########");
//    }
//    public void fun(){
//        System.out.println("子类覆写fun方法");
//    }
//}
//abstract class Person{
//    public Person(){
//        this.print();
//    }
//    public abstract void print();
//}
//class Student extends Person{
//    private int num = 5;
//    public Student(int num){
//        this.num = num;
//    }
//    public void print(){
//        System.out.println(this.num);
//    }
//}
//abstract class Person{
//    public Person(){}
//}
//class Student extends Person{
//
//}
//abstract class Person{
//    public abstract void fun();
//    abstract class A{
//        public abstract void fun2();
//    }
//}
//class Student extends Person{
//    @Override
//    public void fun() {
//        System.out.println("覆写抽象类fun方法");
//    }
//    class c extends A{
//        public void fun2(){
//            System.out.println("覆写抽象内部类fun2方法");
//        }
//    }
//}
//interface IMyInterface{
//    public static final int num = 5;
//    public abstract void test();
//}
//interface INews{
//    public abstract void fun();
//}
//class MyInterfaceImpl implements IMyInterface,INews{
//    public void test(){
//        System.out.println(num);
//    }
//    public void fun(){
//        System.out.println(num);
//    }
//}
interface IMyInterface{
    public static final String MSG = "MSG消息";
    public abstract void test();
}
interface INews{
    public abstract void news();
}
class MyInterfaceImpl implements IMyInterface,INews{
    public void test(){
        System.out.println(MSG);
    }
    public void news(){
        System.out.println(MSG+"hhhh");
    }
}
public class Test324 {
    public static void main(String[] args) {
        IMyInterface iMyInterface = new MyInterfaceImpl();
        INews iNews = (INews) iMyInterface;
        iNews.news();
//        iNews.test();
//        IMyInterface iMyInterface = new MyInterfaceImpl();
//        iMyInterface.test();
//        INews iNews = new MyInterfaceImpl();
//        iNews.fun();
//        new Student();
//        new Person();
//        new Student(30).print();
//       new Student();
//        Person per = new Student();
//        per.fun();
//        Outter outter = new Outter();
//        outter.fun(1);
//        new Student().fun();
//        final Person per = new Person();
//        per.country = "C";
//        System.out.println(per.country);
//        per.country = "D";
//        System.out.println(per.country);
        //per = new Person();被final修饰不能重新引用
        //final int i = 0;  //static修饰变量不能出现在主方法
        //System.out.println(new Person().country);
    }
}
