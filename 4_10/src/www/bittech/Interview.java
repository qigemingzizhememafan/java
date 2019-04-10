package www.bittech;

public class Interview {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode result = null; // 结果链表，没有结点
            ListNode last = null;   // 记录结果链表的最后一个结点

            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                if (cur.val != val) {
                    // 把 cur 结点尾插到 result 链表上

                    // 尾插
                    cur.next = null;
                    if (result == null) {
                        result = cur;
                    } else {
                        last.next = cur;
                    }
                    // 尾插结束

                    // 更新结果链表的最后一个结点
                    last = cur;
                }
                cur = next;
            }

            return result;
        }

        public ListNode removeElements2(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            ListNode cur = head;
            while (cur.next != null) {
                if (cur.next.val != val) {
                    cur = cur.next;
                } else {
                    cur.next = cur.next.next;
                }
            }

            if (head.val == val) {
                return head.next;
            } else {
                return head;
            }
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null; // 结果链表
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = result;
            result = cur;

            cur = next;
        }

        return result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = null; // 结果链表的第一个结点
        ListNode last = null;   // 记录结果链表的最后一个结点

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                // 1. 让 cur1 可以在运行后执行 原 cur1 的下一个结点
                // 2. 让 cur1 尾插到 [result, last] 链表上
                // 3. 更新 last
                ListNode next = cur1.next;

                // 把 cur1 尾插到 result 上
                cur1.next = null;
                if (result == null) {
                    // result 链表中没有结点
                    result = cur1;
                } else {
                    // result 链表中有结点
                    last.next = cur1;
                }
                last = cur1;    // 更新最后一个结点记录

                cur1 = next;
            } else {
                ListNode next = cur2.next;

                // 把 cur2 尾插到 result 上
                cur2.next = null;
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;

                cur2 = next;

            }
        }

        if (cur1 != null) {
            last.next = cur1;
        }

        if (cur2 != null) {
            last.next = cur2;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;

        Solution solution = new Solution();
        ListNode result = solution.removeElements(n1, 6);
        ListNode cur = result;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}