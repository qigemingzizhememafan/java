package com.lzl;
import java.util.*;

class Person{

    private String name;
    private Integer age;
    public Person(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // 自反性
        if(obj == this){
            return true;
        }
        // 非空性
        else if(obj == null){
            return false;
        }
        // 对称性 传递性 一致性
        else if(!(obj instanceof Person)){
            return false;
        }
        else{
            Person per = (Person) obj;
            return per.age.equals(this.age) && per.name.equals(this.name);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(age,name);
    }
}
public class Test {
    public static void main(String[] args) {
        Person per1 = new Person("A", 20);
        Person per2 = new Person("A", 20);
        System.out.println(per1.equals(per2));
        Set<Person> set = new HashSet<>();
        set.add(new Person("A", 20));
        set.add(new Person("B", 18));
        set.add(new Person("C", 21));
        set.add(new Person("A", 20));
        System.out.println(set);
    }
}
//class AscComparator implements Comparator<Person>{
//    @Override
//    public int compare(Person o1, Person o2) {
//        return o1.getAge()-o2.getAge();
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Set<Person> set = new TreeSet<>(new AscComparator()); //不传比较器是会报错的，编译不过去
//        set.add(new Person("张三",18));
//        set.add(new Person("李四",25));
//        System.out.println(set);
//    }
//}
