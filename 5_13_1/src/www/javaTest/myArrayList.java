package www.javaTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class MyArray{
     private int size;
     private Object[] objData;
    private static final int Cap = 10;

     public MyArray(){
         objData = new Object[Cap];
     }
     // 初始化数组
     public MyArray(int cap){
         if(cap < 0){
             throw new RuntimeException();
         }else if(cap == 0){
             objData = new Object[Cap];
         }else{
             objData = new Object[cap];
         }
     }
     // add()方法
    public void add(Object obj){
         // 扩容
        if(size == objData.length){
            Object[] newobjDate = new Object[objData.length+(objData.length>>1)];
            System.arraycopy(objData,0,newobjDate,0,objData.length);
            // 声明
            objData = newobjDate;
        }
        // 正常添加流程
        objData[size++] = obj;
    }

    // get()方法
    public Object get(int index){
         checkRange(index);
        return objData[index];
    }

    // set()方法
    public void set(Object obj,int index){
         checkRange(index);
         objData[index] = obj;
    }

    // 根据指定下标移除元素
    public void remove(int index){
         checkRange(index);
         int nummoved = objData.length-index-1;
         System.arraycopy(objData,index+1,objData,index,nummoved);
    }

    // 根据指定内容，移除元素
    public void remove(Object obj){
         for(int i = 0;i < objData.length;i++){
             if(objData[i].equals(obj)){
                 remove(i);
             }
         }
    }

    // 检查下标
    public void checkRange(int index){
         if(index < 0 || index > objData.length){
             throw new RuntimeException("输入索引不满足条件"+index);
         }
     }

    public String toString() {
        StringBuilder  sb = new StringBuilder();
        //[a,b,c]
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(objData[i]+",");
        }
        sb.setCharAt(sb.length()-1, ']');
        return  sb.toString();
    }
}
public class myArrayList {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.add("a");
        myArray.add("b");
        myArray.add("c");
        System.out.println(myArray.get(0));
        System.out.println(myArray.get(1));
        System.out.println(myArray.get(2));
//        myArray.remove(1);
//        System.out.println(myArray);
//        myArray.set("F",1);
//        System.out.println(myArray);
    }
}
