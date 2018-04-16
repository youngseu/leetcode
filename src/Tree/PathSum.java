package Tree;

import Base.TreeNode;

//112 problem
//Path Sum
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
//the path equals the given sum.
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        else if (sum - root.val == 0 && root.left == null && root.right == null) return true;
        else if (root.left != null && root.right != null)
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        else if (root.left != null)
            return hasPathSum(root.left, sum - root.val);
        else if (root.right != null)
            return hasPathSum(root.right, sum - root.val);
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        else {
            int subsum = sum - root.val;
            boolean ans = false;
            if (subsum == 0 && root.right == null && root.left == null)
                return true;
            if (root.right != null)
                ans = ans || hasPathSum(root.right, subsum);
            if (root.left != null)
                ans = ans || hasPathSum(root.left, subsum);
            return ans;
        }
    }
}
