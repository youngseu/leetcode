package Niuke.easy;

import java.math.BigInteger;
import java.util.Scanner;

//现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同
//时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新
//数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
//输入描述:
//输入数据为一行，包含9997个数字，空格隔开。
//输出描述:
//输出为一行，包含一个数字。
public class LostThree {
    public static void main(String[] args) {
        int[] numarray = new int[10001];
        Scanner sc = new Scanner(System.in);
        int t = 0;
        for (int i = 0; i < 9997; i++) {
            t = sc.nextInt();
            numarray[t] = 1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 10000; i++) {
            if (numarray[i] == 0) {
                sb.append(i);
            }
        }
        BigInteger b = new BigInteger(sb.toString());
        System.out.println(b.mod(BigInteger.valueOf(7)));
    }
}
