package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LargestOddDivisor {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(bf.readLine());
        long sum = 0;
        for (long i = num; i > 0; i = i / 2) {
            long temp = (i + 1) / 2;
            sum += temp * temp;
        }
        System.out.println(sum);
    }
}
