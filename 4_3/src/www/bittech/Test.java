package www.bittech;
// 1.String类的两种实例化方式
//public class Test {
//    public static void main(String[] args) {
//        //直接赋值，在堆上分配空间
//        String str = "hello";
//        System.out.println(str);
//        //通过构造方法实例化对象
//        String str1 = new String("helloo");
//        System.out.println(str1);
//    }
//}


//字符串相等比较
//public class Test{
//    public static void main(String[] args) {
//        int i1 = 10;
//        int i2 = 10;
//        String str = "hello";
//        String str1 = "hello";
//        String str2 = new String("hello");
//        System.out.println(i1 == i2);       // true
//        System.out.println(str == str1);    // true
//        System.out.println(str == str2);    // false
//        System.out.println(str.equals(str2));// true
//    }
//}

// 3. String的匿名对象
//public class Test{
//    public static void main(String[] args) {
//        String str = null;
//        System.out.println("hello".equals(str));  //false
//        // System.out.println(str.equals("hello"));NullPointerException
//    }
//}

//4. 对象入池
public class Test{
    public static void main(String[] args) {
        String str = "hello";
        String str1 = new String("hello").intern();
        System.out.println(str.equals(str1));
    }
}