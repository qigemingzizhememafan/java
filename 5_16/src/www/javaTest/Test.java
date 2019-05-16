package www.javaTest;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
//public class Test {
//    public static void main(String[] args) throws FileNotFoundException {
//        // 1.取得File对象
//        File file = new File("C:\\Users\\Administrator\\Desktop\\Test.txt");
//        // 2. 取得输出流
//        //只将PrintUtil换成系统的打印方法printStream，别的都不变，也可实现同样功能
//        PrintUtil printUtil = new PrintUtil(new FileOutputStream(file));
//        // 3. 进行数据输出
//        printUtil.print(10.0000); //输出在桌面Test文件中
//        printUtil.print(10);
//        printUtil.print("hello");
//        // 4. 关闭流
//    }
//}


//public class Test {
//    public static void main(String[] args) throws IOException {
//        String sourceFilePath = "C:\\Users\\Administrator\\Desktop\\托尼.jpg"; //源文件
//        String destFilePath = "C:\\Users\\Administrator\\Desktop\\托尼1.jpg";  //目标文件
//        copyFile(sourceFilePath,destFilePath);
//    }
//    public static boolean copyFile(String sourceFilePath,String destFilePath) throws IOException {
//        // 1. 取得File对象地址
//        File sourceFile = new File(sourceFilePath);
//        File destFile = new File(destFilePath);
//        // 2. 取得输入输出流
//        InputStream in = new FileInputStream(sourceFile);//对程序来说读入源文件
//        OutputStream out = new FileOutputStream(destFilePath);//输出目标文件
//        // 3. 数据的输入输出
//        long start = System.currentTimeMillis();
//        int len = 0;
//        byte[] data = new byte[1024];
//        //开辟1Kb的缓冲区
//        while((len = in.read()) != -1){
//            out.write(data,0,len);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("文件拷贝结束，耗时"+(end-start)+"毫秒");
//        return true;
//    }
//}

//class Person{
//    private String name;
//    private int age;
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//    private Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//}
//public class Test {
//    public static void main(String[] args) {
//        Class<?> cls = Person.class;
//        try {
//            Constructor constructor = cls.getDeclaredConstructor(String.class, int.class);//传参看源码
//            Person per = (Person) constructor.newInstance("张三", 18);//传参看源码
//            System.out.println(per);//输出会报错，getDeclaredConstructor可以拿到
//            // private有参构造，但不能在外面New一个对象，会报错，
//            //constructor.setAccessible(true); 加上这句，就可以new了
//        }catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
//}

interface Car{
    void printCar();
}
class Audi implements Car{
    @Override
    public void printCar() {
        System.out.println("this is an Audi");
    }
}
class BMW implements Car{
    @Override
    public void printCar() {
        System.out.println("this is a bmw");
    }
}
class BYD implements Car{
    @Override
    public void printCar() {
        System.out.println("this is a byd");
    }
}
class CarFactor {
    public static Car getCar(String type){
        if(type.equals("奥迪")){
            return new Audi();
        }else if(type.equals("比亚迪")){
            return new BYD();
        }else if(type.equals("宝马")){
            return new BMW();
        }else{
            return null;
        }
    }
}
public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要生产的汽车");
        String type = scanner.nextLine();
        Car car = CarFactor.getCar(type);
        car.printCar();
    }
}