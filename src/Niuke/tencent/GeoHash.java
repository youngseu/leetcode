package Niuke.tencent;

import java.util.Scanner;

//geohash编码
public class GeoHash {
    public static void main(String args[]) {
        System.out.println((45 + 90) / 2);
        System.out.println((45 + 90) >> 1);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int start = -90;
        int end = 90;
        for (int i = 0; i < 6; i++) {
//            int mid = (start + end)>>1; error
            int mid = (start + end) / 2;
            if (start <= num && num < mid) {
                System.out.print("0");
                end = mid;
            } else if (mid <= num && num <= end) {
                System.out.print("1");
                start = mid;
            }
            System.out.println(mid);
        }
    }
}
