package Niuke.sword;

import Base.ListNode;

//链表翻转
public class ReverseList {
    public ListNode reverseList(ListNode h) {
        if (h == null || h.next == null) return h;
        ListNode p = h, newHead = null;
        while (p != null) { //遍历到链尾
            ListNode tmp = p.next;//暂存p的下一个地址
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }

    public ListNode backtrak(ListNode h) {
        if (h == null || h.next == null) return h;
        ListNode head = backtrak(h.next);
        h.next.next = h;
        h.next = null;
        return head;
    }
}
