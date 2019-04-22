package www.bittech;
//class MyThread implements Runnable {
//    // interrupt中断线程
//    @Override
//    public void run() {
//        int i = 0;
//        while(true){
//            boolean bool = Thread.currentThread().isInterrupted();
//            System.out.println(Thread.currentThread().getName()+"第"+i+"次执行...");
//            if(bool){
//                System.out.println("线程退出...");
//                break;
//            }
//            System.out.println(bool);
//            i++;
//        }
//
//    }
//}

    // 设置标记位停止多线程
//    private boolean flag = true;
//    @Override
//    public void run() {
//        int i = 1;
//        while(flag){
//            System.out.println(Thread.currentThread().getName()+"第"+i+"次执行...");
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
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"子线程A");
//        thread.start();
//        Thread.sleep(3000);
//        thread.interrupt();
//        thread.stop();
//        myThread.setFlag(false);
//    }
//
//}

//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        int i = 1;
//        while (true){
//         try{
//             boolean bool = Thread.currentThread().isInterrupted();
//             System.out.println(Thread.currentThread().getName()+"第"+i+"次执行。。。");
//             System.out.println(bool);
//             if(bool){
//                 System.out.println("线程退出...");
//                 break;
//             }
//             i++;
//             Thread.sleep(1000);
//         }catch (InterruptedException e){
//             System.out.println("异常抛出，县城停止");
//             boolean bool = Thread.currentThread().isInterrupted();
//             System.out.println("catch块中断状态为"+bool);
//         }
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"子线程A");
//        thread.start();
//    }
//}

//class MyThread implements Runnable{
//    @Override
//    public void run(){
//        for(int i = 0; i<5; i++){
//            System.out.println(Thread.currentThread().getName()+"、"+i);
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread("子线程A");
//        Thread thread1 = new Thread("子线程B");
//        Thread thread2 = new Thread("子线程C");
//        thread2.setPriority(Thread.MAX_PRIORITY);  //设置线程优先级
//        thread1.setPriority(Thread.NORM_PRIORITY);
//        thread.setPriority(Thread.MIN_PRIORITY);
//        thread.start();
//        thread1.start();
//        thread2.start();
//    }
//}

//class MyThread implements Runnable{
//    @Override
//    public void run(){
//        //获取子线程优先级
//        System.out.println(Thread.currentThread().getName()+"、"+Thread.currentThread().getPriority());
//    }
//}
//public class Test{
//    public static void main(String[] args) { //主线程中启动了子线程，优先级和子线程应该相同
//        System.out.println(Thread.currentThread().getName()+"、"+Thread.currentThread().getPriority());
//        new Thread(new MyThread(),"子线程A").start();
//    }
//}

//class MyThread implements Runnable{
//    @Override
//    public void run(){
//
//        System.out.println(Thread.currentThread().getName()+"、"+Thread.currentThread().getPriority());
//        //在MyThread中启动子线程B，B与其线程优先级应该相同
//        new Thread(new B(),"孙子线程B").start();
//    }
//}
//class B implements Runnable{
//    @Override
//    public void run(){
//        System.out.println(Thread.currentThread().getName()+"、"+Thread.currentThread().getPriority());
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName()+"、"+Thread.currentThread().getPriority());
//        Thread thread = new Thread(new MyThread(),"子线程A");
//        thread.setPriority(Thread.MAX_PRIORITY); //在主线程中启动子线程A，并设置其优先级为最大
//        thread.start();
//    }
//}

//class MyThread implements Runnable{
//    @Override
//    public void run(){
//        while(true){
//            System.out.println(Thread.currentThread().getName()+"当前线程是否为守护线程"+Thread.currentThread().isDaemon());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("线程退出");
//                return;
//            }
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) throws InterruptedException{
//        MyThread myThread = new MyThread();
//        Thread thread1 = new Thread(myThread,"子线程A");
//        //将子线程A设置成为守护线程
//        thread1.setDaemon(true);
//        //B是用户线程
//        Thread thread2 = new Thread(myThread,"子线程B");
//        thread1.start();
//        thread2.start();
//        //等待三秒后中断用户线程
//        Thread.sleep(3000);
//        thread2.interrupt();
//    }
//}

//class MyThread implements Runnable{
//    private int ticket = 10;
//    @Override
//    public void run(){
//        while(this.ticket > 0){
//            try{
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"还剩下"+this.ticket--+"票");
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
//
//    }
//}

//class MyThread implements Runnable{
//    private int ticket = 100;
//    @Override
//    public void run(){
//        for(int i = 0; i<100; i++){
//            if(ticket>0) {
//                try {
//                    //模拟网络延迟
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()+"还剩下"+this.ticket--+"张票");
//            }
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

//class MyThread implements Runnable{
//    private int ticket = 100;
//    @Override
//    public void run(){ //三个线程可以同时进入run()方法
//        for(int i = 0; i<100; i++){
//            //同步代码块
//            synchronized (this) {  //加锁操作，同一时刻只有一个线程进入同步代码块
//                //--------------------------------------------------------------------
//                if (ticket > 0) {
//                    try {
//                        //模拟网络延迟
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "张票");
//                }
//                //--------------------------------------------------------------------
//            }
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

//class MyThread implements Runnable{
//    private int ticket = 100;
//    @Override
//    public void run(){ //三个线程可以同时进入run()方法
//        for(int i = 0; i<100; i++){
//            this.sale(ticket);
//        }
//    }
//    //同步方法--同一时刻只有一个线程能进入该方法
//    public synchronized void sale(int ticket){
//        if(ticket > 0){
//            try {
//                //模拟网络延迟
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "张票");
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