package Niuke.didi;

import java.math.BigInteger;
import java.util.Scanner;

//进制转换
//题目描述
//给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
//输入描述:
//输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
//输出描述:
//为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
//示例1
//输入
//7 2
//输出
//111
public class RadixChange {
    static final char[] formation = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int tmp = num;
        int radix = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = Math.abs(num);
        }
        while (num != 0) {
            sb.append(formation[num % radix]);
            num /= radix;
        }
        sb.reverse();
        if (flag) {
            System.out.print('-');
            System.out.print(sb.toString());
        } else
            System.out.println(sb.toString());

        BigInteger bi = new BigInteger(String.valueOf(tmp), 10);
        System.out.println(bi.toString(radix).toUpperCase());
    }
}
