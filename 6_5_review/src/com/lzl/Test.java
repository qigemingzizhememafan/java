package com.lzl;
import javax.xml.soap.Node;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class Person{
    private int age;
}
public class Test{
    public static void main(String[] args) throws Exception{
        Class<Person> cls = Person.class;
        Field field = cls.getDeclaredField("age");
        Person per = cls.newInstance();
        // 动态破坏封装
        field.setAccessible(true);
        field.set(per,20);
        System.out.println(field.get(per));
    }
}
//class Person{
//    public int age;
//}
//public class Test{
//    public static void main(String[] args) throws Exception{
//        Class<Person> cls = Person.class;
//        // 取得Field对象
//        Field field = cls.getField("age");
//        // 取得Person实例化对象
//        Person per= cls.newInstance();
//        // set & get
//        field.set(per,20);
//        System.out.println(field.get(per));
//        System.out.println(field.getType()); // 取得属性值类型
//    }
//}
//class Person{
//    public static String test;
//    private String name;
//    public int age;
//}
//class Student extends Person{
//    private String school;
//    public String className;
//}
//public class Test{
//    public static void main(String[] args) {
//        Class<Student> cls = Student.class;
//        {
//            Field[] fields = cls.getFields();
//            for(Field field:fields){
//                System.out.println(field);
//            }
//        }
//        System.out.println("----------------------");
//        {
//            Field[] fields = cls.getDeclaredFields();
//            for(Field field:fields){
//                System.out.println(field);
//            }
//        }
//    }
//}

//class Person{
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
//public class Test{
//    public static void main(String[] args) throws Exception{
//        // 1. 取得Class对象
//        Class<Person> cls = Person.class;
//        // 2. 组装方法名称
//        String setMethodName = "set"+initCap(args[0]);
//        String getMethodName = "get"+initCap(args[0]);
//        // 3. 取得Method对象
//        Method setMethod = cls.getMethod(setMethodName,String.class);
//        Method getMethod = cls.getMethod(getMethodName);
//        // 4. 取得Person类实例化对象而后调用方法
//        Person per = cls.newInstance();
//        setMethod.invoke(per,"张三");
//        System.out.println(getMethod.invoke(per));
//    }
//    // 首字母大写方法
//    private static String initCap(String str){
//        return str.substring(0,1).toUpperCase()+str.substring(1);
//    }
//}
//class Person{
//    int age;
//    String name;
//    private Person(){};
//    protected Person(String name){};
//    public Person(String name,int age){
//        this.name = name;
//        this.age = age;
//    }
//    @Override
//    public String toString() {
//        return "Person{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
//public class Test{
//    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Class<Person> cls = Person.class;
//        // 取得有参构造
//        Constructor constructor = cls.getConstructor(String.class,int.class);
//        // 实例化对象
//        // 相当于调用Person per = new Person("张三",18);
//        Person per = (Person)constructor.newInstance("张三",18);
//        System.out.println(per);
//
//    }
//}
//class Person{
//    private Person(){}
//    protected Person(String name){}
//    public Person(String name,int age){}
//}
//class Student extends Person{
//    public Student(String name,int age){
//        super(name,age);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Class<Student> clf = Student.class;
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
//    }
//}
//        Class<Date> cls = Date.class;
//        // 通过反射取得实例化对象
//        Date data = cls.newInstance(); // 等于Date data = new Date();
//        System.out.println(data);

//        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"张三");
//        map.put(2,"李四");
//        map.put(3,"王五");
//        // 输出Map集合
//        // 1.Map -> Set
//        Set<Map.Entry<Integer,String>> set = map.entrySet();
//        // 2. 取得Set接口迭代器
//        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
//        // 3. 使用标准迭代输出
//        while(iterator.hasNext()){
//            Map.Entry<Integer,String> entry = iterator.next();
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }


