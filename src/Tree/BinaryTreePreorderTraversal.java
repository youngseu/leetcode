package Tree;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144 problem
//Binary Tree Preorder Traversal
//Given a binary tree, return the preorder traversal of its nodes' values.
public class BinaryTreePreorderTraversal {
    //iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                res.add(temp.val);
                stack.add(temp.right);
                stack.add(temp.left);
            }
        }
        return res;
    }

    //recursive
    public void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }
}
