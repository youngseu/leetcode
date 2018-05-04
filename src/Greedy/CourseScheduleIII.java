package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

//630 problem
//Course Schedule III
//There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and
//closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth
//day. You will start at the 1st day.
//Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can
//be taken.
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        //使用lambda表达式，简化代码
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for (int[] c : courses) {
            time += c[0];
            pq.add(c[0]);
            if (time > c[1]) {
                //If time exceeds, drop the previous course which costs the most time.
                //(That must be the best choice!)
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}