package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//数字翻转
//题目描述
//对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
//如果 X = 123，则rev(X) = 321;
//如果 X = 100，则rev(X) = 1.
//现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
//输入描述:
//输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
//输出描述:
//输出rev(rev(x) + rev(y))的值
//示例1
//输入
//123 100
//输出
//223
public class ReverseNum {
    //easy
    public static int rev(int num) {
        int x = 0;
        while (num != 0) {
            x = 10 * x + num % 10;
            num = num / 10;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = bf.readLine().trim().split(" ");
        StringBuffer a = new StringBuffer(nums[0]);
        StringBuffer b = new StringBuffer(nums[1]);
        int sum = Integer.parseInt(a.reverse().toString()) + Integer.parseInt(b.reverse().toString());
        System.out.println(Integer.parseInt(new StringBuffer(String.valueOf(sum)).reverse().toString()));
    }
}
