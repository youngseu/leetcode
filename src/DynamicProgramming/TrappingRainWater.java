package DynamicProgramming;

//42 pronlem
//Trapping Rain Water
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
//it is able to trap after raining.
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
public class TrappingRainWater {
    //brute force
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    //dp
    public int trap1(int[] height) {
        if (height.length == 0) return 0;
        int ans = 0;
        int size = height.length;
        int[] rigth_max = new int[size];
        int[] left_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        rigth_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rigth_max[i] = Math.max(rigth_max[i + 1], height[i]);
        }
        for (int i = 0; i < size; i++) {
            ans += Math.min(left_max[i], rigth_max[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] test = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappingRainWater.trap1(test));
    }

}
