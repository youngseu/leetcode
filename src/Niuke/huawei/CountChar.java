package Niuke.huawei;

import java.util.Scanner;

//计算字符个数
//不区分大小写
public class CountChar {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String tc = sc.nextLine().toLowerCase();

        char t = tc.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) count++;
        }
        System.out.println(count);
    }
}
