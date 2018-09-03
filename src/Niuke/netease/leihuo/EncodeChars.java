package Niuke.netease.leihuo;

import java.util.Scanner;

//字符串编码
//给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。比如字符串AAAABCCDAA会被编码
//成4A1B2C1D2A。
//输入描述:
//每个测试输入包含1个测试用例
//每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。
//输出描述:
//输出编码后的字符串
//输入例子1:
//AAAABCCDAA
//输出例子1:
//4A1B2C1D2A
public class EncodeChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char tmp = input.charAt(0);
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == tmp) count++;
            else {
                sb.append(count).append(tmp);
                tmp = input.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(tmp);
        System.out.println(sb.toString());
    }
}
