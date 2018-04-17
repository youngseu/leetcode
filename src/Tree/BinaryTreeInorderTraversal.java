package Tree;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//94 problem
//Binary Tree Inorder Traversal
//Given a binary tree, return the inorder traversal of its nodes' values.
//Recursive solution is trivial, could you do it iteratively
public class BinaryTreeInorderTraversal {
    //iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    //recursive
    public void helper(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
