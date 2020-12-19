package Base;

import java.util.Arrays;

public class ShellSort {
    public static void shellsort(int[] array){
        int length = array.length;
        for(int gap = length/2; gap > 0; gap = gap/2){
            for(int i = gap; i < length; i++){
                int index = i;
                int currentValue = array[index];
                while (index - gap >=0 && array[index-gap] > currentValue){
                    array[index] = array[index-gap];
                    index -= gap;
                }
                array[index] = currentValue;

            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
        shellsort(array);
        System.out.println(Arrays.toString(array));
    }
}
