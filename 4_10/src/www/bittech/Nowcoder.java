package www.bittech;

public class Nowcoder {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

//***********************以X分割为左右两部分*************************************************
    public class Solution {
        public ListNode partition(ListNode pHead, int x) {
            ListNode small = null;  // 小于 x
            ListNode smallLast = null;  // 小于 x 的最后一个结点
            ListNode big = null;    // 大于等于 x
            ListNode bigLast = null;    // 大于等于 x 的最后一个结点
            ListNode cur = pHead;
            while (cur != null) {
                ListNode next = cur.next;
                // 小于 x，尾插到 small，大于等于 x，尾插到 big
                if (cur.val < x) {
                    // 把 cur 尾插到 small 链表上
                    if (small == null) {
                        small = cur;
                    } else {
                        smallLast.next = cur;
                    }
                    // 更新最后一个链表的结点记录
                    smallLast = cur;
                } else {
                    // 把 cur 尾插到 big 链表上
                    if (big == null) {
                        big = cur;
                    } else {
                        bigLast.next = cur;
                    }
                    // 更新最后一个链表的结点记录
                    bigLast = cur;
                }
                cur = next;
            }
            // [small, smallLast]
            // [big, bigLast]
            // 需要考虑其中有链表为空的情况
            if (small == null) {
                return big;
            } else {
                smallLast.next = big;
                return small;
            }
        }

//********************找倒数第K个节点****************************************************
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

//*********************判断链表回文******************************************************
        public int length(ListNode head) {
            int len = 0;
            ListNode cur = head;
            while (cur != null) {
                len++;
                cur = cur.next;
            }
            return len;
        }
        public ListNode reverse(ListNode head) {
            ListNode result = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = result;
                result = cur;
                cur = next;
            }
            return result;
        }
        public boolean chkPalindrome(ListNode A) {
            int len = length(A);
            int halfLen = len / 2;
            ListNode middle = A;
            for (int i = 0; i < halfLen; i++) {
                middle = middle.next;
            }
            ListNode r = reverse(middle);
            ListNode c1 = A;
            ListNode c2 = r;
            while (c1 != null && c2 != null) {
                if (c1.val != c2.val) {
                    return false;
                }
                c1 = c1.next;
                c2 = c2.next;
            }
            return true;
        }

//************************删除重复结点**************************************************
        public ListNode deleteDuplication(ListNode head) {
            if (head == null) {
                return head;
            }
            // 消除第一个结点没有前驱的特殊性
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;  // prev 永远是 p1 的前驱结点，用来删除结点
            // p1 和 p2 是进行比较的两个结点
            ListNode p1 = head;
            ListNode p2 = head.next;
            while (p2 != null) {
                if (p1.val != p2.val) {
                    // 因为有序，p1 和 p2 不等，和 p2 的 next 更不会相等
                    prev = prev.next;
                    p1 = p1.next;
                    p2 = p2.next;
                } else {
                    while (p2 != null && p2.val == p1.val) {
                        p2 = p2.next;
                    }
                    prev.next = p2;
                    p1 = p2;
                    if (p2 != null) {
                        p2 = p2.next;
                    }
                }
            }
            return dummy.next;
        }
    }
}
