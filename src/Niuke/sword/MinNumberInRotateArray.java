package Niuke.sword;

import java.util.Scanner;

//题目描述
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出
//旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元
//素都大于0，若数组大小为0，请返回0
/*分析：
 *      1)旋转数组的第一个元素大于等于最后一个元素。
 *      2)旋转数组中包含了两个递增的序列，第二个递增序列中的第一个元素即该旋转数组的最小值。
 *      3)我们可以根据旋转数组的中间元素来确定最小元素的位置：
 *          1>若中间元素大于等于旋转数组的第一个元素，则说明最小值在旋转数组的右半部分；
 *          2>若中间元素小于旋转数组的第一个元素，则说明最小值在旋转数组的左半部分；
 *          3>故我们可以使用二分法来确定最小元素的位置。
 *          4>需要注意一种特殊情况：当left指向的元素、right指向的元素、中间元素 这3个元素相等时，我们就
 *            无法确定最小的元素的位置，故此时只能使用顺序查找了。
 *
 *  说明：
 *      1)直接遍历旋转数组即可找到最小元素，但是时间复杂度为O(n)
 *      2)采用二分法，时间复杂度为O(logn)
 */
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