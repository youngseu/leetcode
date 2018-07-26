package Niuke.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//数和
//题目描述
//输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
//输入描述:
//每个测试输入包含2个整数,n和m
//输出描述:
//按每个组合的字典序排列输出,每行输出一种组合
//示例1
//输入
//5 5
//输出
//1 4
//2 3
//5
public class TargetSum {
    public static void backtracing(int max, int target, int cur, List<Integer> tmp, List<List<Integer>> res) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = cur; i <= max; i++) {
                tmp.add(i);
                backtracing(max, target - i, i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int target = sc.nextInt();
        List<List<Integer>> res = new ArrayList();
        backtracing(sum, target, 1, new ArrayList<>(), res);
        for (int i = 0; i < res.size(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < res.get(i).size(); j++) {
                sb.append(res.get(i).get(j) + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
