package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//题目描述
//考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如：
//"car" < "carriage" < "cats" < "doggies < "koala"
//2.根据字符串的长度排序。例如：
//"car" < "cats" < "koala" < "doggies" < "carriage"
//考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
//输入描述:
//输入第一行为字符串个数n(n ≤ 100)
//接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
//输出描述:
//如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",
//如果根据长度排列而不是字典序排列输出"lengths",
//如果两种方式都符合输出"both"，否则输出"none"
//输入
//3
//a
//aa
//bbb
//输出
//both
public class TwoSorts {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = bf.readLine().trim();
        }
        if (lexico(strs) && lengths(strs)) {
            System.out.println("both");
        } else if (lexico(strs)) {
            System.out.println("lexicographically");
        } else if (lengths(strs)) {
            System.out.println("lengths");
        } else {
            System.out.println("none");
        }
    }

    //compareto用于判断字典序
    public static boolean lexico(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i + 1].compareTo(strings[i]) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean lengths(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].length() > strings[i + 1].length()) {
                return false;
            }
        }
        return true;
    }
}
