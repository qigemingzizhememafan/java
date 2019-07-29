package classAndInterface;

import java.util.Arrays;
class Person{
    private String name = "name";
}
class Student extends Person{
    public String name = "student";
}
public class Test{
    public static void main(String[] args){
        String s = "ABCDEF";
        System.out.println(s.substring(0,3));
//        System.out.println(new Student().name);  //输出为student
    }
}
//class Person{
//    public void test(){
//        this.fun();
//    }
//    private void fun(){  //输出为我是爸爸，若将private改成public则是儿子
//        System.out.println("我是爸爸");
//    }
//}
//class Student extends Person{
//    public void fun(){
//        System.out.println("我是儿子");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        new Student().test();
//    }
//}
//class Person{
//    private int age;
//    private String name;
//    public void getInfo(){
//        System.out.println("年龄为:"+age+"姓名"+name);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Person person = new Person();
//        int a = 20;
//        {
//            a = 10;
//        }
//        System.out.println(a);
//        int[] data = {132, 332, 24, 523};
//        char[] data1 = new char[]{'a', 't', 'r', 'c'};
//        Arrays.sort(data);
//        Arrays.sort(data1);
//        System.out.println();
//        for(char b:data1){
//            System.out.print(b+"、");
//        }
//        int[] data3 = {4,7,1,14,745,235525,852,14};
//        System.arraycopy(data,2,data3,0,2);
//        int[] data4 = Arrays.copyOf(data3,4);
//        for(int a:data4){
//            System.out.print(a+"、");
//        }
//    }
//    }
//}
