package Tree;

import Base.TreeNode;

import java.util.*;

//145 problem
//Binary Tree Postorder Traversal
//Given a binary tree, return the postorder traversal of its nodes' values.
//Recursive solution is trivial, could you do it iteratively?
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            root = deque.pop();
            res.addFirst(root.val);
            if (root.left != null) deque.push(root.left);
            if (root.right != null) deque.push(root.right);
        }
        return res;
    }
}
