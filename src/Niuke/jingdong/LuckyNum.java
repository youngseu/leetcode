package Niuke.jingdong;

import java.util.Scanner;

public class LuckyNum {
    public int f(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 2;
            num /= 2;
        }
        return sum;
    }

    public int g(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        LuckyNum l = new LuckyNum();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (l.g(i) == l.f(i)) count++;
        }
        System.out.println(count);
    }
}
