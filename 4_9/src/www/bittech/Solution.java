package www.bittech;

//**************************链表中倒数第K个结点**************************************************
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode front = head;
        ListNode back = head;
        int i;
        for (i = 0; front != null && i < k; i++) {
            front = front.next;
        }

        if (front == null && i < k) {
            // k 大于 结点个数
            return null;
        } else if (front == null) {
            return head;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        return back;
    }
}
