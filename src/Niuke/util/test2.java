package Niuke.util;

public class test2 {
    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static long gcd(long input) {
        long result = 1;
        for (int i = 1; i < input; i++) result = gcd(result, i);
        return result;
    }

    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    private static long lcm(long input)
    {
        long result = 1;
        for(int i = 1; i < input; i++) result = lcm(result, i);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lcm(50));
    }
}
