package com.LianB_FX;
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    /**
     * 牛客 链表分割
     *  先建立两个链表，分别存放小于基准值的和大于基准值的
     *  遍历原链表，把每个节点放入合适的位置
     *  遍历完后，不能直接把大小链表拼接起来
     *  因为有可能小的链表为空，需要判断
     */
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode cur = pHead;
        ListNode small = null; //小于基准值的结果链表
        ListNode big = null;   //大于基准值的结果链表
        ListNode smallLast = null;
        ListNode bigLast = null;
        while(cur != null){
            ListNode next = cur.next;
            // 把小于基准值的尾插到small里
            if(cur.val < x){
                cur.next = null;
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                smallLast = cur;
            }else{
                cur.next = null;
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = next;
        }
        if (small == null) {
            return big;
        } else {
            smallLast.next = big;
            return small;
        }
    }

    /**
     * leetcode21 合并两个有序链表
     * 建立结果链表，分别遍历l1、l2两个链表
     * 每次进行比较，将较小的一个尾插到结果链表
     * 当至少有一个为空时，只需将另一个尾插到结果链表
     * 注意开始要对l1、l2进行判断，否则会空指针
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = null;
        ListNode last = null;
        while(cur1 != null && cur2 != null){
            // l1的值小，把l1先尾插到结果链表上
            if(cur1.val <= cur2.val){
                if(res == null){
                    res = cur1;
                }else{
                    last.next = cur1;
                }
                last = cur1;
                cur1 = cur1.next;
            }else{
                // l2的值小,把l2尾插到res上
                if(res == null){
                    res = cur2;
                }else{
                    last.next = cur2;
                }
                last = cur2;
                cur2 = cur2.next;
            }
        }
        // l1，l2中至少有一个为空了
        if(cur1 == null){
            last.next = cur2;
        }
        if(cur2 == null){
            last.next = cur1;
        }
        return res;
    }

    /**
     * 牛客 链表中倒数第K个节点
     * 使用快慢引用，一开始都指向head处
     * 然后让快引用先走K步，走完后需要判断
     * 如果K的值大于i，即K的值大于链表长度，则所求节点不存在
     * 如果K的值等于i，即K的值等于链表长度，所求节点就是头结点
     * 然后让快慢引用一起走，当快的走到null时，慢的也走到倒数第K个地方
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快的先走K步
        int i;
        for(i = 0; fast != null && i < k; i++){
            fast = fast.next;
        }
        // 说明此时K的值大于链表长度值，不存在倒数第K个节点
        if(fast == null && i < k){
            return null;
        }
        // 此时K的值正好等于链表长度，即返回头结点
        else if(fast == null){
            return head;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     * leetcode876 链表的中间节点
     * 创建两个引用，一个每次走两步称为快引用
     * 一个每次走一步称为慢引用
     * 快的先走每次走两步，但每次走的时候都要判断是否为空
     * 慢的每次走一步，当快的走到终点时，慢的也就到了中点
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    /**
     *  leetcode206 反转链表
     */
    // 利用三引用，每次让cur的指向发生反向变化
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }

    /**
     * 创建结果链表，遍历原链表
     * 把原链表中的每一个元素头插到结果链表上
     * ps:要注意保存cur的next，因为next被修改过了
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode res = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
        }
        return res;
    }


//  leetcode203 移除链表元素
     /**
      * 直接在原链表上操作
      * 若当前节点的下一个节点的值等于val
      * 让当前结点的下一个节点指向当前结点下一个的下一个节点
      * 若不相等，继续往后遍历
      */
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(cur.next != null){
            if(cur.next.val != val){
                cur = cur.next;
            }else{
                cur.next = cur.next.next;
            }
        }
        // 头结点还没判断过
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }

    /**
     * 创建结果链表，遍历原链表
     * 不相等的尾插到结果链表上
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        // 1,创建结果链表
        ListNode result = null;
        ListNode cur = head;
        ListNode last = head; //保存最后一个节点的位置
        // 2,遍历原链表,如果不等于val，就把该节点尾插到结果链表上
        while(cur != null){
            ListNode next = cur.next;
            if(cur.val != val){
                cur.next = null;
                if(result == null){
                    result = cur;
                }else{
                    last.next = cur;
                }
                last = cur;
            }
            cur = next;
        }
        return result;
    }
}
