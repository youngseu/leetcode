package ArrayorList;

import Base.ListNode;

import java.util.HashSet;
import java.util.Set;

//problem 141
//Linked List Cycle
//Given a linked list, determine if it has a cycle in it.
//Follow up:
//Can you solve it without using extra space?
public class LinkedListCycle {
    //so eventually, they will still meet at the point where the circle starts
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
