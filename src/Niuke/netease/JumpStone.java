package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//眺石板
//题目描述
//小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
//这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，
//即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道
//最少需要跳跃几次可以到达。
//例如：
//N = 4，M = 24：
//4->6->8->12->18->24
//于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
//输入描述:
//输入为一行，有两个整数N，M，以空格隔开。 (4 ≤ N ≤ 100000) (N ≤ M ≤ 100000)
//输出描述:
//输出小易最少需要跳跃的步数,如果不能到达输出-1
public class JumpStone {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().trim().split(" ");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[m] = 0;

        for (int i = m; i <= n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0 && i + j <= n) {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                        if (j != i / j && i + i / j <= n) {
                            dp[i + i / j] = Math.min(dp[i + i / j], dp[i] + 1);
                        }
                    }
                }
            }
        }
        if (dp[n] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
