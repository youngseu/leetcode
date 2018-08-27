package Greedy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//56 problem
//Merge Intervals
//Given a collection of intervals, merge all overlapping intervals.
//Example 1:
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//Example 2:
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start)
                merged.add(interval);
                // otherwise, there is overlap, so we merge the current and previous intervals
            else
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
        }
        return merged;
    }
}
