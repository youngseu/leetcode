package Niuke.test;


import java.util.Scanner;

public class test {

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int start = 0, end = array.length - 1, mid = 0;
//        int result = array[0];
        while (array[start] >= array[end]) {
            if (end - start == 1) {
//                result = array[end];
                mid = end;
                break;
            }
            mid = (start + end) >> 1;
            if (array[start] == array[end] && array[start] == array[mid]) {
                return Minvalue(array, start, end);
            }
            if (array[mid] >= array[start])
                start = mid;
            else //if (array[mid] < array[end])
                end = mid;
        }
//        System.out.println(array[mid]);
        return array[mid];
    }

    public static int Minvalue(int[] array, int start, int end) {
        int min = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++)
            array[i] = sc.nextInt();
        System.out.println(minNumberInRotateArray(array));
    }
}