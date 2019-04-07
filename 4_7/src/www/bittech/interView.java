package www.bittech;

//**********************返回链表倒数第K个值********************************************
//public class Solution {
//    public ListNode FindKthToTail(ListNode head,int k) {
//        ListNode front = head;
//        ListNode back = head;
//        int i;
//        for (i = 0; front != null && i < k; i++) {
//            front = front.next;
//        }
//        if (front == null && i < k) {
//            // k 大于 结点个数
//            return null;
//        } else if (front == null) {
//            return head;
//        }
//        while (front != null) {
//            front = front.next;
//            back = back.next;
//        }
//        return back;
//    }
//}
//**********************返回链表的中间结点*********************************************
//public class ListNode {
// int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }
// //利用快慢指针求
//class Solution {
//    public ListNode middleNode(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while(fast != null && fast.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//}
// ***************************三引用法逆序链表*******************************************
//public class interView {
//    public static class ListNode {
//      int val;
//      ListNode cur;
//      ListNode next;
//      ListNode(int x) { val = x; }
// }
//
//    public static class Solution {
//        public ListNode reverseList(ListNode head) {
//            ListNode pre = null;
//            ListNode cur = head;
//            ListNode next ;
//            while(cur != null){
//                next = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = next;
//            }
//            return pre;
//        }
//    }
//    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(6);
//        ListNode n4 = new ListNode(3);
//        ListNode n5 = new ListNode(4);
//        ListNode n6 = new ListNode(5);
//        ListNode n7 = new ListNode(6);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = null;
//        Solution solution = new Solution();
//        ListNode cur = pre;
//        while(cur != null){
//            System.out.println(cur.val);
//            cur = cur.next;
//        }
//    }
//}
//*****************删除链表中指定元素*****************************************************
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
//    private static class Solution {
//    }
//
//}

//        public ListNode removeElements(ListNode head, int val) {
//            ListNode result = null; //结果链表
//            ListNode last = null; //记录结果链表的最后一个结点
//            ListNode cur = head;
////          1. 用cur.next判断是否与指定值相等
//            while(cur.next != null){
//                if(cur.next.val != val){
//                    cur = cur.next;
//                }else{
//                    cur.next = cur.next.next;
//                }
//            }
//            // 需要单独判断第一个
//            if(head.val == val){
//                return  head.next;
//            }else{
//                return head;
//            }
//            2.用cur判断是否与指定值相等
//            while (cur != null) {
//                ListNode next = cur.next;
//                if (cur.val != val) {
//                    //把cur尾插到result链表上
//                    cur.next = null;
//                    if (result == null) {
//                        result = cur;
//                    } else {
//                        last.next = cur;
//                    }
//                    last = cur;
//                }
//                cur = next;
//            }
//            return result;
//        }
//    }
