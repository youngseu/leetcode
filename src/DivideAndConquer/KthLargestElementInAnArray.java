package DivideAndConquer;

import java.util.PriorityQueue;

//215 problem
//Kth Largest Element in an ArrayorList
//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
public class KthLargestElementInAnArray {
    //priority queue
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
