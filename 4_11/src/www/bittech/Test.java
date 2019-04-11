package www.bittech;
//************************************************************************合并有序链表
//class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null){
//            return l2;
//        }
//        if(l2 == null){
//            return l1;
//        }
//        ListNode cur1 = l1;
//        ListNode cur2 = l2;
//        ListNode result = null;
//        ListNode last = null;
//        while( cur1 != null && cur2 != null){
//            if(cur1.val <= cur2.val){
//                ListNode next = cur1.next;
//                cur1.next = null;
//                if(result == null){
//                    result = cur1;
//                }else{
//                    last.next = cur1;
//                }
//                last = cur1;
//                cur1 = next;
//            }else{
//                ListNode next = cur2.next;
//                cur2.next = null;
//                if(result == null){
//                    result = cur2;
//                }else{
//                    last.next = cur2;
//                }
//                last = cur2;
//                cur2 = next;
//            }
//        }
//        if(cur1 != null){
//            last.next = cur1;
//        }
//        if( cur2 != null){
//            last.next = cur2;
//        }
//        return result;
//    }
//}
// *****************************************************************************移除链表元素
//class Solution {
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode cur = head;
//        ListNode result = null;
//        ListNode last = null;
//        while(cur != null){
//            ListNode next = cur.next;
//            if(cur.val != val){
//                cur.next = null;
//                if(result == null){
//                    result = cur;
//                }else{
//                    last.next = cur;
//                }
//                last = cur;
//            }
//            cur = next;
//        }
//        return result;
//    }
//}


