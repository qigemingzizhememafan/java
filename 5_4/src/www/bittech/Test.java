package www.bittech;
/*
* 单线程版本的生产者消费者
* 一个生产者一个消费者
* */

//import java.util.ArrayList;
//import java.util.List;
//
//// 商品类
//class Goods{
//    private String goodsName;
//    private int count;
//    // 生产商品方法
//    public synchronized void set(String goodsName){  //用同步方法是因为
//        while(count > 0){                  // 生产和消费都在对同一个数量做修改.且任意时刻只能有一个
//            System.out.println("商品还有库存，休息一会");//生产者或消费者对count做修改
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        this.goodsName = goodsName;
//        this.count++;
//        System.out.println(Thread.currentThread().getName()+toString());
//        notify(); // 唤醒消费者消费
//    }
//    // 消费商品方法
//    public synchronized void get(){
//        while(count == 0){
//            System.out.println("商品卖完了，等等再来吧~");
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        count--;
//        System.out.println(toString());
//        notify();  // 唤醒生产者生产
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
//
//// 消费者线程
//class Consumer implements Runnable{
//    private Goods goods;
//    public Consumer(Goods goods) {
//        this.goods = goods;
//    }
//    @Override
//    public void run() {
//        while (true) {
//            goods.get();
//        }
//    }
//}
//// 生产者线程
//class Producer implements  Runnable{
//    private Goods goods;
//    public Producer(Goods goods) {
//        this.goods = goods;
//    }
//    @Override
//    public void run() {
//        while (true){
//        goods.set("芒果椰奶");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        Goods goods = new Goods();
//        List<Thread> list = new ArrayList();
//        for(int i = 0;i < 10;i++){
//            Thread thread = new Thread(new Producer(goods),"消费者"+i);
//            list.add(thread);
//        }
//        for (int i = 0;i < 5;i++){
//            Thread thread = new Thread(new Consumer(goods),"生产者"+i);
//            list.add(thread);
//        }
//        for(Thread thread : list){
//            thread.start();
//        }
//    }
//}

/*
*  多个商品多个生产者多个消费者
* */
import java.util.ArrayList;
import java.util.List;
//商品类
class Goods{
    private String goodsName;
    private int count;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //生产商品方法
    public synchronized  void set(String goodsName){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.goodsName = goodsName;
        this.count++;
        System.out.println(Thread.currentThread().getName()+"生产"+goodsName+toString());
        notifyAll();
    }
    //消费商品方法
    public synchronized void get(){
        while(count==0){
            System.out.println("商品卖完了,客官请稍等");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count--;
        System.out.println(Thread.currentThread().getName()+"消费"+toString());
        notifyAll();
    }
    @Override
    public String toString() {
        return "Goods{"+"goodsname='"+goodsName+'\''+",count="+count+'}';
    }
}
//消费者线程
class Consumer implements  Runnable{
    private Goods goods;
    public Consumer(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run(){
        while(true){
            goods.get();
        }
    }
}
//生产者线程
class Producer implements Runnable{
    private Goods goods;
    public Producer(Goods goods){
        this.goods = goods;
    }
    @Override
    public void run(){
        while(this.goods.getCount() < 100){
            this.goods.set("纪梵希限量口红");
        }
    }
}
public class Test{
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        //存储多个生产、消费者线程
        List<Thread> list = new ArrayList<>();
        //10个消费者线程
        for(int i = 0; i<10; i++){
            Thread thread = new Thread(new Consumer(goods),"消费者"+i);
            list.add(thread);
        }
        //5个生产者线程
        for(int i = 0; i<5 ; i++){
            Thread thread = new Thread(new Producer(goods),"生产者"+i);
            list.add(thread);
        }
        for(Thread thread:list){
            thread.start();
        }
    }
}