package Niuke.didi.contest;

import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int np = sc.nextInt(), nq = sc.nextInt(), nr = sc.nextInt();
        String a = "";
        System.out.print(count(np, nq, nr, a));
    }

    public static long count(int np, int nq, int nr, String a) {
        long res = 0;
        int size = a.length();
        if (size == 0) {
            if (np > 0) res += count(np - 1, nq, nr, a + "P");
            if (nq > 0) res += count(np, nq - 1, nr, a + "Q");
            if (nr > 0) res += count(np, nq, nr - 1, a + "R");
        } else {
            if (a.charAt(size - 1) == 'P') {
                if (nq > 0) res += count(np, nq - 1, nr, a + "Q");
                if (nr > 0) res += count(np, nq, nr - 1, a + "R");
            } else if (a.charAt(size - 1) == 'Q') {
                if (np > 0) res += count(np - 1, nq, nr, a + "P");
                if (nr > 0) res += count(np, nq, nr - 1, a + "R");
            } else if (a.charAt(size - 1) == 'R') {
                if (np > 0) res += count(np - 1, nq, nr, a + "P");
                if (nq > 0) res += count(np, nq - 1, nr, a + "Q");
            }
        }
        if (nq == 0 && np == 0 && nr == 0 && size != 0) {
            res++;
        }

        return res;
    }
}
