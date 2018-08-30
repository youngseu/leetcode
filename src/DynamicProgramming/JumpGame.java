package DynamicProgramming;

//55 problem
//Jump Game
//Given an array of non-negative integers, you are initially positioned at the first index of the
//array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.
//Example 1:
//Input: [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//Input: [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum
//             jump length is 0, which makes it impossible to reach the last index.
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastPost = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPost) {
                lastPost = i;
            }
        }
        return lastPost == 0;
    }

    //slow
    public boolean canJump2(int[] nums) {
        int[] flags = new int[nums.length];
        flags[0] = 1;
        for (int i = 0; i < nums.length && flags[i] == 1; i++) {
            for (int j = i; j <= nums[i] + i; j++) {
                if (j >= nums.length - 1) return true;
                flags[j] = 1;
            }
        }
        return false;
    }
}
