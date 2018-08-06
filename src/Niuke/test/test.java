package Niuke.test;

import java.math.BigInteger;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String a = "12";
        String b = "-12";
        System.out.println(Integer.parseInt(a, 3));
        System.out.println(Integer.parseInt(b, 5));

        String c = "01.2";
        String d = "0001.2";
        System.out.println(Double.parseDouble(c));
        System.out.println(Double.parseDouble(d));


//        System.out.println(new BigInteger(d));
    }
}