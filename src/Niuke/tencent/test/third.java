package Niuke.tencent.test;

import java.util.*;

public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            boolean flag = false;
            for (int j = 0; j < 100000; j++) {
                int s = B * j + C;
                int m = s / A;
                if (m * A == s) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
            }
        }
    }
}
