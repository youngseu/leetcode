package Niuke.tencent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//编码
//题目描述
//假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
//输入描述:
//输入一个待编码的字符串,字符串长度小于等于100.
//输出描述:
//输出这个编码的index
//示例1
//输入
//baca
//输出
//16331
public class Encode {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int len = str.length();
        int order = 0;
        for (int i = 0; i < len; i++) {
            int dis = str.charAt(i) - 'a';
            if (i == 0) {
                order += dis * (25 * 25 * 25 + 25 * 25 + 25 + 1) + 1;
            } else if (i == 1) {
                order += dis * (25 * 25 + 25 + 1) + 1;
            } else if (i == 2) {
                order += dis * (25 + 1) + 1;
            } else if (i == 3) {
                order += dis + 1;
            }
        }
        System.out.println(order - 1);
    }
}
