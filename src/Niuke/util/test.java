package Niuke.util;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] sum = new int[]{2,9,12,16,25};
        int order = Arrays.binarySearch(sum, 1);
        System.out.println(order);
        System.out.println(-order-1);
    }
}
