package Base;

import java.util.Arrays;

//O(n^2)
public class InsertSort {
    public static void insertsort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
        insertsort(array);
        System.out.println(Arrays.toString(array));
    }
}
