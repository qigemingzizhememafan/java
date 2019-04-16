package www.bittech;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//class MyThread implements Runnable{
//    private int ticket = 500;
//    private Lock lock = new ReentrantLock();
//    @Override
//    public void run() {
//        for(int i = 0; i<500; i++){
//            try{
//                lock.lock();
//                if(ticket>0){
//                    Thread.sleep(20);
//                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally{
//                lock.unlock();
//            }
//        }
//    }
//}
//public class Test14{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread1 = new Thread("黄牛A");
//        Thread thread2 = new Thread("黄牛B");
//        Thread thread3 = new Thread("黄牛C");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//    }
//}
