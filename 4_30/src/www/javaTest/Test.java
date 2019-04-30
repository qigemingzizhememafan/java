package www.javaTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// wait和notify方法
//class MyThread implements Runnable{
////    private  Object object = new Object();
////    private boolean flag;
////    public MyThread(Object object, boolean flag) {
////        this.object = object;
////        this.flag = flag;
////    }
////    public void waitMtehod() {
////        synchronized (object){
////            System.out.println("wait方法开始。。"+Thread.currentThread().getName());
////            try {
////                object.wait();
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            System.out.println("wait方法结束。。。"+Thread.currentThread().getName());
////        }
////    }
////    public void notifyMethod(){
////        synchronized (object){
////            System.out.println("notify方法开始。。"+Thread.currentThread().getName());
////            object.notify();
////            System.out.println("notify方法结束。。"+Thread.currentThread().getName());
////        }
////    }
////    @Override
////    public void run(){
////        if(flag){
////            waitMtehod();
////        }else{
////            notifyMethod();
////        }
////    }
////}
////public class Test{
////    public static void main(String[] args) throws InterruptedException {
////        Object object = new Object();
////        MyThread myThread1 = new MyThread(object,true);
////        MyThread myThrea2 = new MyThread(object,false);
////        for(int i = 0; i<10; i++){  //启动10个线程，只会任意唤醒一个线程
////            Thread threadi = new Thread(myThread1,"等待线程"+i);
////            threadi.start();
////        }
////        Thread notifyThread = new Thread(myThrea2,"唤醒线程");
////        Thread.sleep(1000);
////        notifyThread.start();
////    }
////}
//class MyThread implements Runnable{
//    private Object obj = new Object();
//    @Override
//    public void run() {
//        synchronized (obj) {
//            System.out.println("wait()方法开始。。。");
//            try {
//                obj.wait(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("wait()方法结束。。。");
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        MyThread mt = new MyThread();
//        Thread thread = new Thread(mt);
//        thread.start();
//        Thread.sleep(2000);
//        thread.interrupt();
//    }
//}
//class MyThread implements Runnable{
//    //锁对象
//    private int ticket = 500;
//    private Lock lock = new ReentrantLock();
//    @Override
//    public void run(){
//        for(int i = 0; i<500; i++){
//            try{
//                lock.lock();
//                if(ticket > 0){
//                    System.out.println(Thread.currentThread().getName()+
//                            "还剩下"+this.ticket--+"张票");
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally {
//                //解锁放在finally块中，不管有没有异常，都会解锁
//                lock.unlock();
//            }
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        Thread threadA = new Thread(mt,"黄牛A");
//        Thread threadB = new Thread(mt,"黄牛B");
//        Thread threadC = new Thread(mt,"黄牛C");
//        threadA.start();
//        threadB.start();
//        threadC.start();
//    }
//}

// 锁粗化
//public class Test{
//    private static StringBuffer sb = new StringBuffer();
//    public static void main(String[] args) {
//        sb.append("a");  //为了避免三个append频繁的加锁解锁
//        sb.append("b");//锁粗化将这三个捆绑在一起，只在开始时加一次锁
//        sb.append("c");//看源码StringBuffer的append方法ctrl+单击)
//    }
//}

// 锁解除
//public class Test{
//    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer();//局部变量，线程安全，不需要加锁
//        sb.append("a");
//        sb.append("b");
//    }
//}

// 生产者消费者模型
//class Goods{
//    private String goodsName;
//    private int count;
//
//    // 生产产品方法
//    public synchronized void set(String goodsName){
//        this.goodsName = goodsName;
//        this.count++;
//        System.out.println(toString());
//    }
//
//    // 消费商品方法
//    public synchronized void get(){
//        this.count--;
//        System.out.println(toString());
//    }
//
//    @Override
//    public String toString() {
//        return "Goods{" +
//                "goodsName='" + goodsName + '\'' +
//                ", count=" + count +
//                '}';
//    }
//}
//
//// 消费者线程
//class Consumer implements Runnable{
//    private Goods goods;
//    public Consumer(Goods goods){
//        this.goods = goods;
//    }
//    @Override
//    public void run() {
//        goods.get();
//    }
//}
//
//// 生产者线程
//class Producer implements Runnable{
//    private Goods goods;
//    public Producer(Goods goods){
//        this.goods = goods;
//    }
//
//    @Override
//    public void run() {
//        goods.set("煎饼果子");
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        Goods goods = new Goods();
//        Thread producerThread = new Thread(new Producer(goods));
//        Thread consumeThread = new Thread(new Consumer(goods));
//        producerThread.start();
//        Thread.sleep(200);
//        consumeThread.start();
//    }
//}

