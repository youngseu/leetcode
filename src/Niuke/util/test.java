package Niuke.util;

import java.util.Arrays;
import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        int[] sum = new int[]{2, 9, 12, 16, 25};
        int order = Arrays.binarySearch(sum, 1);
        System.out.println(order);
        System.out.println(-order - 1);
        try {
            Class c = Class.forName("Niuke.util.string_test");
            System.out.println(c.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(Runtime.getRuntime().availableProcessors());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        System.out.println(pq.peek());
        System.out.println(pq.poll());

        System.out.println("firstExtended");
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 0);

        int[][] array = {{1, 2, 3}, {0, 0, 0}, {4, 5, 6}};
        Arrays.sort(array, (o1, o2) -> o1[0] - o2[0]);
        System.out.println();
    }
}
