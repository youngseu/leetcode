package Niuke.netease.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class secondans {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine().trim());
        for (int i = 0; i < num; i++) {
            String[] s = bf.readLine().trim().split(" ");
            int radixA = Integer.parseInt(s[0]);
            int radixB = Integer.parseInt(s[1]);
            String input = s[2];
            boolean flag = false;
            for (int j = 1; j < input.length() - 1; j++) {
                String s1 = input.substring(0, j);
                String s2 = input.substring(j);
                if (new BigInteger(s1).toString(radixA).equals(new BigInteger(s2).toString(radixB))) {
                    System.out.println(new BigInteger(s1).toString(radixA));
                    flag = true;
                    break;
                } else if (new BigInteger(s1).toString(radixB).equals(new BigInteger(s2).toString(radixA))) {
                    System.out.println(new BigInteger(s1).toString(radixB));
                    flag = true;
                    break;
                }
            }
            if (!flag) System.out.println("no");
        }

    }
}
