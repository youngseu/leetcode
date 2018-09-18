package Niuke.toutiao.contest_toutiao2;

import java.util.*;

//https://www.nowcoder.com/discuss/98663?type=2&order=0&pos=10&page=1
/*
in:
4 3
10 3 7 5
out:
4
*/
public class fourth {
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int T = scanner.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = scanner.nextInt();
        }
        scanner.close();
        TreeSet<Integer> set = new TreeSet<>();
        for (int d : data) {
            set.add(d);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < N; i++) {
            data[i] = Collections.binarySearch(list, data[i]);
        }

        int[] dp = new int[N];

        int ans = 0;
        for (int i = 0; i < Math.min(T, N); i++) {
            for (int j = 0; j < N; j++) {
                for (int k = data[j]; k >= 0; k--) {
                    dp[data[j]] = Math.max(dp[data[j]], dp[k] + 1);
                }
                ans = Math.max(ans, dp[data[j]]);
            }
        }

        int[] cnt = new int[N];
        for (int d : data)
            cnt[d]++;
        Arrays.sort(cnt);
        ans += cnt[N - 1] * Math.max(0, T - N);

        System.out.println(ans);
    }

    public static void main(String[] args) {
        new fourth().solve();
    }

}
