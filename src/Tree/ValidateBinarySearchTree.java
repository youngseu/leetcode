package Tree;

import Base.TreeNode;

import java.util.Stack;

//98 problem
//Validate Binary Search Tree
//Given a binary tree, determine if it is a valid binary search tree (BST).
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return recursive(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean recursive(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return recursive(root.left, root.val, min) && recursive(root.right, max, root.val);
    }

    //利用中序遍历的特性
    public boolean iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val >= cur.val) return false;
            pre = cur;
            cur = cur.left;
        }
        return true;
    }
    //错误，只能判断每个单独节点及其子节点
//    public boolean recursive_error(TreeNode root) {
//        if (root == null) return true;
//        if (root.left != null && root.val < root.left.val) return false;
//        if (root.right != null && root.val > root.right.val) return false;
//        return recursive_error(root.left) && recursive_error(root.right);
//    }
}
