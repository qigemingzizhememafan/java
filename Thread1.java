package synchronized_1_7_26;

//public class Thread1{
//    public static void main(String[] args) {
//        test1();
//    }
//    public static synchronized void test1(){   //两个同步方法，且都是静态的
//        System.out.println("hello world");  //锁的是Thread1.class这一个对象
//    }                                   //主线程先进入test（）拿到该对象的锁了，计数器+1
//    public static synchronized void test2(){  //当前锁对象的持有线程是主线程，也就是当前线程，计数
//// 器再次+1，可进入test1（）。即可重入。也就是我已经取得
//        // 了当前对象的锁，则对象里的方法我都可以进入
//        System.out.println("hello world");
//    }
//}
//class Sync{  //普通类
//    //线程1进入testA方法，线程一仍在执行
//    public synchronized void testA(){
//        if(Thread.currentThread().getName().equals("A")){ //判断线程名字是否为A
//            while(true){}
//        } //线程1一直在执行
//    }
//    public synchronized void testB(){
//        if(Thread.currentThread().getName().equals("B")){
//        System.out.println("线程B打印此方法");
//        }
//        }
//        }
//class MyThread implements Runnable{
//    public MyThread(Sync sync) {
//        this.sync = sync;
//    }
//    private Sync sync;
//    @Override
//    public void run(){
//        this.sync.testA();
//        this.sync.testB();
//    }
//}
//public class Thread1{
//    public static void main(String[] args) {
//       // Sync sync = new Sync();
//        MyThread myThread = new MyThread(sync);
//        Thread threadA = new Thread(myThread,"A");
//        Thread threadB = new Thread(myThread,"B");
//        threadA.start();
//        try {
//            Thread.sleep(100);//确保A先启动
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadB.start();
//    } //若取消A的锁，即使A在死循环，B也能进入testB方法
//    //线程A在运行，线程B在等待
//class Sync{
//    public void test() {
//        synchronized (Sync.class) {  //在同步代码块中锁当前的Class对象
//            System.out.println(Thread.currentThread().getName() + "方法开始");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "方法结束");
//        }
//    }
//}
//class MyThread implements Runnable{
//    @Override
//    public void run(){
//        Sync sync = new Sync();
//        sync.test();
//    }
//}
//public class Thread1{
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        for(int i = 0; i<3; i++){
//            new Thread(mt,"线程"+i).start();
//        }
//    }
//}
//class Sync{
//    //此时锁的是下方代码段...
//    public static synchronized void test(){ //static与synchronized连用，相当于锁住了该类，无论有多
//        //少对象都会被锁住
//        System.out.println(Thread.currentThread().getName()+"方法开始");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"方法结束");
//    }
//}
//class MyThread implements Runnable{
//    @Override
//    public void run(){
//        Sync sync = new Sync();
//        sync.test();
//    }
//}
//public class Thread1{
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        for(int i = 0; i<3; i++){
//            new Thread(mt,"线程"+i).start();
//        }
//    }
//}
//class Sync{
//    public synchronized void test(){
//        System.out.println(Thread.currentThread().getName()+"方法开始");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"方法结束");
//    }
//}
//class MyThread implements Runnable{
//    private Sync sync;  // 只有一个对象
//    public MyThread(Sync sync){
//        this.sync = sync;
//    }
//    @Override
//    public void run(){
//        this.sync.test();
//    }
//}
//public class Thread1{
//    public static void main(String[] args) {
//        Sync sync = new Sync();
//        MyThread mt = new MyThread(sync);  //三个sync同一个Runnable对象
//        for(int i = 0; i<3; i++){
//            new Thread(mt,"线程"+i).start();
//        }
//    }
//}
//class Sync{
//    //锁的是当前对象this
//    public synchronized void test(){
//        System.out.println(Thread.currentThread().getName()+"方法开始");
//    }
//
//}
//
//class MyThread implements Runnable{
//    @Override
//    public void run(){
//        Sync sync = new Sync();
//        //启动了三个线程，new了三个sync
//        //线程0启动，把sync0锁了
//        //线程1启动，把sync1锁了
//        //线程2启动，把sync2锁了
//        //三个各锁各的，互不影响，相当于三个房间，进入三个人，每个人都可以进去后将房间锁了
//        sync.test();
//    }
//}
//public class Thread1{
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        for(int i = 0; i<3; i++){ //此时输出三个线程同时开始同时结束，并没有被锁住
//            new Thread(mt,"线程"+i).start();
//        }
//    }
//}
//class MyThread implements Runnable{
//    private int ticket = 100;
//    @Override
//    public void run(){ //三个线程可以同时进入run()方法
//        for(int i = 0; i<100; i++){
//            this.sale(ticket);
//        }
//    }
//public synchronized void sale(int ticket){
//        if(ticket > 0){
//        try {
//        //模拟网络延迟
//        Thread.sleep(200);
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "张票");
//        }
//        }
//        }
//public class Thread1{
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
class MyThread implements Runnable{
    private int ticket = 100;
    @Override
    public void run(){ //三个线程可以同时进入run()方法和for循环
        for(int i = 0; i<100; i++){
            //同步代码块
            synchronized (this) {  //加锁操作，同一时刻只有一个线程进入同步代码块，
                //分割线内代码块执行完隐式解锁
                //--------------------------------------------------------------------
                if (ticket > 0) {
                    try {
                        //模拟网络延迟
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "张票");
                }
                //--------------------------------------------------------------------
            }
        }
    }
}
public class Thread1{
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread th1 = new Thread(mt,"黄牛A");
        Thread th2 = new Thread(mt,"黄牛B");
        Thread th3 = new Thread(mt,"黄牛c");
        th1.start();
        th2.start();
        th3.start();
    }
}