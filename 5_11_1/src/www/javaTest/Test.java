package www.javaTest;


/*
 *一个商品，一个生产者，一个消费者的生产者消费者模型
**/
//class Goods{
//    private String goodsName; //商品名
//    private int count;  //商品数量
//    // 生产商品方法
//    public  synchronized void set(String goodsName){
//        if(count > 0){
//            System.out.println("商品还有库存，先等等");
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.goodsName = goodsName;
//        this.count++;
//        System.out.println(Thread.currentThread().getName()+
//                            "生产了"+goodsName+toString());
//        notify();
//    }
//    // 消费商品方法
//    public synchronized void get(){
//        if(count == 0){
//            System.out.println("商品卖完了");
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.count--;
//        System.out.println(Thread.currentThread().getName()
//                            +"消费了"+toString());
//        notify();
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
//// 生产者线程
//class Producer implements Runnable{
//    private Goods goods;
//
//    public Producer(Goods goods) {
//        this.goods = goods;
//    }
//
//    @Override
//    public void run() {
//        goods.set("棒棒鸡");
//    }
//}
//// 消费者线程
//class Consumer implements Runnable{
//    private Goods goods;
//
//    public Consumer(Goods goods) {
//        this.goods = goods;
//    }
//
//    @Override
//    public void run() {
//        goods.get();
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Goods goods = new Goods();
//        Thread produceThread = new Thread(new Producer(goods));
//        Thread consumerThread = new Thread(new Consumer(goods));
//        produceThread.start();
//        consumerThread.start();
//    }
//}


/*
 *notify()
* */
//    private  Object object = new Object();
//    private boolean flag;
//    public MyThread(Object object, boolean flag) {
//        this.object = object;
//        this.flag = flag;
//    }
//    public void waitMtehod() {
//        synchronized (object){
//            System.out.println("wait方法开始。。"+Thread.currentThread().getName());
//            try {
//                object.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("wait方法结束。。。"+Thread.currentThread().getName());
//        }
//    }
//    public void notifyMethod(){
//        synchronized (object){
//            System.out.println("notify方法开始。。"+Thread.currentThread().getName());
//            object.notifyAll();
//            System.out.println("notify方法结束。。"+Thread.currentThread().getName());
//        }
//    }
//    @Override
//    public void run(){
//        if(flag){
//            waitMtehod();
//        }else{
//            notifyMethod();
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        Object object = new Object();
//        MyThread myThread1 = new MyThread(object,true);
//        MyThread myThrea2 = new MyThread(object,false);
//        for(int i = 0; i<10; i++){  //启动10个线程，只会任意唤醒一个线程
//            Thread threadi = new Thread(myThread1,"等待线程"+i);
//            threadi.start();
//        }
//        Thread notifyThread = new Thread(myThrea2,"唤醒线程");
//        Thread.sleep(1000);
//        notifyThread.start();
//    }
//}


/*
* wait(long time)
* */
//class MyThread implements Runnable{
//    private  Object object = new Object();
//    @Override
//    public void run(){
//        synchronized (object){
//            System.out.println("wait方法开始。。。");  //痴汉，一直等待
//            try {
//                object.wait(1000);
//                object.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("wait方法结束。。。");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        MyThread mt = new MyThread();
//        Thread thread = new Thread(mt);
//        thread.start();
////        Thread.sleep(2000);
////        thread.interrupt();
//    }
//}


/*
 *wait()
* */
//class MyThread implements Runnable{
//    private Object object = new Object();
//    private int ticket = 10;
//    @Override
//    public void run() {
//        synchronized (object){
//            System.out.println("wait方法开始...");
//            try {
//                object.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("wait方法结束...");
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"线程A");
//        thread.start();
//        Thread.sleep(2000);
//        thread.isInterrupted();
//    }
//}


//class MyThread implements Runnable{
//    private int ticket = 10;
//    @Override
//    public void run(){ //三个线程可以同时进入run()方法
//        for(int i = 0; i<10; i++){
//            this.sale(ticket);
//        }
//    }
//    public synchronized void sale(int ticket){
//        if(ticket > 0){
//            try {
//                //模拟网络延迟
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()
//                    + "还剩下" + this.ticket-- + "张票");
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        Thread th1 = new Thread(mt,"黄牛A");
//        Thread th2 = new Thread(mt,"黄牛B");
//        Thread th3 = new Thread(mt,"黄牛c");
//        th1.start();
//        th2.start();
//        th3.start();
//    }
//}