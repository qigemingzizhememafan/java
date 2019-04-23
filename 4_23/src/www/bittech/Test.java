package www.bittech;
// 饿汉式单例模式
//class Singleton{
//    private static final Singleton singleton = new Singleton();
//    private Singleton(){}
//    public static Singleton getSingleton() {
//        return singleton;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Singleton singleton = Singleton.getSingleton();
//        Singleton singleton1 = Singleton.getSingleton();
//        System.out.println(singleton==singleton1);
//    }
//}

// 懒汉式单例
//class Singleton{
//    private static  Singleton singleton;
//    private Singleton(){
//    }
//    public void test(){
//        System.out.println(this);
//    }
//    public static Singleton getSingleton(){
//        // 用时再new
//        if(singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Singleton singleton1 = Singleton.getSingleton();
//        Singleton singleton2 = Singleton.getSingleton();
//        Singleton singleton3 = Singleton.getSingleton();
//        singleton1.test();
//        singleton2.test();
//        singleton3.test();
//    }
//}

// 多例模式
//class Sex{
//    private String title;
//    public static final int MALE_FLAG = 1;
//    public static final int FEMALE_FLAG = 2;
//    private static final Sex MALE = new Sex("男");
//    private static final Sex FEMALE = new Sex( "女");
//    private Sex(String title){
//        this.title = title;
//    }
//    public static Sex getInstance(int flag){
//        switch (flag){
//            case MALE_FLAG:
//                return MALE;
//            case FEMALE_FLAG:
//                return FEMALE;
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
//
//public class Test{
//    public static void main(String[] args){
//        Sex male = Sex.getInstance(Sex.MALE_FLAG);
//        Sex female = Sex.getInstance(Sex.FEMLE_FLAG);
//        System.out.println(male);
//        System.out.println(female);
//    }
//}

//public class Test{
//    public static boolean Find(int[][] arr, int x, int y, int val){
//        while(arr != null && x > 0 && y > 0){
//            if(arr[x][y] == val){
//                return true;
//            }else if(arr[x][y] > val){
//                y--;
//            }else if(arr[x][y] < val){
//                x++;
//            }
//            return false;
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int x = 3;
//        int y = 3;
//        System.out.println(Find(arr,3,3,5));
//        //return(Find(arr,x,y,5));
//    }
//}

//interface IUtil<P,R>{
//    R switchPara(P p); //将P类型转为R类型
//}
//public class Test{
//    public static void main(String[] args) {
//        IUtil<Integer,String> util = String ::valueOf; //引用String类的valueof方法
//        //相当于调用String.valueOf(10)
//        String str = util.switchPara(10);
//        System.out.println(str.startsWith("1"));//可以调用String类的方法证明确实被转成String了
//    }
//}

//interface IUtil<R>{
//    R switchPara();
//}
//public class Test{
//    public static void main(String[] args) {
//        IUtil<String> util = "hello" :: toUpperCase; //”hello“是String类的实例化对象，转成大写
//        //相当于调用了"hello".toUpperCase();
//        System.out.println(util.switchPara());
//    }
//}

//interface IUtil<R,P>{
//    R compare(P p1,P p2); //输入P类型的两个参数，返回R类型
//}
//public class Test{
//    public static void main(String[] args) {
//        IUtil<Integer,String> util = String::compareTo;
//        System.out.println(util.compare("刘","杨"));
//    }
//}

//class Person{
//    private String name;
//    private Integer age;
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//}
//interface  IUtil<R,PN,PR>{
//    R createPer(PN p1,PR p2);
//}
//public class Test{
//    public static void main(String[] args) {
//        IUtil<Person,String,Integer> util = Person::new;
//        //相当于调用Person p = new Person();
//        System.out.println(util.createPer("张三",20));
//    }
//}

//@FunctionalInterface
//interface Add{
//    int add(int x,int y); //有返回值类型
//}
//public class Test{
//    public static void main(String[] args) {
//        Add add = (p1,p2) -> {
//            int result = p1+p2;
//            result += 20;
//            return result;
//        };
//        System.out.println(add.add(10,20));
//    }
//}