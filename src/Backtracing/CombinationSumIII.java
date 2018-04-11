package Backtracing;

import java.util.ArrayList;
import java.util.List;

//216 problem
//Combination Sum III
//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
//can be used and each combination should be a unique set of numbers.
//Example 2:
//Input: k = 3, n = 9
//Output:
//[[1,2,6], [1,3,5], [2,3,4]]
public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracing(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    public static void backtracing(List<List<Integer>> res, List<Integer> temp_list, int k, int n, int start) {
        if (temp_list.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(temp_list));
        } else if (k > 0 && n > 0) {
            for (int i = start; i <= 9; i++) {
                temp_list.add(i);
                backtracing(res, temp_list, k, n - i, i + 1);
                temp_list.remove(temp_list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum3(3, 9);
    }
}
