package Niuke.toutiao.contest_toutiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//合并线段的问题
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

public class second {
    private static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval tmp = result.get(result.size() - 1);
            if (tmp.end < intervals.get(i).start)
                result.add(intervals.get(i));
            else {
                if (tmp.end < intervals.get(i).end)
                    tmp.end = intervals.get(i).end;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(bf.readLine().trim());
        List<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < len; i++) {
            String[] str = bf.readLine().trim().split(";");
            for (int j = 0; j < str.length; j++) {
                String[] arg = str[j].trim().split(",");
                intervals.add(new Interval(Integer.parseInt(arg[0]), Integer.parseInt(arg[1])));
            }
        }
        List<Interval> result = merge(intervals);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).start);
            System.out.print(",");
            System.out.print(result.get(i).end);
            if (i != result.size() - 1)
                System.out.print(";");
        }
    }
}