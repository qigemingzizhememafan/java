package www.bittech;
//enum Color{
//    RED,GREEN,BLUE;
//}
//public class Test {
//    public static void main(String[] args) {
//        Color color = Color.RED;
//        System.out.println(color.ordinal()+"="+color.name());
//        System.out.println(color);
//    }
//}

//用多例模式写上述代码
//class Color{
//    private String title;
//    public static final int RED_FLAG = 1;
//    public static final int GREEN_FLAG = 5;
//    public static final int BLUE_FLAG = 10;
//    private static final Color RED = new Color("红");
//    private static final Color GREEN = new Color("绿");
//    private static final Color BLUE = new Color("蓝");
//    private Color(String title){
//        this.title = title;
//    }
//    public static Color getInstance(int flag){
//        switch(flag){
//            case RED_FLAG:
//                return RED;
//            case GREEN_FLAG:
//                return GREEN;
//            case BLUE_FLAG:
//                return  BLUE;
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return this.title;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Color color = Color.getInstance(Color.RED_FLAG);
//        System.out.println(color);
//    }
//}

//取得枚举类的所有信息
//enum Color{
//    RED("红"),GREEN("绿"),BLUE("蓝");
//    private String title;//这句不能放在首行
//    private Color(String color){
//        this.title = title;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        for(Color color:Color.values()){
//            System.out.println(color);
//        }
//    }
//}

//枚举实现接口
//interface IColor{
//    String color();
//}
//enum Color implements  IColor{
//    RED("红"),GREEN("绿"),BLUE("蓝");
//    private String title;
//    private Color(String title){
//        this.title = title;
//    }
//
//    @Override
//    public String toString() {
//        return this.title;
//    }
//    public String color(){
//        return this.name();
//    }
//}
//public  class Test{
//    public static void main(String[] args) {
//        for(Color color : Color.values()){
//            System.out.println(color);
//        }
//        IColor color = Color.RED; //枚举类对象，通过向上转型转型成color
//        System.out.println(color);
//        System.out.println(color.color());
//    }
//}

//class Person{
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//    private String name;
//    private Integer age; //构造方法，get、set方法太多，很麻烦
//    public String getName() {
//        return name;
//    } //用注解可以不用写上述很多的方法
//    public void setName(String name) {
//        this.name = name;
//    }
//    public Integer getAge() {
//        return age;
//    }
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//}

// @override覆写
//class Person{
////     //@Override  // 加上此注解后，会提示你覆写失败，让你检查错误
////    public String tostring(){ //此时编译没报错，但运
////        return "hello world"; // 行结果表明没有成功覆写toString方法
////    }
////}
////public class Test{
////    public static void main(String[] args) {
////        Person per = new Person();
////        System.out.println(per);
////    }
////}

//class Person{
//    private String name;
//    @Deprecated //过期注释，JDK更新，一些老方法不再推荐使用
//    public Person(){
//        System.out.println("******");
//    }
//    public Person(String name){
//        System.out.println(name+"******");
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Person per1 = new Person(); //过期方法，能用，但是不推荐使用
//        Person per2 = new Person("张三");
//    }
//}

//public class Test{
//    public static void main(String[] args) {
//        @SuppressWarnings({"rawtypes","unused" })
//        Person person = new Person(); //此时三个Person下都会出现黄色波浪线
//        // 第一个没说明Person类型，第二个没被使用，第三个没说明类型
//        //应改为Person<String> person = new Person<>();
//        //但也可以不改，在出错的上一行加上警告压制,就不会报错了
//        //@SuppressWarnings({"rawtypes","unused" })
//    }
//}