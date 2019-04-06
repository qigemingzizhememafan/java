package www.bittech;

import java.io.*;
//public class Test{
//    public static void main(String[] args) {
//        // 1. 取得终端对象
//        File file = new File("C:\\Users\\Administrator\\Desktop\\Test.txt");
//        if(!(file.exists())){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //2. 取得文件输出流
//        try {
//            OutputStream out = new FileOutputStream(file);
//            //3. 写入数据
//            String msg = "HongKongWang";
//            try {
//                out.write(msg.getBytes());
//                //4. 关闭流
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
//class MSG implements AutoCloseable{
//    public void print(){
//        System.out.println("普通方法");
//    }
//    @Override
//    public void close() throws Exception {
//        System.out.println("aotu方法");
//    }
//}
//public class Test{
//    public static void main(String[] args) {
//
//        try ( MSG msg = new MSG()){
//            msg.print();
//        }catch (Exception e){
//
//        }
//    }
//}
public class Test{
    public static void main(String[] args) {
        File file = new File("C://Users//Bean//Desktop//Test.txt")
    }
}