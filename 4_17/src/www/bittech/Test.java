package www.bittech;
// 继承MyThread启动多线程
//class MyThread extends Thread{
//    private String title;
//    public MyThread(String title){
//        this.title = title;
//    }
//
//    @Override
//    public void run() {
//        for(int i = 0; i<10; i++){
//            System.out.println(this.title+"线程"+i);
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread("线程一");
//        MyThread myThread1 = new MyThread("线程二");
//        MyThread myThread2 = new MyThread("线程三");
//        myThread.start();
//        myThread1.start();
//        myThread2.start();
//    }
//}

// 实现Runnable接口实现多线程
//class MyThread implements Runnable{
//    private String title;
//    public MyThread(String title){
//        this.title = title;
//    }
//
//    @Override
//    public void run() {
//        for(int i = 0; i<10; i++){
//            System.out.println(this.title+"线程"+i);
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread("线程一");
//        MyThread myThread1 = new MyThread("线程二");
//        MyThread myThread2 = new MyThread("线程三");
//        new Thread(myThread).start();//要把Runnable传给Thread
//        new Thread(myThread1).start();//调用Thread的构造方法，看Thread源码
//        new Thread(myThread2).start();//有参构造
//    }
//}

