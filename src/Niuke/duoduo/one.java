package Niuke.duoduo;

import java.util.Scanner;
//喝可乐
//"Alice", "Bob", "Cathy", "Dave"四类人喝可乐，每次喝完可乐，每累人的人数会变为原来的两倍，第一轮为
//"Alice", "Bob", "Cathy", "Dave"，则第二轮为"Alice","Alice", "Bob", "Bob", "Cathy", "Cathy","Dave"，"Dave"
//求第N瓶可乐是哪一类人喝的
//输入仅一行，包含一个正整数N（1<=N<=1,000,000,000），表示可乐的数量
//示例
//输入
//8
//输出
//Bob
public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        String[] ans = new String[]{"Alice", "Bob", "Cathy", "Dave"};
        int order = 1;
        while (4 * (Math.pow(2, order) - 1) < num) {
            order++;
        }
        double dis = num - (4 * (Math.pow(2, order-1) - 1));
        for (int i = 1; i <= 4; i++) {
            if (dis - i* Math.pow(2, order-1) <= 0) {
                System.out.println(ans[i-1]);
                break;
            }
        }
    }
}
