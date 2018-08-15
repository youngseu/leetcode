package Niuke.netease.contest_huyu;

import java.util.*;

//题目描述
//给你n个a,m个z组成所有可能的字符串，并将字符串按字典序从小到大排列，输出第k个字符串。
//若不存在，输出-1。
//输入描述
//第一行为三个数，分别为a的个数n,z的个数m,第k个字符串。
//输出描述
//第k个字符串
//输入
//2 2 6
//输出
//zzaa
public class third {
    static int sum;

    //overtime
    public static List<List<Integer>> permute(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Set<List<Integer>> tmp = new HashSet<>();
        Arrays.sort(nums);
        backtracing(res, new ArrayList<Integer>(), tmp, nums, 0);
        for (int i = 0; i < nums.length; i++) {
            if (res.get(target - 1).get(i) == 0)
                System.out.print('a');
            else
                System.out.print('z');
        }
        return null;
    }

    public static void backtracing(List<List<Integer>> res, List<Integer> list, Set<List<Integer>> tmp, int[] nums, int tmpsum) {
        if (list.size() == nums.length) {
            if (tmpsum == sum && !tmp.contains(list)) {
                res.add(new ArrayList<>(list));
                tmp.add(list);
            }
        } else for (int i = 0; i < nums.length; i++) {
            //if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtracing(res, list, tmp, nums, tmpsum + nums[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n + m];
        for (int i = 0; i < n; i++)
            nums[i] = 'a' - 'a';
        for (int i = 0; i < m; i++)
            nums[i] = 'z' - 'a';
        sum = 0 * n + 25 * m;
        permute(nums, target);
    }
}