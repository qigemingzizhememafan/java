package www.javaTest;

// 写两个线程，一个线程打印1~52，另一个线程打印A~Z，打印顺序是12A34B...5152Z
//class Print{
//    private int flag = 1;
//    private int count = 1;
//    public synchronized void printNum(){
//        while(flag != 1){
//            //此时应该打印字母
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(2*count-1);
//        System.out.println(2*count);
//        flag = 2;
//        notify();
//    }
//    public synchronized void printChar(){
//        while(flag != 2){
//            //此时应该打印数字
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println((char)(count-1+'A'));
//        // 继续前行
//        count++;
//        flag = 1;
//        notify();
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Print print = new Print();
//        new Thread(()->{for(int i = 0; i < 26; i++){
//            print.printNum();
//        }
//        }).start();
//        new Thread(() ->{
//            for(int i = 0; i<26; i++){
//                print.printChar();
//            }
//        }).start();
//    }
//}


// 启动三个线程，三个线程的名称分别是A，B，C；
// 每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABCABCABCABC
class Print{
    private int flag = 1;
    private  int count = 0;
    public int getCount() {
        return count;
    }
    public synchronized  void printA(){
        while(flag != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 2;
        count++;
        notifyAll();
    }
    public synchronized  void printB(){
        while(flag != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 3;
        count++;
        notifyAll();
    }
    public synchronized  void printC(){
        while(flag != 3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 1;
        count++;
        notifyAll();
    }
}
class MyThread implements Runnable{
    private Print print;
    public MyThread(Print print){
        this.print = print;
    }
    @Override
    public void run(){
        while(print.getCount() < 16) {
            if (Thread.currentThread().getName().equals("A")) {
                print.printA();
            } else if (Thread.currentThread().getName().equals("B")) {
                print.printB();
            } else if (Thread.currentThread().getName().equals("C")) {
                print.printC();
            }
        }
    }
}
public class Test{
    public static void main(String[] args) {
        Print print = new Print();
        MyThread myThread = new MyThread(print);
        Thread thread1 = new Thread(myThread,"A");
        Thread thread2 = new Thread(myThread,"B");
        Thread thread3 = new Thread(myThread,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}