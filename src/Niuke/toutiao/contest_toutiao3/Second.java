package Niuke.toutiao.contest_toutiao3;

import java.util.Scanner;

//万万没想到之抓捕孔连顺
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = sc.nextInt();
        }
        System.out.println(new Solution().totalNum(distance, D));
    }
}

class Solution{
    private final int mod = 99997867;
    private long ans = 0;

    public long totalNum(int[] dest, int dis) {
        // control start point
        for (int i = 0, j = 0; i < dest.length; i++) {
            while (i >= 2 && (dest[i] - dest[j] > dis)) {
                j++;
            }
            ans += count(i - j);
        }
        return ans % mod;
    }

    public long count(long n) {
        return n * (n - 1) / 2;
    }
}
