package www.bittech;

import java.io.InputStream;
import java.util.*;

//class Person{
//    private String name;
//    private Integer age;
//
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
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
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
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
//class PersonComparator implements Comparator<Person> {
//    @Override
//    public int compare(Person o1, Person o2) {
//        // 自定义比较方式
//        if(!(o1.getName().equals(o2.getName()))){
//            // 比较name
//            return  o1.getName().compareTo(o2.getName());
//        }else{
//            return o1.getAge().compareTo(o2.getAge());
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Person per = new Person("zhangsan",20);
//        Person per1 = new Person("lisi",18);
//        Set<Person> set = new TreeSet<>(new PersonComparator());//传入自己写的构造比较器
//        set.add(per);
//        set.add(per1);
//        for(Person person:set){
//            System.out.println(person);
//        }
//    }
//}

//public class Test {
//    public static void main(String[] args) {
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
//    public static void main(String[] args) {
//        Person per1 = new Person("张三",18);
//        Person per2 = new Person("李四",20);
//        Person per3 = new Person("王五",22);
//        List<Person> list = new ArrayList<>(); //将等号右边换为new Vector，
//        //new LinkedList,结果完全一样，用法相同
//        list.add(per1);
//        list.add(per2);
//        list.add(per3);
//        //输出为false，看源码可发现此处equals比较的是地址，并未比较内容
//        //所以需要自己覆写equals方法,上述代码已覆写过，故输出为true，删除操作
//        //也需要覆写，得先找到被删除对象是否在集合内
//        System.out.println(list.contains(new Person("张三",18)));
//        list.remove(new Person("王五",22));
//        System.out.println(list);
//        // System.out.println(list.contains(per1));
//    }
//}

//class Person{
//    private String name;
//    private Integer age;
//    public Person(String name, Integer age) {
//        super();
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
//public class Test{
//    public static void main(String[] args) {
//        Set<Person> set = new HashSet<>(); //自定义类，没覆写hashcode()以及equals
//        set.add(new Person("A", 20));   //可以系统快捷键覆写，不用手动覆写，但是快捷键是啥忘了
//        set.add(new Person("B", 21));
//        set.add(new Person("C", 22));
//        set.add(new Person("A",20));
//        System.out.println(set); //输出会有重复元素
//    }
//}

//class Person implements Comparable<Person>{  //要想排序，要实现Comparable接口
//    private String name;             // 并覆写compareTo方法，否则会报错（无法比较）
//    private Integer age;
//    public Person(String name, Integer age) {
//        super();
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
//
//    @Override
//    public int compareTo(Person o) {
//        if(this.age > o.age){
//            return 1;
//        }else if(this.age < o.age){
//            return -1;
//        }else{
//            return this.name.compareTo(o.name);
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Set<Person> set = new TreeSet<>();
//        set.add(new Person("A", 20));
//        set.add(new Person("B", 21));
//        set.add(new Person("C", 22));
//        set.add(new Person("D", 20));
//        System.out.println(set);  //输出为有序序列
//    }
//}

//public class Test{
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("A");
//        list.add("B");
//        list.add("B");
//        list.add("C");
//        //标准输出
//        Iterator<String> iterator = list.iterator();
//        //循环输出
//        while(iterator.hasNext()){
//            String str = iterator.next(); //取得当前元素
//            if(str.equals("A")){
//                list.remove("A");  //使用iterator.remove()不会产生此问题，iteator中没有modCount
//                continue;
//            }
//            System.out.println(iterator.next());
//        }
//    }
//}

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hello");
        map.put(3, "java");
        map.put(2, "bit");
        map.put(null,null);
        map.put(null,null);
        map.put(4,null);
        // 取得当前Map中的所有Key值
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 取得所有Value值
        List<String> list = (List<String>) map.values();   //改变输出方法可得到不同的结果，如下例
        Iterator<String> iterator1 = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}