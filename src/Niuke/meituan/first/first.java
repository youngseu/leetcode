package Niuke.meituan.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。假设你从1号节点
//出发并打算遍历所有节点，那么总路程至少是多少？
//输入
//第一行包含一个整数N，1≤N≤100000。
//接下来N-1行，每行包含两个整数X和Y，表示X号节点和Y号节点之间有一条边，1≤X，Y≤N。
//输出
//输出总路程的最小值。
//输入
//4
//1 2
//1 3
//3 4
//输出
//4
public class first {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int[] height = new int[n + 1];
        height[1] = 1;
        for (int i = 0; i < n - 1; i++) {
            String[] input = bf.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (height[a] != 0) height[b] = height[a] + 1;
            else height[a] = height[b] + 1;
        }
        int maxHeight = 0;
        for (int i = 1; i <= n; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
        }
        System.out.println(2 * n - 2 - (maxHeight - 1));
    }
}
