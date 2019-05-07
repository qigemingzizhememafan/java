package www.javaTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

// Callable启动多线程
//class MyThread implements Callable<String>{
//    private int ticket = 10;
//    @Override
//    public String call() throws Exception {
//        while(this.ticket > 0){
//            System.out.println("还剩下"+ticket--+"张票");
//        }
//        return "票卖完了，客官明天见";
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//       FutureTask<String> futureTask = new FutureTask<>(myThread);
//       Thread thread = new Thread(futureTask);
//       thread.start();
//    }
//}
// Runnable体现共享
//class MyThread implements Runnable{
//    private String title;
//    private Integer ticket = 10;
//    public MyThread(String title) {
//        this.title = title;
//    }
//    @Override
//    public void run() {
//        while(ticket > 0){
//            System.out.println("还剩下"+ticket--+"张票");
//        }
//        for(int i = 0; i < 10; i++){
//            System.out.println(Thread.currentThread().getName()+
//                    this.title+"还剩下"+this.ticket--+"张票");
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread mt = new MyThread("票贩子");
//        Thread thread = new Thread(mt);
//        Thread thread1 = new Thread(mt);
//        Thread thread2 = new Thread(mt);
//        thread.start();
//        thread1.start();
//        thread2.start();
//    }
//}

// Thread共享不太好
//class MyThread extends Thread{
//    private String title;
//    public MyThread(String title){
//        this.title = title;
//    }
//    //共同卖10张票
//    private Integer ticket = 10;
//    @Override
//    public void run() {
//        for(int i = ticket;i >= 0;i--){
//            System.out.println(Thread.currentThread().getName()+"还剩下"+i+"张票");
//        }
//    }b
//}
//public class Test {
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread("卖票的");
////        MyThread myThread1 = new MyThread("卖票A");
////        MyThread myThread2 = new MyThread("卖票B");
//        Thread thread = new Thread(myThread);
//        Thread thread1 = new Thread(myThread);
//        Thread thread2 = new Thread(myThread);
//        thread.start();
//        thread1.start();
//        thread2.start();
//    }
//}

// yield()没有立马交出CPU:
//class MyThread implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            System.out.println(Thread.currentThread().getName() + "、" + i);
//            Thread.yield();
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        Thread thread = new Thread(mt, "A");
//        Thread thread1 = new Thread(mt, "B");
//        Thread thread2 = new Thread(mt, "C");
//        thread.start();
//        thread1.start();
//        thread2.start();
//    }
//}

// sleep立马交出CPU
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        for(int i = 0; i < 3; i++){
//            System.out.println(Thread.currentThread().getName()+"、"+i);
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        Thread thread = new Thread(mt,"A");
//        Thread thread1 = new Thread(mt,"B");
//        Thread thread2 = new Thread(mt,"C");
//        thread.start();
//        thread1.start();
//        thread2.start();
//    }
//}

public class Test{
//    在有序(从左到右依此递增，从上到下递增)二维数组中找一个数
//    public boolean Find(int target, int [][] array) {
//        int len = array.length-1;
//        int i = 0;
//        while((len >= 0)&& (i < array[0].length)){
//            if(array[len][i] > target){
//                len--;
//            }else if(array[len][i] < target){
//                i++;
//            }else{
//                return true;
//            }
//        }
//        return false;
//    }

// 找相交链表的相交点
//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        int alen = getLength(headA);
//        int blen = getLength(headB);
//        if (alen < blen) {
//            for (int i = 0; i < blen - alen; i++) {
//                headB = headB.next;
//            }
//        } else {
//            for (int i = 0; i < alen - blen; i++) {
//                headA = headA.next;
//            }
//        }
//        while (headA != headB) {
//            headA = headA.next;
//            headB = headB.next;
//        }
//        return headB;
//    }
//
//    public static int getLength(ListNode tmp) {
//        int cnt = 0;
//        while (tmp != null) {
//            cnt++;
//            tmp = tmp.next;
//        }
//        return cnt;
//    }
//}
//}
