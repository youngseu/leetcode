package Backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

//78 problem
//Subsets
//Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,3], a solution is:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //start保证不是全遍历
        backtracing(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public static void backtracing(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracing(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //非递归
    public static List<List<Integer>> nobacktracing_subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < res.size(); j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
