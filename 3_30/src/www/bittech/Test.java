package www.bittech;

import java.util.*;

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
public class Test{
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(); //将底下4个vector都改名，右击vector
        vector.add("A");                        //选择refactor，再选rename
        vector.add("B");
        vector.add("C");
        Enumeration<String> enumeration = vector.elements();
       for(String string:vector){
            System.out.println(string);
        }
    }
    }
//        Set<Person> set = new HashSet<>(); //自定义类，没覆写hashcode()以及equals
//        set.add(new Person("A", 20));
//        set.add(new Person("B", 21));
//        set.add(new Person("C", 22));
//        set.add(new Person("A",20));
//        System.out.println(set); //输出会有重复元素
//    }
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
//public class Test{
//    public static void main(String[] args) {
//        Set<Person> set = new TreeSet<>();
//        set.add(new Person("A", 20));
//        set.add(new Person("B", 21));
//        set.add(new Person("C", 22));
//        set.add(new Person("D",20));
//        System.out.println(set);
//    }
//    int[] arr = new int[]{1,2,3,4};
//    int len = arr.length; //实际能存储的数据 -- 理论
//    int size = 4; //实际存储的数据 -- 现实
//    public void remove(int index){
//        for(int i = index; i < len-1; i++) {
//            arr[i] = arr[i + 1];
//        }
//        len--;
//    }
//    //头插
//    public void pushFront(int item){
//        for(int i = len; i > 0; i--){
//            arr[i] = arr[i-1];
//        }
//        arr[0] = item;
//    }
//    //中间插入
//    public void add(int index,int item){
//        for(int i = len; i > index; i--){
//            arr[i] = arr[i-1];
//        }
//        arr[index] = item;
//        len++;
//    }
//    public static int binarySearch(int[] array,int value) {
//        int left = 0;
//        int right = array.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (array[mid] > value) {
//                right = mid - 1;
//            } else if (array[mid] < value) {
//                left = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }

//public class Test{
//    public static void main(String[] args) {
//        int[] a = new int[]{1,3,4,5,0,56,432,21};
//        bubbleSot(a);
//
//    }
//    public static void bubbleSot(int[] array) {
//        int len = array.length;
//        for (int i = 0; i < len; i++) {
//            for(int j = 0; j < lecn-1-i; j++) {
//                int left = 0;
//                int right = left+1;
//                if (array[left] > array[right]) {
//                    swip(left, right);
//                }
//            }
//        }
//    }
//    public static void swip(int x,int y){
//        int temp = 0;
//        temp = x;
//        x = y;
//        y = temp;
//    }
//}
//import java.util.Date;
//class Person{
//    private Person(){}
//    protected Person(String name){}
//    public Person(String name,int age){
//        System.out.println(name+""+age);
//    }
//}
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException {
//        Class<?> cls = Person.class;
//        try {
//            Person per = (Person) cls.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Date date = new Date();
//        Date date1 = new Date();
//        System.out.println(date.getClass());
//        System.out.println(Date.class);
//        System.out.println(Class.forName("java.util.Date"));
//        System.out.println(date.getClass() == date1.getClass());
//    }
//}
