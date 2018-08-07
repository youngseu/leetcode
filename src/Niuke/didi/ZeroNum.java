package Niuke.didi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//末尾0的个数
//题目描述
//输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
public class ZeroNum {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int count = 0;
        while (n / 5 != 0) {
            n /= 5;
            count += n;
        }
        System.out.println(count);
    }
}
