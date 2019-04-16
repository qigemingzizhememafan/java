package www.bittech;

//    private class Node {
//        public int value;
//        public Node next;
//
//        Node(int v) {
//            this.value = v;
//        }
//    }
//
//    // 链表的第一个结点
//    private Node head;
//
//    public void addFirst(int v) {
//        Node node = new Node(v);
//        node.next = this.head;
//        this.head = node;
//    }
//
//    public void addLast(int v) {
//        Node node = new Node(v);
//        node.next = null;
//        if (this.head == null) {
//            this.head = node;
//        } else {
//            Node last = this.head;
//            while (last.next != null) {
//                last = last.next;
//            }
//            last.next = node;
//        }
//    }
//
//    boolean addIndex(int index, int v) {
//        Node node = new Node(v);
//        if (index == 0) {
//            node.next = this.head;
//            this.head = node;
//        } else {
//            Node cur = this.head;
//            for (int i = 0; cur != null && i < index - 1; i++) {
//                cur = cur.next;
//            }
//
//            if (cur == null) {
//                return false;
//            }
//
//            node.next = cur.next;
//            cur.next = node;
//        }
//
//        return true;
//    }
//
//    public boolean contains(int v) {
//        for (Node c = this.head; c != null; c = c.next) {
//            if (c.value == v) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public void remove(int v) {
//        if (this.head == null) {
//        } else if (this.head.value == v) {
//            this.head = this.head.next;
//        } else {
//            Node prev = this.head;
//            while (prev.next != null) {
//                if (prev.next.value == v) {
//                    prev.next = prev.next.next;
//                }
//            }
//        }
//    }



//    private int[] array;
//    int top;
//
//    MyStack() {
//        this.array = new int[100];
//        this.top = 0;
//    }
//
//    /**
//     * 压入一个数据，插入一个数据
//     * 压栈
//     * @param v
//     */
//    public void push(int v) {
//        this.array[this.top++] = v;
//    }
//
//    /**
//     * 弹栈，出栈
//     * @return 栈顶元素
//     */
//    public int pop() {
//        return this.array[--this.top];
//    }
//
//    /**
//     * 查看栈顶元素
//     * @return 栈顶元素
//     */
//    public int peek() {
//        return this.array[this.top - 1];
//    }
//
//    public int size() {
//        return this.top;
//    }
//
//    public boolean isEmpty() {
//        return this.top == 0;
//    }


//    private class Node {
//        int value;
//        Node next;
//    }
//
//    Node head;
//    Node last;
//
//    Queue() {
//        this.head = this.last = null;
//    }
//
//    /**
//     * 把数据插入到队尾
//     * @param v
//     */
//    public void push(int v) {
//        Node node = new Node();
//        node.value = v;
//        node.next = null;
//        if (this.head == null) {
//            this.head = this.last = node;
//        } else {
//            this.last.next = this.last = node;
//        }
//    }
//
//    /**
//     * 出队列
//     * @return
//     */
//    public int pop() {
//        int v = this.head.value;
//        this.head = this.head.next;
//        if (this.head == null) {
//            this.last = null;
//        }
//        return v;
//    }
//
//    /**
//     * 返回队首元素
//     * @return
//     */
//    public int front() {
//        return this.head.value;
//    }
//
//    public int size() {
//        return 0;
//    }
//
//    public boolean isEmpty() {
//        return this.head == null;
//    }


//    private static class Node {
//        public int value;
//        public Node next;
//
//        Node(int v) {
//            this.value = v;
//        }
//    }
//
//    private static class RNode {
//        public int value;
//        public RNode random;
//        public RNode next;
//
//        RNode(int v) {
//            this.value = v;
//        }
//    }
//
//    private static Node deleteDuplicate(Node head) {
//        if (head == null) {
//            return null;
//        }
//        Node prev = null;
//        Node p1 = head;
//        Node p2 = head.next;
//
//        while (p2 != null) {
//            if (p1.value != p2.value) {
//                prev = p1;
//                p1 = p1.next;
//                p2 = p2.next;
//            } else {
//                while (p2 != null && p2.value == p1.value) {
//                    p2 = p2.next;
//                }
//                // [p1, p2) 是重复的
//                if (p1 == head) {
//                    head = p2;
//                } else {
//                    prev.next = p2;
//                }
//
//                p1 = p2;
//                if (p2 != null) {
//                    p2 = p2.next;
//                }
//            }
//        }
//
//        return head;
//    }
//
//    private static void display(Node head) {
//        for (Node n = head; n != null; n = n.next) {
//            System.out.format("%d --> ", n.value);
//        }
//        System.out.println("null");
//    }
//
//    private static void test1() {
//        Node n1 = new Node(3);
//        Node n2 = new Node(3);
//        Node n3 = new Node(3);
//        Node n4 = new Node(3);
//        Node n5 = new Node(3);
//        Node n6 = new Node(4);
//
//        n1.next = n2; n2.next = n3; n3.next = n4;
//        n4.next = n5; n5.next = n6; n6.next = null;
//
//        display(n1);
//        Node r = deleteDuplicate(n1);
//        display(r);
//    }
//
//    private static RNode copyRandomList(RNode head) {
//        if (head == null) {
//            return null;
//        }
//        /**
//         * 1. 创建新结点插到老结点后边
//         * 2. 设置 random
//         * 3. 拆开
//         */
//        RNode cur = head;
//        while (cur != null) {
//            RNode n = new RNode(cur.value);
//            n.next = cur.next;
//            cur.next = n;
//            cur = cur.next.next;
//        }
//
//        cur = head;
//        while (cur != null) {
//            if (cur.random != null) {
//                cur.next.random = cur.random.next;
//            } else {
//                cur.next.random = null;
//            }
//
//            cur = cur.next.next;
//        }
//
//        cur = head;
//        RNode rhead = head.next;
//        while (cur != null) {
//            RNode n = cur.next;
//            cur.next = n.next;
//            if (n.next != null) {
//                n.next = n.next.next;
//            }
//
//            cur = cur.next;
//        }
//
//        return rhead;
//    }
//
//    private static void test2() {
//        RNode n1 = new RNode(1);
//        RNode n2 = new RNode(2);
//        RNode n3 = new RNode(3);
//        RNode n4 = new RNode(4);
//
//        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = null;
//        n1.random = n2; n2.random = n4; n3.random = n1; n4.random = null;
//
//        RNode rn1 = copyRandomList(n1);
//
//        System.out.println("hello world");
//    }
//
//    public static void main(String[] args) {
//        test2();
//    }

