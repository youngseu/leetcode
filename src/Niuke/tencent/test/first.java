package Niuke.tencent.test;

import java.util.*;

public class first {
    //gcd
    public static long gcd(long a, long b) {
        while (a % b != 0) {
            long c = a % b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dpn = new long[1000005];
        long[] dpm = new long[1000005];

        dpn[1] = 1;
        int m = n + 1;
        dpm[m] = m;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 2; i <= n + 1; i++) {
//            if (map.get())
            long g = gcd(dpn[i - 1], i);
            dpn[i] = (dpn[i - 1] * i) / g;
        }
        long preN = dpn[n + 1];
        long preM = dpm[n + 1];

        m++;
        if (dpn[m - 1] == dpm[m - 1]) {
            System.out.println(m - 1);
        } else {
            for (; ; m++) {
                long g1 = gcd(preN, m);
                preN = (preN * m) / g1;

                long g2 = gcd(preM, m);
                preM = (preM * m) / g2;

                if (preN == preM) {
                    System.out.println(m);
                    break;
                }
            }
        }
    }
}
