package com.lzl;
import java.lang.reflect.Constructor;
import java.util.Date;
//class Person{
//    private String name;
//    private int age;
//    private Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
//interface iFruit{
//    void eat();
//}
//class Apple implements iFruit{
//    @Override
//    public void eat() {
//        System.out.println("吃苹果");
//    }
//}
//class Orange implements iFruit{
//    @Override
//    public void eat() {
//        System.out.println("吃橘子");
//    }
//}
//class Mango implements iFruit{
//    @Override
//    public void eat() {
//        System.out.println("吃芒果");
//    }
//}
//class Factory{
//    public static final iFruit getFruit(String classname) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        iFruit iFru = null;
//        Class<?> cls = Class.forName(classname);
//        iFru = (iFruit)cls.newInstance();
//        return iFru;
//    }
//}
class Person{
    private Person(){}
    protected Person(String name){}
    public Person(String name,int age){}
}
class Student extends Person{
    public Student(String name,int age){
        super(name,age);
    }
    protected Student(String name){
        super(name);
    }
}
public class Reflect {
    public static void main(String[] args) {
        Class<Student> clf = Student.class;
        {
            Constructor[] constructors = clf.getConstructors();
            for(Constructor constructor:constructors){
                System.out.println(constructor);  // 只输出public的www.bittech.Person
            }
        }
        System.out.println("****************分割线****************");
        {
            Constructor[] constructors = clf.getDeclaredConstructors();
            for(Constructor constructor:constructors){  // 输出三个权限的
                System.out.println(constructor);
            }
        }
//        iFruit fru = Factory.getFruit("com.lzl.Mango");
//        fru.eat();
//        }
//        Class<?> cls = Person.class;
//        Constructor<?> constructor = cls.getDeclaredConstructor(String.class,int.class);
//        Person per = (Person)constructor.newInstance("张三",20);
//        System.out.println(per);
//        Person per = (Person)cls.newInstance();
//        System.out.println(per);
//        Date data = new Date();
//        Date data1 = new Date();
//        System.out.println(Date.class);
//        System.out.println(Class.forName("java.util.Date"));
//        System.out.println(data.getClass());
//        System.out.println(Date.class == data.getClass());
    }
}

