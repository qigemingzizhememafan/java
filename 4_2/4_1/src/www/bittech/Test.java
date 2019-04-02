package www.bittech;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
public class Test{
    private static Test test;
    public void iaAlive(){
        if(test != null){
            System.out.println("I am Alive ");
        }
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method excute");
        test = this;
    }
    public static void main(String[] args) {
        test = new Test(); //可达
        test = null;  //不可达
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(test != null){
            test.iaAlive();
        }else{
            System.out.println("I am dead");
        }
        //----------------分界线
        test = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(test != null){
            test.iaAlive();
        }else{
            System.out.println("I am dead");
        }
    }
}
///*
//*  -XX:+PrintGC
//* */
//public class Test {
//    private Object instance;
//    private static int _1MB = 1024*1024;
//    private byte[] bigSize = new byte[2 * _1MB];
//    public static void main(String[] args){
//        Test test = new Test(); //test为强引用
//        SoftReference softReference  = new SoftReference(test); //软引用 存活，内存大于2M故活着
//        // WeakReference softReference = new WeakReference(test); 弱引用
//        test = null;
//        System.gc();
//    }
//}
//class Person{
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", job='" + job + '\'' +
//                '}';
//    }
//
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getJob() {
//        return job;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//
//    private String job;
//}
//public class Test{
//    public static void main(String[] args) {
//        String value = "emp.name:张三|emp.job:linux";
//        EmpAction empAction = new EmpAction();
//        empAction.setValue(value);
//        System.out.println(empAction.getEmp());
//        Person per = new Person();
//        per.setJob("linux");
//        per.setName("zhangsan");
//        System.out.println(per);
//interface Computer{
//    void printComputer();
//}
//class MacbookPro implements  Computer{
//    public void printComputer(){
//        System.out.println("this is a mac...");
//    }
//}
//class Surface implements Computer{
//    public void printComputer(){
//        System.out.println("this ia a surface...");
//    }
//}
//public class Test {
//    public void buyComputer(Computer computer){
//        computer.printComputer();
//    }
//    public static void main(String[] args) {
//        Test test = new Test();
//        test.buyComputer(new MacbookPro());
//    }
//}
