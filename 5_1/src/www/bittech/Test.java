package www.bittech;

//public class Test {
//    public static StringBuffer sb = new StringBuffer();
//    public static StringBuilder sb = new StringBuilder();
//        public static void main(String[] args) {
//            //1加锁，1次释放锁
//            //锁的消除
//            StringBuilder sb = new StringBuilder();
//            sb.append("a");
//            sb.append("b");
//            sb.append("c");
//        }
//    }

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//public class Test{
//    public static void main(String[] args) {
//        final Lock lock  = new ReentrantLock();
//        Runnable runnable = new MyLockRunnable(lock);
//        new Thread(runnable, "黄牛A").start();
//        new Thread(runnable, "黄牛B").start();
//        new Thread(runnable, "黄牛C").start();
//        //A B C lock
//        //lock 通过构造方法传入
//        lock.lock();
//        try {
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//            System.out.println("main结束");
//        }
//    }
//}
//class MyLockRunnable implements Runnable {
//    private final Lock lock ;//= new ReentrantLock();
//    private int tick = 10;
//    MyLockRunnable(Lock lock) {
//        this.lock = lock;
//    }
//    @Override
//    public void run() {
//        while (this.tick > 0) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //tick 访问并且修改
//            lock.lock();
//            try {
//                //要进行同步的代码
//                if (this.tick > 0) {
//                    System.out.println(Thread.currentThread().getName() + " 卖票， 剩余 ：" + (--this.tick));
//                }
//            } finally {
//                lock.unlock();
//            }
//
//        }
//    }
//}

//public class Test {
//    public static void main(String[] args) {
//        Pen pen = new Pen();
//        Book book = new Book();
//        //线程A
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized(pen) {
//                    System.out.println(Thread.currentThread().getName() + " 我有笔，没有本");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    synchronized(book) {
//                        System.out.println(Thread.currentThread().getName() + " 我有笔，有本");
//                    }
//                }
//            }
//        }, "Thread-A").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized(book) {
//                    System.out.println(Thread.currentThread().getName() + " 我有本，没有笔");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    synchronized(pen) {
//                        System.out.println(Thread.currentThread().getName() + " 我有本，有笔");
//                    }
//                }
//            }
//        }, "Thread-B").start();
//    }
//}
//class Pen {
//
//}
//class Book {
//
//}

/*
public class Test {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyDaemonRunnable(), "Thread-A");
        //创建线程默认就是用户线程
        //设置线程为守护线程需要调用setDaemon(true),必须在start之前调用
//        threadA.setDaemon(true);
        threadA.start();

        Thread threadB = new Thread(new MyDaemonRunnable(), "Thread-B");
        threadB.start();

        //主线程休眠
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.interrupt();//中断
        //threadB结束
        System.out.println("主线程结束");
    }
}
class MyDaemonRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "发生中断");
                break;
            }
            System.out.println("线程名-" + Thread.currentThread().getName() + " 是否是守护线程：" +
                    Thread.currentThread().isDaemon());
        }
    }
}

*/

public class Test {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new MySyncThread(lock);
//            //Thread-Sync-0 .. Thread-Sync-9
//            //Sync   ...    Sync
//            //Sync.class -> 同一个ClassLoader Sync.class
//            thread.setName("Thread-Sync-" + i);
//            thread.start();
//        }

//        Sync sync = new Sync();
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new MySyncThread2(sync);
//            thread.setName("Thread-Sync-" + i);
//            thread.start();
//        }

        final Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            Thread thread = new MySyncThread(lock);
            //Thread-Sync-0 .. Thread-Sync-9
            //Sync(lock)   ...    Sync(lock)
            //lock 同一个对象
            //Sync test lock(同步)
            thread.setName("Thread-Sync-" + i);
            thread.start();
        }

    }
}

//线程安全的类
class Sync {

    //同步Sync对象的test方法
    //多线程同一时间访问同一个Sync对象的test方法时
    //会进行同步操作，只能同一时间有一个线程访问Sync对象的test方法
    /*
    public synchronized void test() {
        System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
    }
    */

    /*
    public void test() {
        synchronized(this) {
            System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
        }
    }
     */

    //多线程同一时间访问Sync的test方法，方法中对Sync.class对象同步（加锁）-> 全局锁
//    public void test() {
//        synchronized(Sync.class) {//对Sync类的对象进行同步
//            System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
//        }
//    }

    private final Object lock;

    Sync(Object lock) {
        this.lock = lock;
    }

    public void test() {
        synchronized(lock) {//对Sync类的对象进行同步
            System.out.println("test 执行开始 ， 当前线程：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test 执行结束 ， 当前线程：" + Thread.currentThread().getName());
        }
    }
}

class MySyncThread extends Thread {
    private final Object lock;

    MySyncThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Sync sync = new Sync(lock);
        sync.test();
    }
}

class MySyncThread2 extends Thread {
    private final Sync sync;

    MySyncThread2(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        sync.test();
    }
}