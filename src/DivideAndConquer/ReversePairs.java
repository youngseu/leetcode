package DivideAndConquer;

import java.util.Arrays;

//493 problem
//Reverse Pairs
//Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
//You need to return the number of important reverse pairs in the given array.
//Example1:
//Input: [1,3,2,3,1]
//Output: 2
public class ReversePairs {
    int[] help;

    public int reversePairs(int[] nums) {
        help = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int mid = s + (e - s) / 2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, s, e + 1);
        //sort or merge
        //merge(nums, s, mid, e);
        return cnt;
    }

    public void merge(int[] nums, int s, int mid, int e) {
        //close left and right
        for (int i = s; i <= e; i++) {
            help[i] = nums[i];
        }
        int p1 = s;//for left part
        int p2 = mid + 1;//for right part
        int i = s;//for sorted array
        while (p1 <= mid || p2 <= e) {
            if (p1 > mid || (p2 <= e && help[p1] >= help[p2])) {
                nums[i++] = help[p2++];
            } else {
                nums[i++] = help[p1++];
            }
        }
    }


//    int count = 0;
//
//    public int reversePairs(int[] nums) {
//        if (nums.length <= 1) return 0;
//        int[] result = dchelp(nums);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//        return count;
//    }
//
//    public int[] dchelp(int[] nums) {
//        if (nums.length == 1) return nums;
//        int[] result = new int[nums.length];
//        int mid = nums.length / 2;
//        int[] left = dchelp(Arrays.copyOfRange(nums, 0, mid));
//        int[] right = dchelp(Arrays.copyOfRange(nums, mid, nums.length));
//        int x = 0, y = 0, tmp ;
//        for (int i = 0; i < nums.length; i++) {
//            if (x < left.length && y < right.length) {
//                if (left[x] < right[y]) {
//                    tmp = y;
//                    while (tmp < right.length) {
//                        if (left[x] > 2l * right[tmp]) {
//                            count++;
//                        }
//                        tmp++;
//                    }
//                    result[i] = left[x++];
//                } else {
//                    tmp = x;
//                    while (tmp < left.length) {
//                        if (left[tmp] > 2l * right[y]) {
//                            count += (left.length - tmp);
//                            break;
//                        }
//                        tmp++;
//                    }
//                    result[i] = right[y++];
//                }
//            } else if (x >= left.length)
//                result[i] = right[y++];
//            else
//                result[i] = left[x++];
//        }
//        return result;
//    }

    public static void main(String[] args) {
        ReversePairs r = new ReversePairs();
        System.out.println(r.reversePairs(new int[]{2, -4, -3, -3, -1}));
    }
}
