package Base;

import java.util.Arrays;

//O(nlogn)
public class QuickSort {
    public static int partition(int[] array, int lo, int hi) {
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void quicksort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        quicksort(array, lo, index - 1);
        quicksort(array, index + 1, hi);
    }


    public static void main(String[] args) {
        int[] array = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        System.out.println(partition(array, 0, array.length - 1));
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
