package Niuke.toutiao.contest_toutiao;

import java.util.Scanner;

class SegmentTreeNode {
    int start, end;
    int max, min;
    SegmentTreeNode ltree, rtree;

    public SegmentTreeNode(int s, int e) {
        start = s;
        end = e;
    }
}

public class fourth {
    //static SegmentTreeNode root = null;

    public static SegmentTreeNode NumArray(SegmentTreeNode root, int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        root = buildTree(nums, 0, nums.length - 1);
        return root;

    }

    public static SegmentTreeNode buildTree(int[] nums, int left, int right) {
        SegmentTreeNode root = new SegmentTreeNode(left, right);
        if (left == right) {
            root.max = nums[left];
            root.min = nums[left];
        } else {
            int mid = left + (right - left) / 2;
            root.ltree = buildTree(nums, left, mid);
            root.rtree = buildTree(nums, mid + 1, right);
            root.max = Math.max(root.ltree.max, root.rtree.max);
            root.min = Math.max(root.ltree.min, root.rtree.min);
        }
        return root;
    }

  /*  static void update(int i, int val) {
        update(root, i, val);
    }*/

    private static void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.max = val;
            root.min = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.ltree, i, val);
            } else {
                update(root.rtree, i, val);
            }
            root.max = Math.max(root.ltree.max, root.rtree.max);
            root.min = Math.max(root.ltree.min, root.rtree.min);
        }
    }

    /*  public static int sumRange(int i, int j) {
          return sumRange(root, i, j);
      }
  */
    private static int sumRangeMax(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.max;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (j <= mid) {
                return sumRangeMax(root.ltree, i, j);
            } else if (i > mid) {
                return sumRangeMax(root.rtree, i, j);
            } else {
                return sumRangeMax(root.ltree, i, root.ltree.end) + sumRangeMax(root.rtree, root.rtree.start, j);
            }
        }
    }

    private static int sumRangeMin(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.min;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (j <= mid) {
                return sumRangeMin(root.ltree, i, j);
            } else if (i > mid) {
                return sumRangeMin(root.rtree, i, j);
            } else {
                return sumRangeMin(root.ltree, i, root.ltree.end) + sumRangeMin(root.rtree, root.rtree.start, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] num1 = new int[len];
        int[] num2 = new int[len];
        for (int i = 0; i < len; i++)
            num1[i] = sc.nextInt();
        for (int i = 0; i < len; i++)
            num2[i] = sc.nextInt();
        SegmentTreeNode root1 = null;
        SegmentTreeNode root2 = null;
        root1 = NumArray(root1, num1);
        root2 = NumArray(root2, num2);
        int flag = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (sumRangeMax(root1, i, j) < sumRangeMin(root2, i, j))
                    flag++;
            }
        }
        System.out.print(flag);
    }
}
