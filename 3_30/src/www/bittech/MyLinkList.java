package www.bittech;

public class MyLinkList {
    Node head = new Node(" e");
    public static void main(String[] args) {

    }
    class Node{
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    //找最后一个
    public Node getLastNode(){
        head = this.head;
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        return cur;
    }
    //找倒数第二个
    public Node getBeforLast(){
        head = this.head;
        Node cur = head;
        while(cur.next.next != null){
            cur = cur.next;
        }
        return cur;
    }
    //头插
    public void pushFront(Node node){
        node.next = this.head;
        this.head = node;
    }
    //尾插
    public void pushBack(Node node){
        if(this.head == null){
            this.head = node;
        }
        Node last = getLastNode();
        last.next = node;
        node.next = null;
    }
    //头删
    public void popFront(){
        if(head == null){
            throw new Error();
        }
        this.head = this.head.next;
    }
    //尾删
    public void popBack(){
        if(this.head == null){
            throw new Error();
        }
        Node beforLast = getBeforLast();
        beforLast.next = null;
    }
}
