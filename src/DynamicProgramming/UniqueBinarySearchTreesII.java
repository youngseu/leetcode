package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//95 problem
//Unique Binary Search Trees II
public class UniqueBinarySearchTreesII {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(2).size());
    }
}
//    错误使用二维动态数组保存节点组合
//    public static List<TreeNode> generateTrees(int n) {
//        ArrayList<ArrayList<TreeNode>> dp = new ArrayList<ArrayList<TreeNode>>();
//        ArrayList<TreeNode> t = new ArrayList<>();
//        t.add(new TreeNode(-1));
//        dp.add(t);
//        ArrayList<TreeNode> p = new ArrayList<>();
//        p.add(new TreeNode(1));
//        dp.add(p);
//        for (int i = 2; i < n + 1; i++) {
//            ArrayList<TreeNode> i_dp = new ArrayList<>();
//            for (int j = 0; j < i; j++) {
//                TreeNode tmp = new TreeNode(j+1);
//                for (TreeNode l : dp.get(j)) {
//                    for (TreeNode r : dp.get(i - j - 1)) {
//
//                        if (l.val == -1)
//                            tmp.left = null;
//                        else
//                            tmp.left = l;
//
//                        if (r.val == -1)
//                            tmp.right = null;
//                        else
//                            tmp.right = r;
//                        i_dp.add(tmp);
//                    }
//                }
//            }
//            dp.add(i_dp);
//        }
//        return dp.get(n);
//    }