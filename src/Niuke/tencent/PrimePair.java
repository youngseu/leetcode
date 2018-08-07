package Niuke.tencent;

import java.util.Scanner;

//素数对
//题目描述
//给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
//如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
public class PrimePair {
    public static boolean isprime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        for (int i = 2; i <= num / 2; i++) {
            if (isprime(i) && isprime(num - i)) sum++;
        }
        System.out.println(sum);
    }
}
