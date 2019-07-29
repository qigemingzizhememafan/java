package InnerClass_7_29;
// 定义一个外部类
//class Outter {
//    private String title = "i am class Outters title";
//    public String getTitle() {
//        return title;
//    }
//    public void fun() {
//        Inner inner = new Inner(this);
//        inner.print();
//    }
//}
    //        //*****************************************
//        // 在外部类的内部定义一个内部类
//        class Inner{
//            // 在内部类中定义一个方法
//            public void print(){
//                System.out.println(title);
//            }
//        }
        //*****************************************
    // 定义外部类的方法
//    public void fun(){
//        Inner inner = new Inner();
//        inner.print();
//    }
//class Inner{
//    private Outter out;
//    public Inner(Outter outter) {
//        this.out = outter;
//    }
//    public void print(){
//        System.out.println(out.getTitle());
//    }
//}

/*“多继承”*/
//class milk{
//    private String name = "milk的私有属性";
//    public String getName() { return name; }
//}
//class puremink{
//    private int price = 10;
//    public int getPrice() { return price; }
//}
//class Outter{
//    // *****************内部类***************
//    public class InnerClassMilk extends milk{
//        public String getName(){
//            return super.getName();
//        }
//    }
//    public class InnerClassPurMilk extends puremink{
//        public int getPrice(){
//            return super.getPrice();
//        }
//    }
//    // *****************内部类***************
//    // 外部方法
//    public String getName(){
//        InnerClassMilk innerClassMilk = new InnerClassMilk();
//        return innerClassMilk.getName();
//    }
//    public int getPrice(){
//        InnerClassPurMilk innerClassPurMilk = new InnerClassPurMilk();{
//            return innerClassPurMilk.getPrice();
//        }
//    }
//}
//public class Test {
//    public static void main(String[]  args) {
//        Outter outter = new Outter();
//        System.out.println(outter.getName());
//        System.out.println(outter.getPrice());
//    }
//}

// 外部类通过内部类引用访问内部类数据
//class Outter{
//    public void fun(){
//        Inner inner = new Inner();
//        inner.show();
//    }
//}
//class Inner{
//    public void show(){
//        System.out.println("i am inner class's method ");
//    }
//}

// 内部类直接访问外部类数据
//class Outter{
//    private String name;
//    private int age;
//    class Inner{
//        public Inner(){
//            Outter.this.name = "Outter's name ";
//            Outter.this.age = 20;
//        }
//        public void print(){
//            System.out.println(Outter.this.name);
//            System.out.println(Outter.this.age);
//        }
//    }
//}
//public class Test{
//    public static void
// main(String[] args) {
//        Outter.Inner inner = new Outter().new Inner();
//        inner.print();
//    }
//}

// 静态内部类
//class Outter{
//    private static int age =18;
//    private String name = "Hello";
//    static class Inner{
//        public void print(){
//            System.out.println(Outter.age);
//            System.out.println(Outter.name);
//        }
//    }
//}
// 方法内部类
//class Outter{
//    private  int num = 10;
//    public void test(int  num2){
//        class Inner{
//            public void fun(){
//                num += 20;
//                System.out.println(num);
//                // 对num2进行改变会报错
//                // 因为方法内部类接收外部参数必须是final的，不可修改的
//                System.out.println(num2);
//            }
//        }
//        new Inner().fun();
//    }
//}

// 匿名内部类
class MyInterface{
    void test() {
        System.out.println("MyInterface's test method ");
    }
}
class Outter{
    private int num = 10;
    public void test(int testNum){
        new MyInterface(){
            @Override
            void test() {
                System.out.println("i am no-name InnerClass");
                System.out.println(testNum);
            }
        }.test();
    }
}
public class Test{
    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.test(100);
    }
}