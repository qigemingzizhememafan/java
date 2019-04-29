// 同步锁练习
package www.bittech;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Sync{  //普通类
    //线程1进入testA方法，线程一仍在执行
    public synchronized void testA(){
        if(Thread.currentThread().getName().equals("A")){ //判断线程名字是否为A
            while(true){}
        } //线程1一直在执行
    } //普通同步方法，所得是当前Sync对象
    //线程2能否进入testB()方法---不能，得等A释放了锁才能进入
    public synchronized void testB(){
        if(Thread.currentThread().getName().equals("B")){
            System.out.println("线程B打印此方法");
        }
    }
}
class MyThread implements Runnable{
    public MyThread(Sync sync) {
        this.sync = sync;
    }

    private Sync sync;
    @Override
    public void run(){
        this.sync.testA();
        this.sync.testB();

    }
}
public class Test{
    public static void main(String[] args) {
        Sync sync = new Sync();
        MyThread myThread = new MyThread(sync);
        Thread threadA = new Thread(myThread,"A");
        Thread threadB = new Thread(myThread,"B");
        threadA.start();
        try {
            Thread.sleep(100);//确保A先启动
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }
}
//class MyThread implements Runnable{
//    private boolean flag = true;
//    @Override
//    public void run(){
//        int i = 1;
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
//    public void setFlag(boolean flag){
//        this.flag = flag;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"子线程A");
//        thread.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.stop(); //强制停止
//    }
//}

//class MyThread implements Runnable{
//    private boolean flag = true;
//    @Override
//    public void run(){
//        int i = 1;
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
//    public void setFlag(boolean flag){
//        this.flag = flag;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"子线程A");
//        thread.start();
//        try {
//            Thread.sleep(5000);  //主线程休眠五秒
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        myThread.setFlag(false);
//    }
//}
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
//        System.out.println("主线程休眠结束");
//        Test.printTime();
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("主线程开始...");
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"子线程A");
//        thread.start();
//        thread.join();
//        System.out.println("主线程结束...");
//    }
//    public static void printTime(){
//        Date date = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = dateFormat.format(date);
//        System.out.println(str);
//    }
//}
