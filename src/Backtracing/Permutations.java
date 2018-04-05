package Backtracing;

import java.util.ArrayList;
import java.util.List;

//46 problem
//Permutations
//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracing(res, new ArrayList<Integer>(), nums);
        return res;
    }

    public static void backtracing(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));
        else for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtracing(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    //非递归实现的思路，假设我们有了当前前 i 个元素的组合，当第 i+1个元素加入时，我们需要做的是将这个元素加入之前的每一个结果，
    // 并且放在每个结果的每个位置，因为之前的结果没有重复，所以加入新元素的结果也不会有重复（这里是假定数字集合没有重复）
    public List<List<Integer>> no_backtracing_permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        res.add(first);
        for(int i = 1; i < nums.length; i++) {
            List<List<Integer>> newRes = new ArrayList<>();
            for(List<Integer> temp : res) {
                int size = temp.size() + 1;
                for(int j = 0; j < size; j++) {
                    List<Integer> item = new ArrayList<>(temp);
                    item.add(j, nums[i]);
                    newRes.add(item);
                }
            }
            res = newRes;
        }
        return res;
    }
}
