package www.bittech;

import java.io.*;
import java.util.Scanner;

//class PrintUtil{
//    private OutputStream out;
//    public PrintUtil(OutputStream out){
//        this.out = out;
//    }
//    //自己实现print方法
//    public void print(String str){
//        try {
//            //核心在于OutputStream提供的write
//            this.out.write(str.getBytes()); //传进来的String类型不能直接被字节数组接收
//        } catch (IOException e) {           //需要转成字节数组
//            e.printStackTrace();
//        }
//    }
//    //实现println方法
//    public void println(String str){
//        this.print(str+"\r\n"); //换行符
//    }
//    //接收int类型数据并输出
//    public void print(int num){
//        this.print(String.valueOf(num));
//    }
//    public void println(int num){
//        this.print(num+"\r\n");
//    }
//    //接收double类型并输出
//    public void print(double data){
//        this.print(String.valueOf(data));
//    }
//    public void println(double data){
//        this.print(data+"\r\n");
//    }
//    public void close(){
//        try {
//            this.out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
class Person implements Serializable{
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    private String name;
    private transient int age;  //年龄不能被反序列化输出了，要先序列化保存更新一次一次
    public Person(String name, int age) {  //才能反序列化，看到结果。此处省略保存过程
        this.name = name;
        this.age = age;
    }
}
public class Test325 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file =  new File("C:\\Users\\Administrator\\Desktop\\Test.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object result = ois.readObject();
        System.out.println(result); //因为覆写了toString，会直接输出张三，18
        ois.close();
    }
}
//        //取得终端对象，此处对文件操作
//        File file = new File("C:\\Users\\Administrator\\Desktop\\Test.txt");
//        // 2.取得相应输出流
//        Person per = new Person("张三",18);
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//        // 3.进行数据输出
//        oos.writeObject(per);
//        //关闭流
//        oos.close();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入出生日期");
//        // 2000-01-01
//        if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){ //正则表达式
//            System.out.println(scanner.hasNext());  // d代表整数，4为长度是4
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入年龄");
//        //判断是否有整型输入
//        if(scanner.hasNextInt()){
//            System.out.println("年龄为"+scanner.nextInt());
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入内容...");
//        //判断是否有输入内容
//        if(scanner.hasNext()){
//            System.out.println(scanner.next());
//        }
//        InputStream in = System.in;
//        byte[] data = new byte[1024]; //开辟1Kb的缓冲区
//        System.out.println("请输入内容");
//        int temp = in.read(data);
//        System.out.println("输入内容为："+new String(data,0,temp));//将字节数组部分(因为写不满1kb，
//        // 所以只需要部分还原就行)还原成字符串
//        }
//}
//        System.out.println("hello");
//        System.err.println("hello");
//        // 1.取得File对象
//        File file = new File("C:\\Users\\Administrator\\Desktop\\Test.txt");
//        // 2. 取得输出流
//        PrintUtil printUtil = new PrintUtil(new FileOutputStream(file));
//        // 3. 进行数据输出
//        printUtil.print(10.0000); //输出在桌面Test文件中
//        printUtil.print(10);
//        printUtil.print("hello");
//        // 4. 关闭流