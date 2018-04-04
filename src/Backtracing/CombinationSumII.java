package Backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40 problem
//Combination Sum II
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
//in C where the candidate numbers sums to T.
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracing(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    public static void backtracing(List<List<Integer>> res, List<Integer> list, int[] candidates, int target,
                                   int start) {
        if (target < 0) return;
        else if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                //避免重复元素
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                //单个元素不能重复使用
                backtracing(res, list, candidates, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum2(new int[]{1, 1, 2, 5, 6, 7}, 8);
    }
}
