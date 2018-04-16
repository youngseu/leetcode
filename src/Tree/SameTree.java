package Tree;

import Base.TreeNode;

//100 problem
//Same Tree
//Given two binary trees, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        if (!isSameTree(p.left, q.left)) return false;
        if (!isSameTree(p.right, q.right)) return false;
        return true;
    }
}
