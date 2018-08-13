package Niuke.netease.contest_huyu;

import ArrayorList.NextPermutation;

public class thirdans {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[]{'a','a','z','z'};
        for (int i = 0; i < 5; i++) {
            np.nextPermutation(nums);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(nums[i]);
        }
    }
}
