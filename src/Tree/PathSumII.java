package Tree;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;

//113 problem
//Path Sum II
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        backtracing(root, res, new ArrayList<>(), sum);
        return res;
    }

    public void backtracing(TreeNode root, List<List<Integer>> res, List<Integer> temp_list, int sum) {
        if (root.left == null && root.right == null && sum - root.val == 0) {
            temp_list.add(root.val);
            res.add(new ArrayList<>(temp_list));
            temp_list.remove(temp_list.size() - 1);
        }
        //注释针对全为正值的树
        if (root.left != null /**&& sum - root.val > 0**/) {
            temp_list.add(root.val);
            backtracing(root.left, res, temp_list, sum - root.val);
            temp_list.remove(temp_list.size() - 1);
        }
        if (root.right != null/** && sum - root.val > 0**/) {
            temp_list.add(root.val);
            backtracing(root.right, res, temp_list, sum - root.val);
            temp_list.remove(temp_list.size() - 1);
        }
    }

    //简洁的写法
    public void backtracing2(TreeNode root, List<List<Integer>> res, List<Integer> temp_list, int sum) {
        if (root == null) return;
        temp_list.add(root.val);
        if (root.left == null && root.left == null && sum == root.val) {
            res.add(new ArrayList<>(temp_list));
            temp_list.remove(temp_list.size() - 1);
            return;
        } else {
            backtracing2(root.left, res, temp_list, sum - root.val);
            backtracing2(root.right, res, temp_list, sum - root.val);
        }
        temp_list.remove(temp_list.size() - 1);
    }
}
