package Greedy;

import Base.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//253 problem
//Meeting Rooms II
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
//find the minimum number of conference rooms required.
//For example,
//Given [[0, 30],[5, 10],[15, 20]],
//return 2.
//最少需要多少会议室
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int rooms = 0;
        int active = 0;
        //优先级队列保存某会议室最早能使用的时间
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= intervals[i].start) {
                active--;
                heap.poll();
            }
            active++;
            heap.offer(intervals[i].end);
            rooms = Math.max(rooms, active);
        }
        return rooms;
    }
}
