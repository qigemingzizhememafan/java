package com.lzl;

import java.util.*;
public class CollectionAndMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hello");
        map.put(3, "java");
        map.put(2, "bit");
        map.put(null,null);
        map.put(1,"wanggang");
        map.put(4,null);
        // 取得当前Map中的所有Key值
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+"****");
        }
        // 取得所有Value值
//        List<String> list = (List<String>) map.values();   //改变输出方法可得到不同的结果，如下例
//        Iterator<String> iterator1 = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator1.next());
//        }
        for(Integer i : keySet){
            System.out.println(map.get(i));
        }
    }
}
//class Student implements Comparable<Student> {
//    private int ID;
//    private String name;
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "ID=" + ID +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    public Student(int ID, String name) {
//        this.ID = ID;
//        this.name = name;
//    }
//
//    public int getID() {
//        return ID;
//    }
//
//    public void setID(int ID) {
//        this.ID = ID;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public int compareTo(Student o) {
//        if(o.ID > this.ID){
//            return -1;
//         }else if(o.ID < this.ID){
//            return 1;
//        }else{
//            return o.name.compareTo(this.name);
//        }
//}
    // 判断两个对象是否相同
//    // obj就是当前对象
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (!(obj instanceof Student)) {
//            return false;
//        }
//        Student per = (Student) obj;
//        return this.ID == per.ID && this.name.equals(per.name);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(ID, name);
//    }
//}
//class Man{
//    private int salary;
//    private String name;
//
//    public Man(int salary, String name) {
//        this.salary = salary;
//        this.name = name;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Man{" +
//                "salary=" + salary +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
//class OutComp implements Comparator<Man>{
//    @Override
//    public int compare(Man o1, Man o2) {
//        return o2.getSalary() - o1.getSalary();
//    }
//}
//public class CollectionAndMap {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("1");
//        Iterator<String> iterator = list.iterator();
//        ListIterator<String> listIterator = list.listIterator(list.size());
//            while(listIterator.hasNext()) {
//            String s = listIterator.next();
//            System.out.println(s);
//            }
//
//            while(listIterator.hasPrevious()){
//                System.out.println(listIterator.previous());
//            }
//            Map<Integer,String> map = new HashMap<>();
//            map.put(5,"z");
//            map.put(2,"y");
//            map.put(3,"x");
//            map.put(4,"b");
//            map.put(1,"a");
//            Set<Integer> keyset = map.keySet();
//            Iterator<Integer> integerIterator = keyset.iterator();
//            while(integerIterator.hasNext()){
//                System.out.println(integerIterator.next());
//            }
//        System.out.println(map);
//        Set<Student> set = new HashSet<>();
//        Set<Man> set = new TreeSet<>();
//        set.add(new Man(1000,"张三"));
//        set.add(new Man(23424,"zhaoliu"));
//        set.add(new Man(1123,"wangwu"));
//        set.add(new Man(1000,"lisi"));
//        System.out.println(set);

//        Set<Student> set = new HashSet<>();
//        set.add(new Student(01,"张三"));
//        set.add(new Student(02,"李四"));
//        System.out.println(set);
//        System.out.println(set.size());
//        set.add(new Student(01,"张三"));
//        System.out.println(set);
//        System.out.println(set.size());
//        System.out.println(set.contains(new Student(01,"张三")));
//    }
//}
