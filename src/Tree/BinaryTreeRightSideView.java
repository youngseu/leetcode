package Tree;

import Base.TreeNode;

import java.util.*;

//199 problem
//Binary Tree Right Side View
//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//Example:
//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
public class BinaryTreeRightSideView {
    //bfs
    //Time complexity : O(n)
    //Space complexity : O(n)
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> valueAtDepth = new HashMap<>();
        int maxDepth = -1;

        //stacks are synchronized
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);

                //first node encounter depth
                if (!valueAtDepth.containsKey(depth)) {
                    valueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            res.add(valueAtDepth.get(i));
        }

        return res;
    }

    //bfs
    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> valueAtDepth = new HashMap<>();
        int maxDepth = -1;

        //queues are synchronized
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                maxDepth = Math.max(maxDepth, depth);

                //the last node we encounter at a particular depth contains the correct value, so the
                //correct value is never overwritten
                valueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            res.add(valueAtDepth.get(i));
        }
        return res;
    }
}
