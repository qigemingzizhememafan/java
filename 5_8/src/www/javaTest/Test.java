package www.javaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



//interrupt()中断线程
//class MyThread implements Runnable{
//    private boolean flag = true;
//    int i = 1;
//    @Override
//    public void run() {
//        while (true) {
//            boolean bool = Thread.currentThread().isInterrupted();
//            System.out.println(Thread.currentThread().getName()+"第"+i+"次执行");
//            if (bool) {
//                System.out.println("线程退出...");
//                break;
//            }
//            System.out.println(bool);
//            i++;
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"子线程A");
//        thread.start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
//    }
//}

// stop()强制停止
//class MyThread implements Runnable{
//    private int i = 1;
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + "第" + i + "次执行");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();
//        Thread.sleep(6000);
////        thread.stop();
//    }
//}

// 设置标记位停止线程
//class MyThread implements Runnable{
//    private boolean flag = true;
//    int i = 1;
//
//    @Override
//    public void run() {
//        while(flag){
//            System.out.println(Thread.currentThread().getName()+"第"+i+"次执行");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            i++;
//        }
//    }
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"子线程A");
//        thread.start();
//        Thread.sleep(5000);
//        myThread.setFlag(false);
//    }
//}

// join()练习
//class MyThread extends Thread{
//    public MyThread(String title) {
//        this.title = title;
//    }
//    private String title;
//    private int ticket = 10;
//    @Override
//    public void run() {
//        while(ticket > 0){
//            System.out.println(this.title+"还剩下"+ticket--+"张票");
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        MyThread thread = new MyThread("黄牛A");
//        MyThread thread1 = new MyThread("黄牛B");
//        MyThread thread2 = new MyThread("黄牛C");
//        thread2.start();
//        thread2.join(); // thread2执行完后才能让另外两个执行
//        thread.start();
//        thread1.start();
//
//    }
//}

// join() 等待调用该方法的线程终止后再执行别的线程
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        System.out.println("主线程休眠开始...");
//        Test.printTime();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("主线程休眠结束...");
//        Test.printTime();
//    }
//}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("主线程开始");
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"线程一");
//        thread.start();
//        thread.join();
//        System.out.println("主线程结束");
//    }
//    public static void printTime(){
//        Date date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
//        String str = dateFormat.format(date);
//        System.out.println(str);
//    }
//}

