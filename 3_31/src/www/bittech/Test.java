package www.bittech;
import java.util.ArrayList;
import java.util.List;
/*
*  OOM
*  -Xms20M  -Xmx20M 最大最小相同即不允许扩容
*  点击上方run -> edit -> configuration -> VM options
*/
//class OOMTest{
//
//}
/*
*  -XX:+PrintGC 打印日志的一个参数，同-XSS那样配置
* */
public class Test{
    private Object instance;
    private static int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];
    public static void main(String[] args) {
        // +1
        Test test1 = new Test();
        Test test2 = new Test();
         // 循环引用
        test1.instance = test2; //test1里面有东西指向test2
        // +1
        test2.instance = test1; //你中有我，我中有你，即循环引用
         // -1
      //   test1 = test2 = null;
         System.gc();
    }
}

//    public void stackTest(){
//        length++;  //设置-Xss为128K
//        stackTest();
//    }
//    public static void main(String[] args) {
//        Test test = new Test();
//        try{
//            test.stackTest();
//        }catch (Throwable e){
//            e.printStackTrace();
//            System.out.println("栈深度为+"+test.length);
//        }
//    }
//}
//        List<OOMTest> list = new ArrayList<>();
//        while(true){
//            list.add(new OOMTest());
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        String value = "emp.name:张三|emp.job:Linux Coder";
//        EMPAction empAction = new EMPAction();
//        empAction.setValue(value);
//        System.out.println(empAction.getEmp());
//    }
//}
