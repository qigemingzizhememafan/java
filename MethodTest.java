package com.lzl;
class Task implements Runnable{
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("A")){
            testA();
        }else{
            testB();
        }
    }
    // synchronized作用于普通成员方法，锁的是当前对象
    private synchronized void testA(){
        System.out.println("A");
        //testB();
        while(true){}
    }
    private synchronized void testB(){
        System.out.println("B");
    }
}
public class MethodTest{
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(task,"A");
        Thread thread2 = new Thread(task,"B");
        thread1.start();
        thread2.start();
    }
}
//public class MethodTest {
//    private int age;
//    public static void main(String[] args) {
//        System.out.println(test().age);
//    }
//    public static MethodTest test(){
//        MethodTest test = new MethodTest();
//        try{
//            test.age = 1;
//            return test;
//        }catch(Exception e){
//            test.age = 2;
//            return test;
//        }finally {
//            test.age = 3;
//        }
//    }
//    public static int test(){
//        int i = 0;
//        try{
//            i = 1;
//            return i;
//        }catch(Exception e){
//            i = 2;
//            return i;
//        }finally{
//            i = 3;
//        }
//    }

//    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = "ab";
//        String str3 = "c";
//        String str4 = str2 + str3;
//        String str5 = str2 + str3;
//        String str6 = new String("abc");
//        String str7 = str2 + "C";
//        String str8 = "ab" + "c";
//        System.out.println(str1 == str6);   // false
//        System.out.println(str1 == str4);   // false
//        System.out.println(str4 == str5);   // false
//        System.out.println(str1 == str7);   // true
//        System.out.println(str1 == str8);   // false
//    }

//    public static void main(String[] args) {
//        String str1 = new String("abc");
//        String str2 = new String("abc");
//        String str3 = new String("abc");
//    }

//    public static void main(String[] args) {
//        String str = "6";
//        test(str);
//        System.out.println(str);
//    }
//    public static void test(String str){
//        str += "10";
//    }

