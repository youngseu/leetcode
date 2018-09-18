package Math;

import Base.ListNode;

import java.util.Random;

//382 problem
//Linked List Random Node
//Given a singly linked list, return a random node's value from the linked list. Each node must have
//the same probability of being chosen.
//蓄水池算法
public class LinkedListRandomNode {
    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    ListNode head;
    Random random;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode c = head;
        int r = c.val;
        for (int i = 1; c.next != null; i++) {
            c = c.next;
            if (random.nextInt(i + 1) == i) r = c.val;
        }
        return r;
    }
}
