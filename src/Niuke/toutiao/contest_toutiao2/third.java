package Niuke.toutiao.contest_toutiao2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//双生词
//POJ3349: Snowflake Snow Snowflakes
//题目：
//双生词是指如下条件的两个字符串： (假设为s和s’ )
//1、s和s’长度相同
//2、S的首尾连成环，选个位置切开，顺时针或者逆时针能够得到字符串S’
//得到S和S’是双生词，S’和S互为双生此。
//给定一批仅有英文小写字母组成的字符串、问他们之间是否有双生词。
//输入：
//首先给出测试组数t,一共多少组数据,对每组数据，第一行整数n，表示字符串数目，接下来n行，每行一个字符串。
//输出：
//对于每组数据,存在双生词，输出Yeah。不存在，输出Sad
//示例：
//输入
/*
3
2
aabfccc
ccaabfc
3
hello
ohell
lohel
2
abcd
fabc

*/
//输出
//Yeah
//Yeah
//Sad
//备注：
//对40%的数据，n<1000
//对100%的数据，1<=t<=10，n<100000，字符串长度为1-32
public class third {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine().trim());
        boolean[] flags = new boolean[num];
        for (int i = 0; i < num; i++) {
            int subnum = Integer.parseInt(bf.readLine().trim());
            String input = bf.readLine().trim();
            String source = input + input;
            for (int j = 1; j < subnum; j++) {
                if (!source.contains(bf.readLine().trim()))
                    flags[i] = true;
            }
        }
        for (int i = 0; i < num; i++) {
            if (!flags[i]) System.out.println("Yeah");
            else System.out.println("Sad");
        }
    }
}
