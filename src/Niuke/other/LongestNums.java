package Niuke.other;

import java.util.Scanner;

//字符串中找出连续最长的数字串
//题目描述
//读入一个字符串str，输出字符串str中的连续最长的数字串
//输入描述:
//个测试输入包含1个测试用例，一个字符串str，长度不超过255。
//输出描述:
//在一行内输出str中里连续最长的数字串。
//输入
//abcd12345ed125ss123456789
//输出
//12345678
public class LongestNums {
    //记录开始位置和最大值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int res_start = 0;
        int cur_start = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                if (count == 0) {
                    cur_start = i;
                    count++;
                } else count++;
            } else {
                if (count > 0 && count > max) {
                    res_start = cur_start;
                    max = count;
                    count = 0;
                } else {
                    count = 0;
                }
            }
        }
        if (count > max)
            System.out.println(input.substring(cur_start, cur_start + count));
        else
            System.out.println(input.substring(res_start, res_start + max));
    }

    //记录末尾值和最大长度
    public static void function() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = 0, count = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;
                if (max < count) {
                    max = count;
                    end = i;
                } else {
                    count = 0;
                }
            }
        }
        System.out.println(str.substring(end - max + 1, end + 1));
    }

    //StringBuilder的replace方法
    //sb.replace(1, 2, ""); 相当于删除
}
