package www.bittech;
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
 }
 //************************直接逆序链表***********************************************************
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         // 创建结果链表
//         ListNode result = null;
//         ListNode cur = head;
//         while(cur != null){
//             // 保存下一个结点
//             ListNode next = cur.next;
//             // 头插
//             cur.next = result;
//             result = cur;
//             //向后移动
//             cur = next;
//         }
//         return result;
//     }
// }

//三指针逆序链表
//class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while(cur != null){
//            // 保存下一个结点，因为cur和cur.next之间要断了
//            ListNode next = cur.next;
//            // 将链表的指向换了方向
//            cur.next = pre;
//            // 向后移动
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }
//}

//*****************移除链表中指定元素**************************************************************
//class Solution {
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode result = null; //结果链表
//        ListNode last = null; //记录结果链表的最后一个结点
//        ListNode cur = head;
//        while(cur != null){
//            ListNode next = cur.next;
//            if(cur.val != val){
//                //把cur尾插到result链表上
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

//*****************************链表的中间结点****************************************************
//直接求解中间结点
//class Solution {
//    public ListNode middleNode(ListNode head) {
//        int half = (getCount(head))/2;
//        half为移动的次数，中间元素所在的位置为half+1
//        for(int i = 0; i <half; i++){
//            head = head.next;
//        }
//        return head;
//    }
//    // 取得链表长度
//    public static int getCount(ListNode head){
//        ListNode cur = head;
//        int count = 0;
//        while(cur != null){
//            count++;
//            cur = cur.next;
//        }
//        return count;
//    }
//}
// 快慢指针
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

