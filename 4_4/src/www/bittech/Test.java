package www.bittech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class Test {
//    public static void main(String[] args) {
//        String str = "helloworld";
//        byte[] data = str.getBytes();
//        for(int i = 0; i < data.length; i++){
////            data[i] -= 32;
//            System.out.println(data[i]);
//        }
//        System.out.println(new String(data));
////        String str = "a123bd";
////        System.out.println(isNumber(str));
////    }
////
////    public static boolean isNumber(String str) {
////        char[] data = str.toCharArray();
////        for (int i = 0; i < data.length; i++) {
////            if (data[i] < '0' || data[i] > '9') {
////                return false;
////            }
////        }
////        return true;
//    }
//}

//        String str = "hello";
//        char[] data = str.toCharArray();
//        for(int i = 0; i < data.length; i++){
//           // data[i] -= 32;
//            System.out.println(data[i]);
//
//        }
//        System.out.println(new String(data));
//        System.out.println(str.charAt(1));
//        List<String> list = new ArrayList<>();
//        list.add("hi");
//        list.add("wanggang");
//        list.add("how are you?");
//        System.out.println(list);
//        list.remove("how are you?");
//        System.out.println(list);
//        list.remove(0);
//        System.out.println(list);
//        Object[] result = list.toArray();
//        System.out.println(result);
//        System.out.println(Arrays.toString(result));
//public class Test{
//    public static void main(String[] args) {
//        System.out.println(add(new int[] {1,3,5}));
//        System.out.println((add(new int[] {1,3,5,7})));
//    }
//    public static int add(int[] data){  //此时以数组来存在数据
//        int result = 0;
//        for(int i = 0; i<data.length; i++){
//            result += data[i];
//        }
//        return result;
//    }
//}
//class MyClass<T>{
//    private T value1;
//    public T getValue1() {
//        return value1;
//    }
//    public void setValue1(T value1) {
//        this.value1 = value1;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyClass<String> myclass = new MyClass<String>();  //使用时再定义类型
//        myclass.setValue1("hello");                       //避免强转异常
//        System.out.println(myclass.getValue1());
//        MyClass<Integer> myclass1 = new MyClass<Integer>();
//        myclass1.setValue1(123);
//        //myclass1.setValue1("ww"); //若用户误输为String型，出现红波浪线，即编译报错
//        System.out.println(myclass1.getValue1());
//    }
//}
//class MyClass<T>{
//    private T value1;  //这种设定，两个都是相同类型
//    private T value2;
//    public T getValue1() { return value1; }
//    public void setValue1(T value1) { this.value1 = value1; }
//    public T getValue2() { return value2; }
//    public void setValue2(T value2) { this.value2 = value2; }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyClass<String> myClass = new MyClass<String>();  //两个都被定义成String型
//        myClass.setValue1("hello");
//        myClass.setValue2("java");
//    }
//}
//class MyClass<T> {
//    private T value1;
//    public T getValue1() { return value1; }
//    public void setValue1(T value1) { this.value1 = value1; }
//}
//public class Test{
//    public static void main(String[] args) {
//        MyClass<String> myClass = new MyClass<>(); //若要改成Integer，下面的print方法也要改
//        myClass.setValue1("hello");                 //若有N个类型，则需要写N个重载方法，故产生了通配符
//        print(myClass);
//    }
//    public static void print(MyClass<String> myClass){
//        System.out.println(myClass.getValue1());
//    }
//}
//class MyClass<T> {
//    private T value1;
//    public T getValue1() { return value1; }
//    public void setValue1(T value1) { this.value1 = value1; }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyClass<Double> myClass = new MyClass<>();  //下面是？,此处可以是任意类型的泛型类
//        myClass.setValue1(10.2);
//        print(myClass);
//    }
//    public static void print(MyClass<?> myClass){
////myClass.setValue1<10>; 此处不能修改数据，因为数据类型不知道，上面传来的是？
//        System.out.println(myClass.getValue1());
//    }
//}
//interface IInterface<T>{
//    T test(T t);
//}
//class InterfaceImpl implements  IInterface<String>{
//    @Override
//    public String test(String s) { //确定好为泛型
//        return s;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        IInterface<String> iInterface = new InterfaceImpl();
//        System.out.println(iInterface.test("hello"));
//    }
//}
//interface IInterface<T>{
//    T test(T t);
//}
//class InterfaceImpl<T> implements IInterface<T>{
//    @Override
//    public T test(T t) {
//        return t;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        IInterface<String> iInterface = new InterfaceImpl<String>();
//        System.out.println(iInterface.test("hello"));
//    }
//}
//class MyClass<T> {
//    private T value1;
//    public T getValue1() { return value1; }
//    public void setValue1(T value1) { this.value1 = value1; }
//}
//public class Test {
//    public static void main(String[] args) {
//
//    }
//    public static void print(MyClass<? super String> myClass){
//        myClass.setValue1("hello"); //此处可以修改，因为子类到父类是自动的向上转型
//        System.out.println(myClass.getValue1());
//    }
//}
//class MyClass<T extends Number> {
//    private T value1;
//    public T getValue1() { return value1; }
//    public void setValue1(T value1) { this.value1 = value1; }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyClass<Double> myClass = new MyClass<>();  //必须是Number类的子类，double的包装类Double是Number的子类
//        //MyClass<String> myClass = new MyClass<>(); String类不是Number类的子类，会编译报错
//        myClass.setValue1(10.2);
//        print(myClass);
//    }
//    public static void print(MyClass<? extends Number> myClass){
//        //myClass.setValue1(10.3);  相当于强制把Number变成10.3，也会编译报错，依然不能修改数据
//        System.out.println(myClass.getValue1());
//    }
//}
//class MyClass<T> {
//    private T value1;
//    public T getValue1() { return value1; }
//    public void setValue1(T value1) { this.value1 = value1; }
//}
//public class Test {
//    public static void main(String[] args) {
//        MyClass<Double> myClass = new MyClass<>();  //下面是？,此处可以是任意类型的泛型类
//        myClass.setValue1(10.2);
//        print(myClass);
//    }
//    public static void print(MyClass<?> myClass){
////myClass.setValue1<10>; 此处不能修改数据，因为数据类型不知道，上面传来的是？
//        System.out.println(myClass.getValue1());
//    }
//}