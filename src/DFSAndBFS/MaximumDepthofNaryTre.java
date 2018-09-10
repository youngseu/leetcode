package DFSAndBFS;

import Base.Node;

//559 problem
//Maximum Depth of N-ary Tre
//Given a n-ary tree, find its maximum depth.
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
public class MaximumDepthofNaryTre {
    public int maxDepth(Node root) {
        if (root == null) return 1;
        int max = 0;
        for (Node node : root.children) {
            int val = maxDepth(node);
            max = Math.max(max, val);
        }
        return max + 1;
    }
}
