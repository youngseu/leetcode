package Tree;

import Base.TreeNode;

import java.util.*;

//145 problem
//Binary Tree Postorder Traversal
//Given a binary tree, return the postorder traversal of its nodes' values.
//Recursive solution is trivial, could you do it iteratively?
//Example:
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//Output: [3,2,1]
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

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }
}
