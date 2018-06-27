package ArrayorList;

import Base.ListNode;

//problem 142
//Linked List Cycle II
//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode walker = head;
        ListNode runner = head;
        boolean flag = false;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;
        ListNode cur = head;
        //the walker to crossponit == the head to crosspiont
        while (cur != walker) {
            cur = cur.next;
            walker = walker.next;
        }
        return cur;
    }
}
