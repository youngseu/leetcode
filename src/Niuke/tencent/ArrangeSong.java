package Niuke.tencent;

import java.util.Scanner;

public class ArrangeSong {
    public static int count = 0;

    //TLE
    public static void backtrak(int[] array, int target, int start) {
        if (target < 0) return;
        else if (target == 0) {
            count++;
        } else {
            for (int i = start; i < array.length; i++) {
                backtrak(array, target - array[i], i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int aNum = sc.nextInt();
        int aLength = sc.nextInt();
        int bNum = sc.nextInt();
        int bLength = sc.nextInt();
        int[] array = new int[aLength + bLength];
        for (int i = 0; i < array.length; i++) {
            if (i < aLength) {
                array[i] = aNum;
            } else {
                array[i] = bNum;
            }
        }
        backtrak(array, target, 0);
        System.out.println(count % 1000000007);
    }
}
