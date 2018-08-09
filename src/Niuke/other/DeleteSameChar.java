package Niuke.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//题目描述
//输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之
//后的第一个字符串变成”Thy r stdnts.”
//输入描述:
//每个测试输入包含2个字符串
//输出描述:
//输出删除后的字符串
//输入
//They are students. aeiou
//输出
//Thy r stdnts.
public class DeleteSameChar {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine().trim();
        String str2 = bf.readLine().trim();
        for (int i = 0; i < str2.length(); i++) {
            str1 = str1.replace(str2.charAt(i) + "", "");
        }
        System.out.println(str1);
    }

    //正则表达式
    public static void fuction() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String pattern = "[" + s2 + "]";
        String result = s1.replaceAll(pattern, "");
        System.out.println(result);

    }
}
