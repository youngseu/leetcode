package Niuke.other;

import java.util.Scanner;

//保留最大数
//题目描述
//给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
//输入描述:
//输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。第二行是希望去掉的数字数
//量cnt 1 ≤ cnt < length(number)。
//输出描述:
//输出保留下来的结果。
//示例1
//输入
//325 1
//输出
//35
public class SaveMaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        sb.append(sc.next());
        int cnt = sc.nextInt();
        int count = 0;
        while (count < cnt) {
            int len = sb.length() - 1;
            int s = 0;
            while (s < len && sb.charAt(s) >= sb.charAt(s + 1)) s++;
            sb.deleteCharAt(s);
            count++;
        }
        System.out.println(sb.toString());
    }
}
