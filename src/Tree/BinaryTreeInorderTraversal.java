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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (true) {
            TreeNode node = stack.peek();
            if (node.left != null)
                stack.push(root.left);
            else if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
