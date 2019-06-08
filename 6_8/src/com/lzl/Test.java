package com.lzl;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.*;
// 动态代理
interface ISubject{
    void eat(String name,int count);
}
class RealSubject implements ISubject{
    @Override
    public void eat(String name, int count) {
        System.out.println("eat"+count+"两"+name);
    }
}
class ProxySubject implements InvocationHandler{
    private Object object;
    // 将真实接口与代理类绑定,返回绑定好的代理类对象
    public Object bind(Object realObject){
        this.object = realObject;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }
    @Override  // 参数分别是：代理类对象，真实业务方法，真实方法的传入参数，返回值是真实接口对象
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object obj = method.invoke(this.object,args);
        this.after();
        return obj;
    }
    public void before(){
        System.out.println("before handle");
    }
    public void after(){
        System.out.println("after handle");
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat("饺子",5);
    }
}
//        Class<Test> cls = Test.class;
//        System.out.println(cls.getClassLoader());
//        System.out.println(cls.getClassLoader().getParent());
//        System.out.println(cls.getClassLoader().getParent().getParent());
//public class Test{
//    public static void main(String[] args) throws Exception{
//        String str = "emp.name:zhangsan|emp.job:coder"; // 传一个字符串，通过一次操作，获得多个属性值
//        EmpAction empAction = new EmpAction(); // EmpAction方便用户使用
//        empAction.setEmpValue(str);
//        System.out.println(empAction.getEmp());
//    }
//}
//class Emp{
//    private String name;
//    private String job;
//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
//    public String getJob() {
//        return job;
//    }
//    public void setJob(String job) {
//        this.job = job;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Emp emp = new Emp();
//        emp.setJob("code peasant--码农");
//        emp.setName("张三");
//        System.out.println(emp.getJob());
//        System.out.println(emp.getName());
//    }
//}
// 复习简单工厂模式
/**
 *
 * 优：将实例化对象操作从主方法中解耦出去
 * 劣：产生新类，就要加新类去实现接口
 */
// 动态破坏封装
//class Person{
//    private int age;
//}
//public class Test{
//    public static void main(String[] args) throws Exception{
//        Class<Person> cls = Person.class;
//        Field field = cls.getDeclaredField("age"); // 不能用getField，拿不到private属性
//        Person per = cls.newInstance();
//        // 动态破坏封装
//        field.setAccessible(true);
////        field.set(per,20);
////        System.out.println(field.get(per));
//        // 不通过上面的反射调用，只是直接调用
//
//    }
//}

//class Person{
//    public int age;
//}
//public class Test{
//    public static void main(String[] args) throws Exception{
//        Class<Person> cls = Person.class;
//        // 取得Field对象
//        Field field = cls.getField("age");
//        // 取得Person实例化对象
//        Person per = cls.newInstance();
//        // set & get
//        field.set(per,18);
//        System.out.println(field.get(per));
//        System.out.println(field.getType());
//    }
//}
//class Person{
//    private String name;
//    protected int age;
//    public int phonenumber;
//}
//class Student extends Person{
//    private String school;
//    protected int id;
//    public String dep;
//}
//public class Test{
//    public static void main(String[] args) {
//        {
//            Class<Student> cls = Student.class;
//            Field[] fields = cls.getDeclaredFields();
//            for (Field f : fields) {
//                System.out.println(f);
//            }
//        }
//        System.out.println("----------------------------");
//        {
//            Class<Student> cls = Student.class;
//            Field[] fields = cls.getFields();
//            for (Field f : fields) {
//                System.out.println(f);
//            }
//        }
//    }
//}

//class Person{
//    private String name;
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//public class Test{
//    public static void main(String[] args) throws Exception{
//        // 正向调用get、set方法
//        //  Person per = new Person();
//        //  per.setName("zhangsan ");
//        //  System.out.println(per.getName());
//        // 反向调用
//        // 1, 取得Class对象
//        Class<Person> cls = Person.class;
//        // 2, 组装方法名称
//        String setMethodName = "set"+initCap(args[0]); // 传参，设置run-》editconfig-》program arguments:写成name
//        String getMethodName = "get"+initCap(args[0]);
//        // 3, 取得Method对象
//        Method setMethod = cls.getMethod(setMethodName,String.class);
//        Method getMethod = cls.getMethod(getMethodName);
//        // 4, 取得Person类实例化对象而后调用方法
//        Person per = cls.newInstance();
//        setMethod.invoke(per,"张三");
//        System.out.println(getMethod.invoke(per));
//    }
//    private static String initCap(String str){
//        return str.substring(0,1).toUpperCase()+str.substring(1);
//    }
//}

//interface IFruit{
//    void eat();
//}
//class Apple implements IFruit{
//    @Override
//    public void eat() {
//        System.out.println("吃苹果");
//    }
//}
//class Orange implements IFruit{
//    @Override
//    public void eat() {
//        System.out.println("吃橘子");
//    }
//}
//
//// 用反射改造,此时要是新增水果，此处代码不用改
//class Factory{
//    public static IFruit getInstance(String fruitName){
//        IFruit iFruit = null;
//        Class<?> cls = null;
//        try {
//            cls = Class.forName(fruitName);
//            try {
//                iFruit = (IFruit) cls.newInstance(); // 上面写的是通配符，默认生成了object类型
//            } catch (InstantiationException e) {     //  需要强转成IFruit
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return  iFruit;
//    }
//}
//}
//class Factory{
//    public static IFruit getInstance(String fruitName){
//        if(fruitName.equals("apple")){
//            return new Apple();
//        }else if(fruitName.equals("orange")){
//            return new Orange();
//        }
//        return null;
//    }
//}

//interface IMsg{}
//interface INews{}
//abstract class Fun{}
//class RealClass extends Fun implements IMsg,INews{
//
//}

//class Person{
//    private String name;
//    private int age;
//
//    private Person(){}
//    protected Person(String name){}
//    public Person(String name,int age){
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
//public class Test{
//    public static void main(String[] args) throws Exception{
//        Class<Person> cls = Person.class;
//        // 取得有参构造
//        Constructor constructor = cls.getConstructor(String.class,int.class);
//        // 拿到有参构造后实例化对象,相当于调用Person per = new Person("张三",18);
//        Person per = (Person) constructor.newInstance("张三",18);
//        System.out.println(per);
//    }
//}
//class Student extends Person{
//    public Student(String name,int age){
//        super(name,age);
//    }
//}
//public class Test {
//    public static void main(String[] args) throws Exception{
//        Class<Student> cls = Student.class;
//        // 取得类中所有构造方法
//        {
//            Constructor<?>[] constructors = cls.getConstructors();
//            for (Constructor constructor : constructors) {
//                System.out.println(constructor);
//            }
//        }
//        System.out.println("-----------------------------------------");
//        {
//            {
//                Constructor<?>[] constructors = cls.getDeclaredConstructors();
//                for (Constructor constructor : constructors) {
//                    System.out.println(constructor);
//                }
//            }
//        }
//        Class<RealClass> cls = RealClass.class;
//        System.out.println(cls.getSuperclass()); // 取得父类信息
//        Class[] classes = cls.getInterfaces();   // 取得父接口信息
//        for(Class c : classes){
//            System.out.println(c);
//        }

//        Class<Test> cls = Test.class;
//        System.out.println(cls.getPackage()); // package com.lzl
//        System.out.println(cls.getPackage().getName()); // com.lzl

//        IFruit iFruit = Factory.getInstance("orange");
//        IFruit iFruit = Factory.getInstance("com.lzl.orange"); // 传类的全名
//        iFruit.eat();
//    }
//}
