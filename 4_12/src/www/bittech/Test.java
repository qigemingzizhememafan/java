package www.bittech;
// 1.正确代码
//public class Test {
//    public static void main(String[] args) {
//        System.out.println("计算开始");
//        System.out.println("计算进行中 10/2 ="+10/2);
//        System.out.println("计算结束");
//    }
//}

// 2.异常代码
//public class Test{
//    public static void main(String[] args) {
//        System.out.println("计算开始");
//        System.out.println("计算进行中 10/0="+10/0);
//        System.out.println("计算结束");
//    }
//}

// 3. 处理异常
//public class Test{
//    public static void main(String[] args) {
//        System.out.println("计算开始");
//        try {
//            System.out.println("计算进行中 10/0=" + 10 / 0);
//        }catch (ArithmeticException e){
//            System.out.println("处理异常结束");
//        }
//        System.out.println("计算结束");
//    }
//}

// 4.取得异常完整信息
//public class Test{
//    public static void main(String[] args) {
//        System.out.println("计算开始");
//        try {
//            System.out.println("计算进行中 10/0=" + 10 / 0);
//        }catch (ArithmeticException e){
//            e.printStackTrace();
//        }
//        System.out.println("计算结束");
//    }
//}

// 5.finally
//public class Test{
//    public static void main(String[] args) {
//        System.out.println("计算开始");
//        try {
//            System.out.println("计算进行中 10/0=" + 10 / 0);
//        }catch (ArithmeticException e){
//            e.printStackTrace();
//        }finally {
//            System.out.println("无论是否产生异常都会执行");
//        }
//        System.out.println("计算结束");
//    }
//}

// 6.初始化参数进行运算
//public class Test{
//    public static void main(String[] args) {
//        System.out.println("计算开始");
//        try {
//            Integer x = Integer.parseInt(args[0]);
//            Integer y = Integer.parseInt(args[1]);
//            System.out.println("计算进行中 10/0=" + x / y);
//        }catch (ArithmeticException e){
//            e.printStackTrace();
//        }catch(NumberFormatException e){
//            e.printStackTrace();
//        }catch(ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//        }
//        finally {
//            System.out.println("无论是否产生异常都会执行");
//        }
//        System.out.println("计算结束");
//    }
//}

// throws处理异常
//public class Test{
//    public static void main(String[] args) {
//        try{
//            System.out.println(div(10,0));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    public static int div(int x, int y) throws Exception{
//        return x/y;
//    }
//}

// throws用于主方法
//public class Test{
//    public static void main(String[] args) throws Exception{
//        int result = div(10,0);
//    }
//    public static int div(int x,int y) throws Exception{
//        return x/y;
//    }
//}

// throw
//public class Test{
//    public static void main(String[] args) {
//        try{
//            throw new Exception("抛个异常玩玩");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}

public class Test{
    public static void main(String[] args) {
        String str = "100";
        int num = Integer.parseInt(str);
        System.out.println(num*2);
    }
}