package Niuke.netease.game;


import java.util.Scanner;

public class second {

    static int check(char c) {
        int tmp = c - '0';
        if (tmp >= 0 && tmp <= 9)
            return tmp;
        tmp = c - 'A';
        if (tmp >= 0 && tmp <= 5)
            return 10 + tmp;
        return 0;
    }

    static int trans(String s, int base) {
        int res = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int tmp_res = check(s.charAt(i));
            res += tmp_res * (Math.pow(base, s.length() - 1 - i));
        }
        return res;
    }

    static boolean needCheck(String s1, String s2) {
        if (s1.startsWith("0") && s1.length() > 1)
            return false;
        if (s2.startsWith("0") && s2.length() > 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        for (int e = 0; e < k; e++) {
            int n = s.nextInt();
            int m = s.nextInt();
            String target = s.nextLine();
            boolean iffind = false;
            for (int i = 1; i < target.length(); i++) {
                String a = target.substring(0, i);
                String b = target.substring(i);
                if (needCheck(a, b)) {
                    int v1 = trans(a, n);
                    int v2 = trans(b, m);
                    //System.out.println(v1 + " " + v2);
                    if (v1 == v2) {
                        System.out.println(v1);
                        iffind = true;
                        break;
                    }
                }
            }
            if (!iffind) {
                for (int i = 1; i < target.length(); i++) {
                    String a = target.substring(0, i);
                    String b = target.substring(i);
                    if (needCheck(a, b)) {
                        int v1 = trans(a, m);
                        int v2 = trans(b, n);
                        //System.out.println(v1 + " " + v2);
                        if (v1 == v2) {
                            System.out.println(v1);
                            break;
                        }
                    }
                }
            }

        }
    }
}
