package Niuke.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//水仙花
//题目描述
//春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的： “水仙花数”是指一个三位数，它
//的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
//输入描述:
//输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
//输出描述:
//对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,并且小于等于n，如果有
//多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;
//如果给定的范围内不存在水仙花数，则输出no;
//每个测试实例的输出占一行。
//示例1
//输入
//100 120
//300 380
//输出
//no
//370 371
public class FaffodilsNum {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bf.readLine()) != null) {
            String[] str = line.split(" ");
            int m = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[1]);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = m; i < n; i++) {
                int a = i / 100;
                int b = (i - a * 100) / 10;
                int c = i - a * 100 - b * 10;
                if (a * a * a + b * b * b + c * c * c == i) {
                    stringBuilder.append(i + "");
                }
            }
            if (stringBuilder.toString().equals("")) {
                System.out.println("no");
            } else {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
