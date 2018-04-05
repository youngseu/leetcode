package DynamicProgramming;

import Base.TreeNode;

import java.util.ArrayList;
import java.util.List;

//95 problem
//Unique Binary Search Trees II
// result[i] stores the result until length i. For the result for length i+1, select the root node j from 0 to i,
// combine the result from left side and right side.
// Note for the right side we have to clone the nodes as the value will be offsetted by j.
public class UniqueBinarySearchTreesII {

    public static List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0) return dp[0];
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<TreeNode>();
            for (int j = 0; j < i; j++) {
                for (TreeNode l : dp[j])
                    for (TreeNode r : dp[i - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = l;
                        //node.right = r;
                        node.right = clone(r, j + 1);
                        dp[i].add(node);
                    }
            }
        }
        return dp[n];
    }

    public static TreeNode clone(TreeNode n, int offset) {
        if (n == null) return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }


    public static void main(String[] args) {
        System.out.println(generateTrees(4).size());
    }
}
//    错误使用二维动态数组保存节点组合
//    public static List<Base.TreeNode> generateTrees(int n) {
//        ArrayList<ArrayList<Base.TreeNode>> dp = new ArrayList<ArrayList<Base.TreeNode>>();
//        ArrayList<Base.TreeNode> t = new ArrayList<>();
//        t.add(new Base.TreeNode(-1));
//        dp.add(t);
//        ArrayList<Base.TreeNode> p = new ArrayList<>();
//        p.add(new Base.TreeNode(1));
//        dp.add(p);
//        for (int i = 2; i < n + 1; i++) {
//            ArrayList<Base.TreeNode> i_dp = new ArrayList<>();
//            for (int j = 0; j < i; j++) {
//                Base.TreeNode tmp = new Base.TreeNode(j+1);
//                for (Base.TreeNode l : dp.get(j)) {
//                    for (Base.TreeNode r : dp.get(i - j - 1)) {
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