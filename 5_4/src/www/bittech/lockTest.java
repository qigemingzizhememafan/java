package www.bittech;

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//class MyThread1 implements Runnable{
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
//public class lockTest{
//    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        Thread thread1 = new Thread(myThread1,"黄牛A");
//        Thread thread2 = new Thread(myThread1,"黄牛B");
//        Thread thread3 = new Thread(myThread1,"黄牛C");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//    }
//}

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//自定义锁
class Mutex implements Lock {
    private Sync sync = new Sync();
    //自定义同步器
    static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if(arg != 1){
                throw new RuntimeException("arg参数不为1");
            }
            // 尝试将线程状态从0更新到1
            if(compareAndSetState(0,1)){
                //此时线程成功获取同步状态，将持有线程设置成自己
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            //无锁状态，不能释放
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            // 释放锁成功，将当前持有线程置为空
            setExclusiveOwnerThread(null);
            // 把线程状态还原成0
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }
    //-----------------------------------
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
    //------------------------------------------------------------
}
public class lockTest {
    public static void main(String[] args) {
        Lock lock = new Mutex();
        for(int i = 0;i < 10;i++){
            Thread thread = new Thread(()->{
                try {
                    lock.lock();
                    Thread.sleep(20000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}