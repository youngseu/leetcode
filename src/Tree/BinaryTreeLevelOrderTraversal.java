package Tree;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102 problem
//Binary Tree Level Order Traversal
//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSum = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < levelSum; i++) {
                TreeNode temp = queue.poll();
                sublist.add(temp.val);
                if (temp.left !=null) queue.offer(temp.left);
                if (temp.right !=null) queue.offer(temp.right);
            }
            res.add(sublist);
        }
        return res;
    }

    //preorder implyment levelorder
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        helper(root, levelList, 0);
        return levelList;
    }

    private void helper(TreeNode node, List<List<Integer>> levelList, int level) {
        if (node == null) return;
        if (levelList.size() <= level) {
            levelList.add(new ArrayList<Integer>());
        }
        levelList.get(level).add(node.val);
        helper(node.left, levelList, level+1);
        helper(node.right, levelList, level+1);
    }
}
