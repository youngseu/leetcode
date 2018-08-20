package ArrayorList;

import Base.QuickSort;

import java.util.PriorityQueue;

//215 problem
//Kth Largest Element in an Array
//Find the kth largest element in an unsorted array. Note that it is the kth largest element in
//the sorted order, not the kth distinct element.
//Example 1:
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
//Example 2:
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4
public class KthLargestElementInAnArray {
    //小根堆求第k大的数值
    //时间复杂度 O(N lg K) running time + O(K) memory
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

    //基于快排思想
    //时间复杂度 O(N) guaranteed running time + O(1) space
    public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = QuickSort.partition(nums, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else break;
        }
        return nums[k];
    }
}
