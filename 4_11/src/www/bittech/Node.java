package www.bittech;

public class Node {
    Node next;
    int val;

    //逆序一个链表
    public Node Reverse(Node head) {
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //合并两个有序链表
    public Node Merge(Node listA, Node listB) {
        Node cur1 = listA;
        Node cur2 = listB;
        Node result = null;
        Node last = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                //把cur1尾插到result
                if (result == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;
            }
            cur1 = cur1.next;
            if (cur1.val > cur2.val) {
                //把cur2尾插到result
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
            }
            cur2 = cur2.next;
        }
        /****
         *  todo 有一个为空了，另外一个接在last
         ***/
        return result;
    }
}
/**************************************************判断链表是否交叉，交叉了的话找出交叉*/



