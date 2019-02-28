package www.bit.java;
public class Test{
    public static void main(String[] args){
        System.out.println("1.数学计算开始前...");
        try {
            System.out.println("2.数学计算中"+(10/5));
        } catch (ArithmeticException e) {
            System.out.println("出现异常，除数有误");
        }finally{
            System.out.println("4.finally代码块无论如何都会执行");
        }
        System.out.println("3.数学计算完成...");
    }
}


/*public class Test{
    public static void main(String[] args){
       diGui(10);
    }
    public static int diGui(int num){
        return diGui(num);
    }
}*/
/*//描述性别的类
class Sex{
    private String title;
    public static final int MALE_FLAG = 1;
    public static final int FEMALE_FLAG = 2;
    private static final Sex MALE = new Sex("男");
    private static final Sex FEMALE = new Sex( "女");
    private Sex(String title){
        this.title = title;
    }
    public static Sex getInstance(int flag){
        switch (flag){
            case MALE_FLAG:
                            return MALE;
            case FEMALE_FLAG:
                            return FEMALE;
            default:
                     return null;
        }
    }

    @Override
    public String toString() {
        return this.title;
    }
}

public class Test{
    public static void main(String[] args){
        Sex male = Sex.getInstance(Sex.MALE_FLAG);
        Sex female = Sex.getInstance(Sex.FEMALE_FLAG);
        System.out.println(male);
        System.out.println(female);
    }
}*/
 /*class Singleton{
        private static  Singleton singleton;
        private Singleton(){
        }
        public void test(){
            System.out.println(this);
        }
        public static Singleton getSingleton(){
            if(singleton == null){
                singleton = new Singleton();
            }
            return singleton;
        }
     }
public class Test {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        Singleton singleton3 = Singleton.getSingleton();
        singleton1.test();
        singleton2.test();
        singleton3.test();
    }
}*/
