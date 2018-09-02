package Niuke.tencent;

import java.util.Scanner;

//小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，每首歌最多只能在歌单中
//出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
//输入描述:
//每个输入包含一个测试用例。
//每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
//接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。
//保证A不等于B。
//输出描述:
//输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。
//示例1
//输入
//5
//2 3 3 3
//输出
//9
public class ArrangeSongAns {
    public static long[][] c = new long[105][105];
    public static int mod = 1000000007;

    //利用数学归纳法：
    //由C(n,k) = C(n-1,k) + C(n-1,k-1）；
    //对应于杨辉三角：
    //1
    //1 1
    //1 2 1
    //1 3 3 1
    //1 4 6 4 1
    public static void init() {
        c[0][0] = 1;
        for (int i = 1; i <= 100; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= 100; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
            }
        }
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int aNum = sc.nextInt();
        int aLength = sc.nextInt();
        int bNum = sc.nextInt();
        int bLength = sc.nextInt();
        long sum = 0;
        for (int i = 0; i <= aLength; i++) {
            for (int j = 0; j <= bLength; j++) {
                if (i * aNum + j * bNum > target) break;
                if ((i * aNum + j * bNum) == target) sum += c[aLength][i] * c[bLength][j];
            }
        }
        System.out.println(sum % mod);
    }
}
