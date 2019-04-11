package www.bittech;

//************************************************************以X为基准将链表分为两部分
//public class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//    public ListNode aparT(ListNode head, int val){
//        ListNode small = null;
//        ListNode smallLast = null;
//        ListNode big = null;
//        ListNode bigLast = null;
//        ListNode cur = head;
//        while(cur != null){
//            ListNode next = cur.next;
//            if(cur.val <= val){
//                cur.next = null;
//                //尾插到small
//                if(small == null){
//                    small = cur;
//                }else{
//                    smallLast.next = cur;
//                }
//                smallLast = cur;
//            }
//            cur = next;
//           if(cur.val > val){
//               cur.next = null;
//               //尾插到big
//               if(big == null){
//                   big = cur;
//               }else{
//                   bigLast.next = cur;
//               }
//               bigLast = cur;
//           }
//            cur = next;
//           }
//           if(small == null){
//            return big;
//           }else{
//            smallLast.next = big;
//           }
//           return small;
//        }
//    }

//***********************************************************删除有序链表重复元素
//public class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int x){ val = x;}
//    public ListNode remove(ListNode head){
//        if(head == null){return null;}
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        ListNode p1 = head;
//        ListNode p2 = head.next;
//        while(p2 != null){
//            if(p1.val != p2.val){
//                pre = pre.next;
//                p1 = p1.next;
//                p2 = p2.next;
//            }else{
//                while(p2 != null && p2.val == p1.val) {
//                    p2 = p2.next;
//                }
//                    pre.next = p2;
//                    p1 = p2;
//                    if(p2 != null){
//                        p2 = p2.next;
//                    }
//                }
//            }
//        return dummy.next;
//    }
//}
//*******************************************************************************回文链表
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//    // 求链表长度
//    public int getLength(ListNode head){
//        ListNode cur = head;
//        int count = 0;
//        while(cur != null){
//            count++;
//            cur = cur.next;
//        }
//        return count;
//    }
//    // 逆置
//    public ListNode reverse(ListNode middle){
//        ListNode pre = null;
//        ListNode cur = middle;
//        while(middle != null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = cur.next;
//        }
//        return pre;
//    }
//    //判断回文
//    public boolean ishuiwen(ListNode head){
//         int half = (getLength(head))/2;
//         int i;
//         ListNode middle = head;
//         for(i = 0; i < half; i++){
//             middle = middle.next;
//         }
//         ListNode r = reverse(middle);
//         while(r != null && head != null){
//             if(r.val == head.val){
//                 r = r.next;
//                 head = head.next;
//             }else{
//                 return false;
//             }
//         }
//         return true;
//    }
//}
//
