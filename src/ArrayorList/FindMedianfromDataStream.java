package ArrayorList;

import java.util.PriorityQueue;

//295 problem
//Median is the middle value in an ordered integer list. If the size of the list is even, there is no
//middle value. So the median is the mean of the two middle value.
//For example,
//[2,3,4], the median is 3
//[2,3], the median is (2 + 3) / 2 = 2.5
//Design a data structure that supports the following two operations:
//void addNum(int num) - Add a integer number from the data stream to the data structure.
//double findMedian() - Return the median of all elements so far.
//Example:
//addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3)
//findMedian() -> 2
//Find Median from Data Stream

//Time complexity: O(5 * log(n)) + O(1) \approx O(log(n))O(5∗log(n))+O(1)≈O(log(n)).
//At worst, there are three heap insertions and two heap deletions from the top. Each of these takes
//about O(log(n))O(log(n)) time.
//Finding the mean takes constant O(1)O(1) time since the tops of heaps are directly accessible.
public class FindMedianfromDataStream {
    public PriorityQueue<Integer> hi;
    public PriorityQueue<Integer> lo;

    public FindMedianfromDataStream() {
        hi = new PriorityQueue<>();
        lo = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        lo.add(num);

        hi.add(lo.peek());
        lo.poll();

        if (lo.size() < hi.size()) {
            lo.add(hi.peek());
            hi.poll();
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}
