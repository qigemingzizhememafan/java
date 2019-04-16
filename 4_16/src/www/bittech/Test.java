package www.bittech;
// 双向链表
interface ILink{
    //链表增加节点内容
    boolean add(Object data);
    //判断指定内容节点在链表中是否存在
    int contains(Object data);
    //删除指定内容节点
    boolean remove(Object data);
    //根据制定下标修改节点的内容
    Object set(int index,Object newData);
    //根据指定下标返回节点内容
    Object get(int index);
    //链表清空
    void clear();
    //将链表转为数组
    Object[] toArray();
    //返回链表长度
    int size();
    //遍历链表
    void printLink();
}
//LinkImpl将Node类的动态挂载抽象出来
class LinkImpl implements ILink{
    private Node head;
    private  Node last;
    private int size;
    //真正的火车车厢，负责数据存储
    //内部类，外部不可见，且接口使用起来方便，无需set、get方法
    private class Node{
        private Node prev;
        private Object data;
        private Node next;
        //构造方法快捷键alt+insert
        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    @Override//覆写方法Ctrl+O
    public boolean add(Object data) {
        Node temp = this.last;
        Node newNode = new Node(temp,data,null);
        this.last = newNode;
        if(this.head == null){
            //将上一个节点的尾与当前节点的头连接
            this.head = newNode;
        }else{
            temp.next = newNode;//将上一个节点的头连在要插入节点的头部
        }
        this.size++;
        return true;
    }

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
        return -1;
    }
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

    @Override
    public Object set(int index, Object newData) {
        if(!isLinkIndex(index)){
            return null;
        }
        Node node = node(index);
        Object elementData = node.data;
        node.data = newData;
        return elementData;
    }

    @Override
    public Object get(int index) {
        if(!isLinkIndex(index)){
            return null;
        }
        return node(index).data;
    }

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

    @Override
    // 链表转为数组
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            result[i++] = temp.data;
        }
        return result;
    }

    @Override
    // 求大小
    public int size() {
        return this.size;
    }

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
public class Test {
    public static void main(String[] args) {
        ILink link = new LinkImpl();
        link.add("火车头");
        link.add("车厢1");
        link.add("车厢2");
        link.add("车厢尾");
        System.out.println(link.get(3));
        System.out.println(link.set(2,"bit"));
        System.out.println(link.remove("车厢二"));
        link.printLink();
    }
}