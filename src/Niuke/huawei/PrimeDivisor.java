package Niuke.huawei;

import java.util.Scanner;

//质数因子
//题目描述
//功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
public class PrimeDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int pum = 2;
        StringBuffer sb = new StringBuffer();
        while (num != 1) {
            while (num % pum == 0) {
                num = num / pum;
                sb.append(pum).append(" ");
            }
            pum++;
        }
        System.out.println(sb.toString());
    }
}
