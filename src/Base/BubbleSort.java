package Base;
//average O(n^2) best O(n)
public class BubbleSort {
    public static void bubblesort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
        bubblesort(array);
        for (int fac : array)
            System.out.print(fac + " ");
    }
}
