package www.javaTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



//class MyThread implements Runnable{
//    private int ticket = 100;
//    Lock lock = new ReentrantLock();
//    @Override
//    public void run() {
//        for(int i = 0;i < 100;i++){
//            try{
//                lock.lock();
//            if(ticket > 0){
//                System.out.println(Thread.currentThread().getName()+
//                                    "还剩下"+ticket--+"张票");
//            }
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"线程一");
//        Thread thread1 = new Thread(myThread,"线程二");
//        thread.start();
//        thread1.start();
//    }
//}
