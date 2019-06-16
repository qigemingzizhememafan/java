package com.lzl;
public class Test{
    public static void main(String[] args) {
        String foo1 = args[1];
        String foo2 = args[2];
        String foo3 = args[3];

    }
}
// 加了volatile的双重检查的单例模式
//class Singleton{
//    private static Singleton singleton = new Singleton();
//    private Singleton(){
//    }
//    public static Singleton getInstance(){
//        if(singleton == null){
//            synchronized (Singleton.class){
//                if(singleton == null){
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}
// 双重检查的单例模式
//class Singleton{
//    private static Singleton singleton = new Singleton();
//    private Singleton(){
//    }
//    public static Singleton getInstance(){ // 在这里加锁也只会产生一个对象，但这种加锁力度太粗，加锁范围太大
//        if(singleton == null){             // single checked，虽然下面锁住了
//            synchronized (Singleton.class){ // 但是还是有两个线程在之前判断为空，可能产生两个对象
//                if(singleton == null){       // double checked
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//}
// 多线程情况下线程不安全的单例
//class Singleton{
//    private String str;
//    public String getStr() {
//        return str;
//    }
//    private static  Singleton singleton = new Singleton();
//    private Singleton() {
//        str = "hello";
//    }
//    public static Singleton getInstance(){ // 假如有两个线程同时进入这里
//        if(singleton == null){             // 判断singleton都不为空
//            singleton = new Singleton();   //  就会创建出两个对象
//        }
//        return singleton;
//    }
//}
//public class Test {
//    // volatile 保证可见性，不保证结果正确
//    public static volatile int num = 0;
//    public static void increase(){
//        num++;
//    }
//    public static void main(String[] args) {
//        Thread[] threads = new Thread[10];
//        for(int i = 0; i < 10; i++){
//            threads[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int j = 0; j < 100; j++){
//                        increase();
//                    }
//                }
//            });
//            threads[i].start();
//        }
//        while(Thread.activeCount() > 2){
//            Thread.yield();
//        }
//        System.out.println(num);
//    }
//}

//import java.util.concurrent.atomic.AtomicInteger;
//
//// aotomic原子类保证结果正确
//public class Test{
//    private static AtomicInteger atomicInteger = new AtomicInteger(0);
//    public static void main(String[] args) {
//        Thread[] threads = new Thread[10];
//        for(int i = 0; i < 10; i++){
//            threads[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int i = 0; i < 100; i++){
//                        atomicInteger.incrementAndGet();
//                    }
//                }
//            });
//            threads[i].start();
//        }
//        // 确保for循环中的所有线程执行完毕
//        while(Thread.activeCount() > 2){
//            Thread.yield();
//        }
//        System.out.println(atomicInteger.get());
//    }
//}