package www.bittech;

import javax.xml.crypto.Data;
import javax.xml.soap.Node;

// 构造包装类
//class intDemon{
//    private int intValue;
//    //通过构造方法封装
//    public intDemon(int intDemon) {
//        this.intValue = intDemon;
//    }
//    // 取出封装中的内容
//    public int getIntDemon() {
//        return intValue;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        intDemon intDemon = new intDemon(10);
//        int result = intDemon.getIntDemon();
//        System.out.println(result);
//    }
//}
//拆装箱
//public class Test{
//    public static void main(String[] args) {
//        //手动装箱
//        Integer i = new Integer(10);
//        //手动拆箱
//        int result = i.intValue();
//        System.out.println(result+10);
//        // 自动装箱
//        Integer i1 = 20;
//        //自动拆箱
//        int result1 = i1+10;
//        System.out.println(result1);
//    }
//}
//拆装箱中"=="和"equals"问题
//public class Test{
//    public static void main(String[] args) {
//        Integer i1 = new Integer(10);
//        Integer i2 = 10;
//        System.out.println(i1 == i2); // false
//        System.out.println(i1.equals(i2)); // true
//    }
//}
//public class Test{
//    public static void main(String[] args){
//        String str = "123";
//        int i = Integer.parseInt(str); //将String类型变为int
//        System.out.println(i+10); //输出133,若为字符串则为12310
//        String str1 = "123.10";
//        double b = Double.parseDouble(str1); //将字符串类型变为double
//        System.out.println(str1+10);  //输出123.1010
//        System.out.println(b+10); //输出为133.1
//    }
//}
interface ILink{
    // 链表增加结点内容
    boolean add(Object data);
    // 判断指定内容在链表中是否存在
    int contains(Object data);
    // 删除指定内容节点
    boolean remove(Object data);
    // 根据指定下标修改结点的内容
    Object set(int index,Object data);
    // 根据指定下标返回节点内容
    Object get(int index);
    // 链表清空
    void clear();
    // 将链表转为数组
    Object[] toArray();
    // 返回链表长度
    int size();
    // 遍历链表
    void printLink();
}
class Linkimpl implements ILink{
    private Node head;
    private Node last;
    private int size;
    // 内部类，外部不可见，方便接口使用
    private class Node{
        private Node prev;
        private Object data;
        private Node next;
        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    // 向链表增加内容
    @Override
    public boolean add(Object data) {
        Node temp = this.last;
        Node newNode = new Node(temp,data,null);
        this.last = newNode;
        if(this.head == null){
            this.head = newNode;
        }else{
            temp.next = newNode;
        }
        this.size++;
        return true;
    }
    // 判断指定内容在链表中是否存在
    @Override
    public int contains(Object data) {

        if(data == null){
            int i = 0;
            for(Node temp = this.head; temp != null; temp = temp.next){
                if(temp.data == null){
                    return i;
                }
                i++;
            }
        }else {
            int i = 0;
            for(Node temp = this.head; temp != null; temp = temp.next){
                if(temp.data.equals(data) ){
                    return i;
                }
                i++;
            }
        }
        return -1;    }
    // 删除指定内容节点
    @Override
    public boolean remove(Object data) {
        if(data == null){
            for(Node temp = this.head; temp!= null; temp = temp.next){
                if(temp.data == null){
                    unLink(temp);
                    return true;
                }
            }
        }else{
            for(Node temp = this.head; temp!= null; temp = temp.next){
                if(temp.data == null){
                    unLink(temp);
                    return true;
                }
            }
        }
        return false;
    }
    // 根据指定下标修改结点的内容
    @Override
    public Object set(int index, Object data) {
        if(!isLinkIndex(index)){
            return null;
        }
        Node node = node(index);
        Object elementData = node.data;
        node.data = new Data;
        return elementData;
    }
    // 根据指定下标返回节点内容
    @Override
    public Object get(int index) {
        if(!isLinkIndex(index)){
            return null;
        }
        return node(index).data;
    }
    // 链表清空
    @Override
    public void clear() {
        for (Node temp = head; temp!=null; ){
            temp.data = null;
            Node node = temp.next;
            temp = temp.prev = temp.next = null;
            temp = node;
            this.size--;
        }
    }
    // 将链表转为数组
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            result[i++] = temp.data;
        }
        return result;
    }
    // 返回链表长度
    @Override
    public int size() {
        return this.size;
    }
    // 遍历链表
    @Override
    public void printLink() {
        Object[] data = this.toArray();
        for(Object temp:data){
            System.out.println(temp);
        }
    }
    //仅供本类方法使用
    private Node node(int index){
        if(index < (size>>1)){//小于中间节点从前往后查找
            Node temp = this.head;
            for(int i = 0; i<index; i++){
                temp = temp.next;
            }
            return temp;
        }
        Node temp = this.last;
        for(int i = size-1; i>index; i--){
            temp = temp.prev;
        }
        return temp;
    }
    //判断指定索引是否合法
    private boolean isLinkIndex(int index){
        return index>=0 && index<size;
    }
    //删除节点
    private Object unLink(Node x){
        Object elementData = x.data;
        Node prev = x.prev;
        Node next = x.next;
        //先判断是否为头
        if(prev == null){
            this.head = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        //再判断是否为尾
        if(next == null){
            this.last = prev;
        }else{
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        this.size--;
        return elementData;
    }
}
}
public class Test{
    public static void main(String[] args) {

    }
}