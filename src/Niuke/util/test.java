package Niuke.util;

import java.util.Arrays;

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
    }
}
