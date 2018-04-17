package Tree;

import Base.TreeNode;

//99 problem
//Recover Binary Search Tree
//Two elements of a binary search tree (BST) are swapped by mistake.
//Recover the tree without changing its structure.
//Note:
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
public class RecoverBinarySearchTree {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        recursive(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void recursive(TreeNode root) {
        if (root == null) return;
        recursive(root.left);
        //if (first == null && prev.val >= root.val) first = prev;
        //if (first != null && prev.val >= root.val) second = root;
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        recursive(root.right);
    }
}
