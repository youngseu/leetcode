package Tree;

import Base.TreeNode;

//101 problem
//Symmetric Tree
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return backtracing(root.left, root.right);
    }

    public boolean backtracing(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        if (!backtracing(l.left, r.right)) return false;
        if (!backtracing(l.right, r.left)) return false;
        return true;
    }
}
