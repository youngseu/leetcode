package Niuke.didi.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Count {
    String s;
    int cost;

    public Count(String s, int cost) {
        this.s = s;
        this.cost = cost;
    }
}

public class first {


    static char[] chars = new char[]{'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};


    public static int finMinCost(String A, int n, String B, int m, int ic, int dc) {
        if (A == null || B == null) return 0;
        if (n == 0) return m * ic;
        if (m == 0) return n * ic;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //gai
                    int count = 0;
                    for (int k = 0; k < chars.length; k++) {
                        if (A.charAt(i - 1) == chars[k]) count++;
                        if (B.charAt(j - 1) == chars[k]) count++;
                    }
                    if (count == 0 || count == 2) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else if (count == 1) dp[i][j] = dp[i - 1][j - 1] + 2;

                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine().trim().toLowerCase();
        String[] strs = input.split(" ");
        ArrayList<Count> list = new ArrayList<>();
        for (int i = 1; i < strs.length; i++) {
            int cost = finMinCost(strs[0], strs[0].length(), strs[i], strs[i].length(), 3, 3);
            list.add(new Count(strs[i], cost));
        }
        Collections.sort(list, ((o1, o2) -> o1.cost - o2.cost));
        StringBuffer sb = new StringBuffer();
        int first = list.get(0).cost;
        int sec = list.get(1).cost;
        int third = list.get(2).cost;
        if (first == sec && first == third) {
            int count = 0;
            for (int i = 1; i < strs.length && count < 3; i++) {
//                if (list.get(count).cost ) {
//                    sb.append(list.get(i).s + " ");
//                    count++;
//                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                sb.append(list.get(i).s + " ");
            }
        }
    }
}
