package www.bittech;//package www.bittech;
//class Node{
//    private Object val;
//    private Node next;
//
//    public Object getVal() {
//        return val;
//    }
//
//    public void setVal(Object val) {
//        this.val = val;
//    }
//
//    public Node getNext() {
//        return next;
//    }
//
//    public void setNext(Node next) {
//        this.next = next;
//    }
//
//    public Node(Object val) {
//        this.val = val;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Node node = new Node("1");
//        Node node1 = new Node("2");
//        Node node2 = new Node("3");
//        node.setNext(node1);
//        node1.setNext(node2);
//        printLink(node);
//         printLink(node);
//         printLink( reverse(node));
//    }
//    public static void printLink(Node head){
//        if(head != null){
//            System.out.println(head.getVal());
//            head = head.getNext();
//            printLink(head);
//        }
//    }
//    删除指定内容的结点
//public static Node removeElements(Node head, int val) {
//    if(head == null){
//        return null;
//    }
//    Node cur = head;
//    while(cur.getNext() != null){
//        if(!(cur.getNext().getVal().equals(val))){
//            cur = cur.getNext();
//        }else{
//            cur.setNext(cur.getNext().getNext());
//        }
//    }
//    if(head.getVal().equals(val)){
//        return head.getNext();
//    }else{
//        return head;
//    }
//}
//
//
//    逆置单链表
//    public static Node reverse(Node head){
//        Node cur = head;
//        Node pre = null;
//        while(cur != null){
//            Node next = cur.getNext();
//            cur.setNext(pre);
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }
//}

// 内部类
//class Outter{
//    private String msg = "hello";
//    class Inner{
//        public void print(){
//            System.out.println(msg);
//        }
//    }
//    public void fun(){
//        Inner in = new Inner();
//        in.print();
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Outter out = new Outter();
//        out.fun();
//    }
//}

// 实现Runnable接口启动多线程
//class MyThread implements Runnable{
//    private String title;
//    public MyThread(String title) {
//        this.title = title;
//    }
//    @Override
//    public void run() {
//        for(int i = 0; i<10; i++){
//            System.out.println(this.title+"、"+i);
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread("线程一");
//        MyThread myThread1 = new MyThread("线程二");
//        MyThread myThread2 = new MyThread("线程三");
//        new Thread(myThread).start();	//要把Runnable传给Thread
//        new Thread(myThread1).start();	//调用Thread的构造方法，看Thread源码
//        new Thread(myThread2).start();	//有参构造
//    }
//}

// 匿名内部类实现Runnable
//public class Test{
//    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            // 匿名内部类
//            @Override
//            public void run() {
//                System.out.println("hello world");
//            }
//        };
//        new Thread(runnable).start();
//    }
//}

// Runnable共享性
//class MyThread implements Runnable{
//    private String title;
//    private Integer ticket = 10;
//    public MyThread(String title) {
//        this.title = title;
//    }
//    @Override
//    public void run() {
//        for(int i = 0; i < 10; i++){
//            System.out.println(this.title+"还剩下"+this.ticket--+"张票");
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

//class MyThread implements Callable<String>{
//    private Integer ticket = 10;
//    @Override
//    public String call() throws Exception {
//        for(int i = 0; i < 10; i++){
//            System.out.println("还剩下"+this.ticket--+"张票");
//        }
//        return  "票卖完了";
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        FutureTask<String> futureTask = new FutureTask<>(myThread);
//        Thread thread = new Thread(futureTask);
//        Thread thread1 = new Thread(futureTask);
//        Thread thread2 = new Thread(futureTask);
//        thread.start();
//        thread1.start();
//        thread2.start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//}

//线程命名
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName()); //输出为main
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Thread thread = new Thread(new MyThread());
//        thread.run(); // 相当于调用普通方法
//    }
//}
//        System.out.println(thread.getName());
//        thread.start();
//        thread.setName("hello");
//        System.out.println(thread.getName());
//        thread.setName("world");
//        System.out.println(thread.getName());

// sleep()使用
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100 ; i++){
//                Thread.yield();
//            System.out.println(i);
//        }
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Thread thread = new Thread(new MyThread());
//        thread.start();
//    }
//}

//证明yield()立马交出CPU
//class MyThread implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            System.out.println(Thread.currentThread().getName() + "、" + i);
//            Thread.yield();
//        }
//    }
//}
//    public class Test {
//        public static void main(String[] args) {
//            MyThread mt = new MyThread();
//            Thread thread = new Thread(mt, "A");
//            Thread thread1 = new Thread(mt, "B");
//            Thread thread2 = new Thread(mt, "C");
//            thread.start();
//            thread1.start();
//            thread2.start();
//        }
//    }

// join()方法
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