package www.bittech;

public class ListNode {
    ListNode next;
    int val;
    // 删除重复
    public static ListNode deleteDuplicate(ListNode head){
        ListNode cur = head;
        ListNode result = head;
        ListNode dummy = null;
        dummy.next = cur;
        ListNode next = cur.next;
        // cur与next不相等，全体后移
        while(next != null){
            if(cur.val != next.val){
                dummy = dummy.next;
                cur = cur.next;
                next = next.next;
            // cur与next相等，判断next的后一个与cur是否相等
            }else{
                while(next != null && cur.val == next.val){
                    next = next.next;
                }
                dummy = next.next;
                cur = dummy;
            }
        }
        return result;
    }
}
