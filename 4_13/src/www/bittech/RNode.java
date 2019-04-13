package www.bittech;

public class RNode {
    Object val;
    RNode next;
    RNode random;
    RNode(Object val){}
    public static RNode CopyRandomList(RNode head){
        // 第一步：连在一起
        RNode cur = head;
        while(cur != null){
        RNode newNode = new RNode(cur.val);
        newNode.next = cur.next;
        cur.next = newNode;
        cur = cur.next.next;
    }
        // 第二步：把random连在一起
        cur = head;
        while(cur != null) {
            RNode newNode = cur.next;
            if (cur.random != null) {
                newNode.random = cur.random.next;
            }else{
                newNode.random = null;
            }
            cur = cur.next.next;
        }
        // 第三步：拆
        cur = head;
        RNode result = cur.next;
        while(cur != null){
            RNode newNode = cur.next;
            cur.next = newNode.next;
            if(newNode.next != null){
                newNode.next = newNode.next.next;
            }
        }
        return result;
        }
}

