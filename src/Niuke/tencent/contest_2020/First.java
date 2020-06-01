package Niuke.tencent.contest_2020;

import java.util.Scanner;
import java.util.Stack;

// 压缩算法
//题目：
//输入描述:
//输入第一行包含一个字符串s，代表压缩后的字符串。
//S的长度<=1000;
//S仅包含大写字母、[、]、|;
//解压后的字符串长度不超过100000;
//压缩递归层数不超过10层;
//
//输入例子1：
//
//HG[3|B[2|CA]]F
//
//输出例子1:
//
//HGBCACABCACABCACAF
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> sti = new Stack<>();
        StringBuilder res = new StringBuilder();
        String ins = sc.nextLine();
        int right = 0;
        for (char c : ins.toCharArray()) {
            res.append(c);
            if (c == '[' || c == '|')
                sti.push(right);
            if (c == ']') {
                int vindex = sti.pop();
                int left = sti.pop();
                String compress = res.substring(vindex+1, right);
                int num = Integer.parseInt(res.substring(left + 1, vindex));
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    temp.append(compress);
                }
                res.replace(left, right + 1, temp.toString());
                right = left + temp.length() - 1;
            }
            right++;
        }
        System.out.println(res.toString());
    }
}
