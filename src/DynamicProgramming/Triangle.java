package DynamicProgramming;

import java.util.List;

//120 problem
//Triangle
//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
//adjacent numbers on the row below.
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
public class Triangle {
    //public static int[] max = {-1};

    //bottom-up
    //minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
    //minpath[i] = min( minpath[i], minpath[i+1]) + triangle[k][i];
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] minpath = new int[triangle.size() + 1];//? +1
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                minpath[j] = Math.min(minpath[j], minpath[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minpath[0];
    }

    //error max sum
//    public int minimumTotalbacktracing(List<List<Integer>> triangle) {
//        return backtracing(triangle, 0, 0, 0, max);
//    }
//
//    public int backtracing(List<List<Integer>> triangle, int sum, int row, int col, int[] max) {
//        sum += triangle.get(row).get(col);
//        if (row + 1 < triangle.size()) {
//            if (col - 1 >= 0)
//                backtracing(triangle, sum, row + 1, col - 1, max);
//            backtracing(triangle, sum, row + 1, col, max);
//            if (col + 1 <= row + 1)
//                backtracing(triangle, sum, row + 1, col + 1, max);
//        }
//        max[0] = Math.max(sum, max[0]);
//        return max[0];
//    }
}
