package www.bittech;

//class MyArrayList{
//    private int[] array; // 存储数据的实际空间
//    private int size;    // 实际存储与的空间
//    public void pushFront(int value){
//        //头插
//        if(size < array.length) {
//            for (int i = size - 1; i >= 0; i--) {
//                array[i + 1] = array[i];
//            }
//            array[0] = value;
//            size ++;
////            for(int i = 0; i < size ;i++){
////                array[size-i] = array[size-i-1];
////            }
//        }
//        // 扩容
//        else if(size == array.length){
//            int[] data = new int[size*2];
//            for(int i = 0; i < array.length; i++){
//                data[i] = array[i];
//            }
//        }
//    }
//}
//ListNode small = null;
//        ListNode smallLast = null;
//        ListNode big = null;
//        ListNode bigLast = null;
//        ListNode cur = pHead;
//        ListNode result = null;
//        while( cur != null){
//        //小于x，尾插到small，大于x，尾插到big
//        // cur = cur.next;
//        ListNode last = cur.next;
//        if(cur.value < x){
//        cur.next = null;
//        if(small == null){
//        //cur.next = small;
//        small = cur;
//        //small = cur;  // cur.next = small
//        }else{
//        smallLast.next = cur;
//        }
//        //	cur = cur.next;
//        smallLast = cur;
//        }
//        if(cur.value >= x){
//        cur.next = null;
//        if(big = null){
//        big = cur;
//        }else{
//        bigLast.next = cur;
//        }
//        //	cur = cur.next;
//        bigLast = cur;
//        }
//        }
//        if(small == null){
//        return big;
//        }else{
//        smallLast.next = big;
//        return small;
//        }
//ListNode mergeTwoLista(ListNode 11,ListNode 12){
//        LinkNode cur1 = ListNode 11;
//        LinkNode cur2 = ListNode 12;
//        LinkNode result = null;
//        LinkNode last = null;
//        while(cur1 != null && cur2 != null){
//        if(cur1.value <= cur2.value){
//        // 尾插
//        if(result == null){
//        result = cur1;
//        }else(){
//        last.next = cur1;
//        }
//        //更新最后一个
//        last = cur1;
//        // cur1++
//        cur1 = cur1.next;
//        }else(cur1.value > cur2.value){
//        //尾插
//        /*
//         * Todo
//         */
//        cur2 = cur2.next;
//        }
//        }
//        if(cur1 == null ){
//        result = cur2;
//        }
//        if(cur2 == null){
//        result = cur1;
//        }
////        }
//class Person{}
//class Student{}
//public class Test{
//    public static void main(String[] args) {
//        fun(new Person());
//        fun(new Student());
//    }
//    public static void fun(Object obj){
//        System.out.println(obj);
//    }
//}
//class Person{
//    private String name;
//    private int age;
//    public Person(String name, int age) {
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
//        Person person = new Person("张三",18);
//        fun(person);
//    }
//    public static void fun(Object obj){
//        System.out.println(obj.toString());
//        System.out.println(obj); // 默认覆写了toString
//    }
//}
//class Person{
//    private String name;
//    private int age;
//    public Person(String name, int age) {
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
//    public boolean equals(Object obj) {
//        if(obj == null){
//            return false;
//        }
//        if(this == obj){
//            return true;
//        }
//        if(!(obj instanceof Person)){ //不是Person类对象
//            return true;
//        }
//        //向下转型，取得Person类的name和age属性
//        Person per = (Person) obj;
//        return per.name.equals(this.name) && (per.age == this.age);
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Person per1 = new Person("张三",18);
//        Person per2 = new Person("张三",19);
//        Person per3 = new Person("李四",18);
//        Person per4 = new Person("张三",18);
//        System.out.println(per1.equals(per2));
//        System.out.println(per1.equals(per3));
//        System.out.println(per1.equals(per4));
//    }
//}
//
interface IMessage{
    public void getMessage();
}
class MessageImpl implements IMessage{
    public void fun(){
        System.out.println("hello world");
    }
    @Override
    public void getMessage() {
        System.out.println("hello java");
    }
}
public class Test{
    public static void main(String[] args) {
        IMessage msg = new MessageImpl(); //子类向父接口转型
        Object obj = msg; //接口向Object转型
        System.out.println(obj);
        IMessage temp = (IMessage) obj; //强制类型转换
        temp.getMessage();

    }
}