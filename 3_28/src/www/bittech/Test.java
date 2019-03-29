package www.bittech;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.*;
//class Person{
//   //   @Override   加上此注解后，会提示你覆写失败，让你检查错误
//    public String tostring(){ //此时编译没报错，但运
//        return "hello world"; // 行结果表明没有成功覆写toString方法
//    }
//}
//    private String name;
//    @Deprecated //过期注释
//    public Person(){
//        System.out.println("******");
//    }
//    public Person(String name){
//        System.out.println(name+"******");
//    }
//class Person<T>{ //定义泛型类
//}
//interface IInterface{
//    //抽象方法
//    void test();
//    default void fun(){
//        System.out.println("JDK1.8新增普通方法");
//    }
//    static void method(){
//        System.out.println("JDK1.8新增的静态方法"+"通过接口名调用");
//    }
//}
//class InterfaceImpl implements IInterface{
//    public void test(){
//        System.out.println("子类覆写抽象方法");
//    }
//}
//interface Add{
//    void add(int x,int y);
//}
////算一个加法
//class AddImpl implements Add{
//    public void add(int x,int y){
//        System.out.println(x+y);
//    }
//}
////想让x先加10再加上y，不能直接修改上面的类
////上面的类有可能被别的类继承，若修改，则会影响别的程序运行
////因此必须重新定义一个新的类
//class AddImpl1 implements Add{
//    public void add(int x,int y){
//        System.out.println(x+10+y);
//    }
//}
//interface Add{
//    void add(int x,int y);
//    //void Mul(int x,int y);写上这句会报错
//    //要实现函数式编程，接口中只能有一个方法
//    //(x,y)只表示抽象方法的括号，并没有具体名字，故只能有一个方法
//}
//interface IMessage{
//    void print(); //无返回值类型
//}
//@FunctionalInterface
//interface Add{
//    int add(int x,int y); //有返回值类型
//}
//interface IUtil<R>{
//   R switchPara();
//}
//interface IUtil<R,P>{
//    R compare(P p1,P p2);
//}
//class Person{
//    private String name;
//    private Integer age;
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//}
//interface  IUtil<R,PN,PR>{
//    R createPer(PN p1,PR p2);
//}
//public class Test{
//    public static void main(String[] args) {
//        IUtil<Person,String,Integer> util = Person::new;
//        //相当于调用Person p = new Person();
//        System.out.println(util.createPer("张三",20));
//    }
//}
//       IUtil<Integer,String> util = String::compareTo;
//        System.out.println(util.compare("刘","杨"));
//     IUtil<String> util = "hello" :: toUpperCase; //转成大写
//     //相当于调用了"hello".toUpperCase();
//        System.out.println(util.switchPara());
//        IUtil<Integer,String> util = String ::valueOf; //引用String类的valueof方法
//        //相当于调用String.valueOf(10)
//        String str = util.switchPara(10);
//        System.out.println(str.startsWith("1"));//证明确实被转成String了
//        Add add = (p1,p2) -> {
//            int result = p1+p2;
//            result += 20;
//            return result;
//        };
//        System.out.println(add.add(10,20));
//      //函数式编程，(x,y)是抽象方法的括号，-> 代表实现，sout代表方法的具体实现
//        Add add = (x,y) -> System.out.println(x+y);
//        //Lambda表达式
//        Add add1 = (x,y) -> System.out.println(x+10+y);
//        add.add(10,20);
//        add1.add(10,20);
//        Add add = new Add() {
//            //匿名内部类，隐藏了实现接口的过程
//            @Override
//            public void add(int x, int y) {
//                System.out.println(x+y);
//            } //求和虽然代码量减少，但是总给人感觉直接实现了接口
//        };
//        Add add = new AddImpl();
//        Add add1 = new AddImpl1();
//        add.add(10,20);
//        add1.add(10,20);
//    }
//}
//        IInterface iInterface = new InterfaceImpl();
//        iInterface.test();
//        iInterface.fun();
//        IInterface.method();
//        @SuppressWarnings({"rawtypes","unused" })
//      Person person = new Person(); //此时三个Person下都会出现黄色波浪线
        // 第一个没说明Person类型，第二个没被使用，第三个没说明类型
        //应改为Person<String> person = new Person<>();
        //但也可以不改，在出错的上一行加上警告压制,就不会报错了
        //@SuppressWarnings({"rawtypes","unused" })
//        Person per1 = new Person(); //过期方法，能用，但是不推荐使用
//        Person per2 = new Person("王港");
//        Person per = new Person();
//        System.out.println(per);
//class Person{
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//    private String name;
//    private Integer age; //构造方法，get、set方法太多，很麻烦
//    public String getName() {
//        return name;
//    } //用注解可以不用写上述很多的方法
//    public void setName(String name) {
//        this.name = name;
//    }
//    public Integer getAge() {
//        return age;
//    }
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//}
//class Person{
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    private String name;
//    private int age;
//
//    @Override
//    public boolean equals(Object obj) {
//        if(obj == this){
//            return true;
//        }if(obj == null){
//            return false;
//        }if(!(obj instanceof Person)){
//            return false;
//        }
//        Person per = (Person)obj;
//        return this.age == per.age && this.name.equals(per.name);
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//}
//public class Test {
//   public static void main(String[] args) {
//       Set<String> set = new TreeSet<>();
//       set.add("C");
//       set.add("B");
//       set.add("A");
//       set.add("A");
//       System.out.println(set);
//   }
//}
//        Person per1 = new Person("张三",18);
//        Person per2 = new Person("李四",20);
//        Person per3 = new Person("王五",22);
//        List<Person> list = new ArrayList<>();
//        list.add(per1);
//        list.add(per2);
//        list.add(per3);
//        //输出为false，看源码可发现此处equals比较的是地址，并未比较内容
//       //所以需要自己覆写equals方法,上述代码已覆写过，故输出为true，删除操作
//       //也需要覆写，得先找到被删除对象是否在集合内
//      System.out.println(list.contains(new Person("张三",18)));
//      list.remove(new Person("王五",22));
//       System.out.println(list);
       // System.out.println(list.contains(per1));
//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("hello");
//        list.set(2,"hi"); //将下标为2的改为hi
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i)+"、");
//        }
//        System.out.println(list);
//        System.out.println(list.size()); //判断数组长度
//        System.out.println(list.contains("world")); //是否包含world
//        System.out.println(list.remove("hello"));//删除hello
//        System.out.println(list.size());
//        System.out.println(list);//删了第一个hello
//        list.clear();//清空数组
//        System.out.println(list);
//    }
//}
