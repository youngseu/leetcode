package Backtraking;

import Base.TreeNode;

//543 problem
//Diameter of Binary Tree
//Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a
//binary tree is the length of the longest path between any two nodes in a tree. This path may or may
//not pass through the root.
//Example:
//Given a binary tree
//          1
//         / \
//        2   3
//       / \
//      4   5
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
public class DiameterofBinaryTree {
    public static int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        diameter = Math.max(diameter, l + r);
        return Math.max(l, r) + 1;
    }
}
