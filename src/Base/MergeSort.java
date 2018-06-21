package Base;

import java.util.Arrays;

//O(nlogn)
public class MergeSort {
    static int[] help;

    public static void mergesort(int[] array, int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;
            mergesort(array, s, mid);
            mergesort(array, mid + 1, e);
            //merge
            for (int i = s; i <= e; i++) {
                help[i] = array[i];
            }
            int p1 = s, p2 = mid + 1, i = s;
            while (p1 <= mid || p2 <= e) {
                if (p1 > mid || (p2 <= e && help[p1] >= help[p2]))
                    array[i++] = help[p2++];
                else
                    array[i++] = help[p1++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
        help = new int[array.length];
        mergesort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
