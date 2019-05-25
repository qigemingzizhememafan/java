package com.lzl;
import java.util.Scanner;
// 简单工厂模式的产生
interface Sugar{
    void printSugar();
}
class milkSugar implements Sugar{
    @Override
    public void printSugar() {
        System.out.println("这是一款大白兔牛奶糖");
    }
}
class cornSugar implements Sugar{
    @Override
    public void printSugar() {
        System.out.println("这是一款金丝猴玉米糖");
    }
}
//public class Client {
//    public void buySugar(Sugar sugar){
//        sugar.printSugar();
//    }
//    public static void main(String[] args) {
//            Client client = new Client();
//            client.buySugar(new cornSugar());
//    }
//}

class sugarFactory{
    public static Sugar getInstance(String type){
        Sugar sugar = null;
        if(type.equals("奶糖")){
            return new milkSugar();
        }else if(type.equals("玉米糖")){
            return new cornSugar();
        }
        return sugar;
    }
}
public class Client{
    public void buySugar(Sugar sugar){
        sugar.printSugar();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想吃的糖");
        String type = scanner.nextLine();
        Sugar sugar = sugarFactory.getInstance(type);
        sugar.printSugar();
    }
}
