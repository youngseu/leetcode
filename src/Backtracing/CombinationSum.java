package Backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39 problem
//Combination Sum
//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [2, 3, 6, 7] and target 7,
//[
//  [7],
//  [2, 2, 3]
//]
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracing(candidates, target, new ArrayList<Integer>(), res, 0);
        return res;
    }

    public static void backtracing(int[] candidates, int target, ArrayList<Integer> list, List<List<Integer>> res,
                                   int start) {
        if (target < 0)
            return;
        else if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            //can myexist the same number
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtracing(candidates, target - candidates[i], list, res, i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
//    public static void backtracing(int[] candidates, int target, ArrayList<Integer> list, List<List<Integer>> res) {
//        for (int candidate : candidates) {
//            int target_l = target - candidate;
//            if (target_l == 0) {
//                list.add(new Integer(candidate));
//                //出现重复结果，相当于全排列[2,2,3],[2,3,2],[3,2,2]
//                res.add(new ArrayList<>(list));
//                list.remove(list.size() - 1);
//            } else if (target_l > 0) {
//                list.add(new Integer(candidate));
//                backtracing(candidates, target_l, list, res);
//                list.remove(list.size() - 1);
//            }else return;
//        }
//    }
