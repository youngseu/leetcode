package Tree;

import Base.TreeNode;

import java.util.Stack;

//230 problem
//Kth Smallest Element in a BST
//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//Note:
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
// How would you optimize the kthSmallest routine?
public class KthSmallestElementInaBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k==0) break;
            root = root.right;
        }
        return root.val;
    }
}
