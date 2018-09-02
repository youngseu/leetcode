package Niuke.Square;

import java.util.ArrayDeque;
import java.util.ArrayList;

//滑动窗口最大值
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
//单调队列
public class MaxNumInSlideWindow {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0) return res;
        int begin = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (deque.isEmpty())
                deque.add(i);
            else if (begin > deque.getFirst())
                deque.poll();
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()])
                deque.removeLast();
            deque.add(i);
            if (begin >= 0)
                res.add(num[deque.getFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxNumInSlideWindow demo = new MaxNumInSlideWindow();
        demo.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
    }
}
