package ArrayorList;

import Base.ListNode;

//160 problem
//Intersection of Two Linked Lists
//Write a program to find the node at which the intersection of two singly linked lists begins.
//For example, the following two linked lists:
//
//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗
//B:     b1 → b2 → b3
//begin to intersect at node c1.
//If the two linked lists have no intersection at all, return null.
//The linked lists must retain their original structure after the function returns.
//You may assume there are no cycles anywhere in the entire linked structure.
//Your code should preferably run in O(n) time and use only O(1) memory.
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = 0, lengthB = 0, dis = 0;
        for (; curA != null; curA = curA.next, lengthA++) ;
        for (; curB != null; curB = curB.next, lengthB++) ;
        if (lengthA < lengthB) {
            dis = lengthB - lengthA;
            for (int i = 0; i < dis; headB = headB.next, i++) ;
        } else {
            dis = lengthA - lengthB;
            for (int i = 0; i < dis; headA = headA.next, i++) ;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
