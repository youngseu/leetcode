package Base;

import java.util.Arrays;

public class ShellSort {
    public static void shellsort(int[] array) {
        // 计算出最大的h值
        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < array.length; i += h) {
                if (array[i] < array[i - h]) {
                    int tmp = array[i];
                    int j = i - h;
                    while (j >= 0 && array[j] > tmp) {
                        array[j + h] = array[j];
                        j -= h;
                    }
                    array[j + h] = tmp;
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
        shellsort(array);
        System.out.println(Arrays.toString(array));
    }
}
