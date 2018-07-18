package Niuke.microsoft;

import java.util.Scanner;

public class ToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = Integer.toBinaryString(num);
        String str1 = Integer.toHexString(num);
        char[] carray = str.toCharArray();
        System.out.println(str);
        System.out.println(str1);
        int count = 0;

        for (int i = 0; i < carray.length; i++) {
            if (carray[i] == '1') {
                count++;
            }
        }
        System.out.println(count);

        while (num != 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num >> 1;
        }
        System.out.println(count);
    }
}
