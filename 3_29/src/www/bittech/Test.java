package www.bittech;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
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
//        System.out.println("吃橙子");
//    }
//}
//class Factory{
//    private Factory(){}
//    public static IFruit getInstance(String className){
//       IFruit fruit = null;
//       try{
//           //取得任意子类反射对象
//           Class<?> cls = Class.forName(className);
//           //通过反射取得实例化对象
//           fruit = (IFruit) cls.newInstance();
//       }catch(Exception e){
//           e.printStackTrace();
//        }
//        return fruit;
//    }
//}
//class Person{}
//interface INews{}
//interface IMessage{}
//class Student extends Person implements INews,IMessage{}
//class Person{
//    private Person(){} //删掉这行，由于类中有了有参构造，系统默认的无参构造不再生成
//    protected Person(String name){} //仍会报错
//    public Person(String name,int age){}
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
//}
//class Person{
//  private void test(){}
//  protected void fun(){}
//  public void haha(){}
//}
//class Student extends Person{
//    private void test(){}
//    protected void fun(){}
//    public void haha(){}
//}
class Person{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test {
    public static void main(String[] args) throws Exception{
        // 1.取得类对象
        Class<?> clf = Person.class;
        // 2.创建Person类实例化对象
        Person per = (Person) clf.newInstance();
        // 3.拿到setName的Method对象
        Method setMethod = clf.getMethod("setName", String.class);
        // 4.通过invoke进行调用
        setMethod.invoke(per,"张三");
        System.out.println(per);
    }
}
//       Class cls = Student.class;
//        {
//            Method[] method = cls.getMethods();
//            for (Method method1 : method) {
//                System.out.println(method1);
//            }
//        }
//        System.out.println("********分隔符*****");
//        {
//            Method[] methods = cls.getDeclaredMethods();
//            for(Method method:methods){
//                System.out.println(method);
//            }
//        }
//        Class<?> cls = Person.class;
//        cls.getDeclaredMethods()
//
//        Class<?> cls = Person.class;
//        try {
//            Person per = (Person) cls.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Class<?> clf = Person.class;
//        {
//            Constructor[] constructors = clf.getConstructors();
//            for(Constructor constructor:constructors){
//                System.out.println(constructor);//只输出public的www.bittech.Person
//            }
//        }
//        System.out.println("****************分割线****************");
//        {
//            Constructor[] constructors = clf.getDeclaredConstructors();
//            for(Constructor constructor:constructors){ //输出三个权限的
//                System.out.println(constructor);
//            }
//        }
//     Class<?> clf = int.class;
//     Class<?> clf1 = Integer.class;
//        System.out.println(clf);
//        System.out.println(clf1);
//        Constructor
//    }
//}
//        Class<?> clf = Student.class;
//        // 取得父类信息
//        System.out.println(clf.getSuperclass().getName()); // www.bittech.Person
//        // 取得父接口
//        Class<?>[] classes = clf.getInterfaces();
//        for(Class classs:classes){
//            System.out.println(classs.getName()); // www.bittech.INews
//        }                                         // www.bittech.IMessage
//   // 1.取得Class对象
//        Class<?> cls = Date.class;
//        System.out.println(cls.getPackage()); //package java.util, Java Platform API Specification, version 1.8
//        System.out.println(cls.getPackage().getName()); //java.util
//        System.out.println(cls.getName());//java.util.Date;
//        IFruit fruit = Factory.getInstance("www.bittech.Apple");
//        fruit.eat();
//    public static void main(String[] args){
//        //把New操作扔给第三方工厂
//     IFruit fruit = Factory.getInstance("Apple");
//     fruit.eat();
//        //正向产生一个日期类
//        //Date date = new Date();
//        //反向根据反射产生日期类
//        //1.取得类的Class对象，异常处理后长这样，输入时直接是Class.forName
//        Class<Date> cls = (Class<Date>) Class.forName("java.util.Date");
//        //通过反射取得Date类实例化对象
//        Date date = cls.newInstance();
//        System.out.println(date);
//        //根据类正向产生对象
//        Date date = new Date();
//        Date date1 = new Date();
//        //实例化Class对象
//        //1. 通过类名称.getClass()
//        System.out.println(date.getClass());
//        System.out.println(date1.getClass());
//        //2. 通过类名称.Class
//        System.out.println(Date.class);
//        //3. 通过调用Class类提供的静态方法forName(String className)className必须写全名称
//        System.out.println(Class.forName("java.util.Date")); //上述输出都为java.util.Date
//        //无论new多少对象，JVM只会在加载时产生一个Class的实例化对象
//        System.out.println(date1.getClass() == date.getClass());  //输出为true

