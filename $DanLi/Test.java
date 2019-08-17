package $DanLi;

/**
 * 饿汉单例，上来就new
 */

//class Singleton{
//    private static final Singleton singleton = new Singleton();
//
//    private Singleton(){ }
//
//    public void test(){
//        System.out.println(this);
//    }
//
//    public static Singleton getsingleton(){
//        return singleton;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Singleton singleton = Singleton.getsingleton();
//        Singleton singleton1 = Singleton.getsingleton();
//        singleton.test();
//        singleton1.test();
//        System.out.println(singleton == singleton1);
//    }
//}

/**
 * 懒汉单例，先判断singleton对象是否存在，不存在才会new
  */
//class Singleton{
//    // 这里不能是static final一起修饰Singleton，因为我们判断singleton为空后
//    // 要给singleton赋值，final修饰后就不能修改值了
//    private static Singleton singleton = new Singleton();
//
//    private Singleton(){}
//
//    public void test(){
//        System.out.println(this);
//    }
//
//    public static Singleton getSingleton(){
//        if(singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//        Singleton gsingleton = Singleton.getSingleton();
//        Singleton singleton = Singleton.getSingleton();
//        gsingleton.test();
//        singleton.test();
//        System.out.println(gsingleton == singleton);
//    }
//}


/**
 *  线程安全的单例模式
 */
class Singleton{
    private static Singleton singleton = new Singleton();
    private Singleton(){ }
    public void test(){
        System.out.println(this);
    }
    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
public class Test{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton == singleton1);
        singleton.test();
        singleton1.test();
    }
}