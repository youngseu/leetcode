package Niuke.sword;

import java.util.Scanner;

//题目描述
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出
//旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元
//素都大于0，若数组大小为0，请返回0
public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int start = 0, end = array.length - 1, mid = 0;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (array[start] == array[end] && array[start] == array[mid]) {
                return Minvalue(array, start, end);
            }
            if (array[mid] >= array[start])
                start = mid;
            else //if (array[mid] < array[end])
                end = mid;
        }
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