package Base;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarysearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println(Arrays.binarySearch(array, 5));
        System.out.println(binarysearch(array, 5));
    }
}
