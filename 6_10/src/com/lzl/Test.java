package com.lzl;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
// 序列化实现深拷贝
class Teacher implements Serializable{
    private String name;
    private String job;
    public Teacher clone(){
        Teacher teacher = null;
        try {
            teacher = (Teacher) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }
    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
class Student implements Serializable{
    private String name;
    private int age;
    private Teacher teacher;
    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }
    public Student cloneObject() throws Exception{
        Student student = null;
        ByteOutputStream bos = new ByteOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //参数是从内存中把数据读进来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.getBytes());
        ObjectInputStream ois = new ObjectInputStream(bis);
        // 从内存中反序列化出来
        return (Student) ois.readObject();
    }
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
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
public class Test {
    public static void main(String[] args) throws Exception{
        Teacher teacher = new Teacher("张三百","Teacher");
        Student student = new Student("王五",10,teacher);
        Student studentClone = student.cloneObject();
        System.out.println(student);
        System.out.println(studentClone);
        System.out.println("-------------------------------------");
        System.out.println(studentClone.getAge());
        System.out.println(student.getAge());
        System.out.println(studentClone.getName());
        System.out.println(student.getName());
        System.out.println("---------------------------------------");
        System.out.println(teacher == studentClone.getTeacher());
    }
}
// 序列化与反序列化
//class Person implements Serializable{
//    private String name;
//    private  transient Integer age;
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public Integer getAge() {
//        return age;
//    }
//    public void setAge(Integer age) {
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
//public class Test{
//    public static void main(String[] args) throws Exception{
//         把Per序列化输出到文件中
//        Person per = new Person("张三",18);
//        File file = new File("C:\\Users\\Administrator\\Desktop\\TestSer.txt");
//        OutputStream out = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(out);
//        oos.writeObject(per);
//        oos.close();
//         再把Per反序列化
//        File file = new File("C:\\Users\\Administrator\\Desktop\\TestSer.txt");
//        InputStream in = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(in);
//        Person per = (Person)ois.readObject();
//        System.out.println(per);
//    }
//}
// 递归实现深拷贝
//class Teacher implements Cloneable{
//    private String name;
//    private String job;
//    public Teacher clone(){
//        Teacher teacher = null;
//        try {
//            teacher = (Teacher) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return teacher;
//    }
//    public Teacher(String name, String job) {
//        this.name = name;
//        this.job = job;
//    }
//}
//class Student implements Cloneable{
//    private String name;
//    private int age;
//    private Teacher teacher;
//    public Student(String name, int age, Teacher teacher) {
//        this.name = name;
//        this.age = age;
//        this.teacher = teacher;
//    }
//    public Student clone(){
//        Student student = null;
//        try {
//            // 实现拷贝处理
//            // 产生一个新的student对象，并且拷贝原有所有属性值
//            student = (Student) super.clone();
//            student.teacher = this.teacher.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return student;
//    }
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
//    public Teacher getTeacher() {
//        return teacher;
//    }
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Teacher teacher = new Teacher("张三百","Teacher");
//        Student student = new Student("王五",10,teacher);
//        Student studentClone = student.clone();
//        System.out.println(student);
//        System.out.println(studentClone);
//        System.out.println("-------------------------------------");
//        System.out.println(studentClone.getAge());
//        System.out.println(student.getAge());
//        System.out.println(studentClone.getName());
//        System.out.println(student.getName());
//        System.out.println("---------------------------------------");
//        System.out.println(teacher == studentClone.getTeacher());
//    }
//}
// 浅拷贝
//class Teacher{
//    private String name;
//    private String job;
//    public Teacher(String name, String job) {
//        this.name = name;
//        this.job = job;
//    }
//}
//class Student implements Cloneable{
//    private String name;
//    private int age;
//    private Teacher teacher;
//    public Student(String name, int age, Teacher teacher) {
//        this.name = name;
//        this.age = age;
//        this.teacher = teacher;
//    }
//    public Student clone(){
//        Student student = null;
//        try {
//            // 实现拷贝处理
//            // 产生一个新的student对象，并且拷贝原有所有属性值
//            student = (Student) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return student;
//    }
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
//    public Teacher getTeacher() {
//        return teacher;
//    }
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Teacher teacher = new Teacher("张三百","Teacher");
//        Student student = new Student("王五",10,teacher);
//        Student studentClone = student.clone();
//        System.out.println(student);
//        System.out.println(studentClone); // 两个地址不同，有拷贝了新的对象
//        System.out.println("-------------------------------------");
//        System.out.println(studentClone.getAge());
//        System.out.println(student.getAge());
//        System.out.println(studentClone.getName());
//        System.out.println(student.getName()); // 属性都相同，拷贝到了结果
//        System.out.println("---------------------------------------");
//        // 结果为true，拷贝到了teacher的引用
//        System.out.println(teacher == studentClone.getTeacher());
//    }
//}

