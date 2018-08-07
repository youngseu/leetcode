package Niuke.huawei;

import java.math.BigInteger;
import java.util.Scanner;

//进制转换
//题目描述
//写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
//
//输入描述:
//输入一个十六进制的数值字符串。
//
//输出描述:
//输出该数值的十进制字符串。
public class Radix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next().substring(2);

            BigInteger bi = new BigInteger(str, 16);
            System.out.println(bi.toString(10));

            System.out.println(Integer.parseInt(str, 16));
        }
    }
}
