package Niuke.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//最强大脑
//输入描述:
//输入中有多组测试数据，每组测试数据包含三行，第一行为一个由小写拉丁字母构成的非空字符串，长度不超过10^5，表示N到M之间
//车站的颜色。火车从M向N运行时，经过的车站相同，只是方向相反。第二行为小B在第一次睡醒时看到的颜色序列，第三行为小B在第
//二次睡醒时看到的颜色序列。两个序列都是小写的拉丁字母构成的字符串，长度不超过100个字母。每个序列的颜色顺序排列按小B看
//到的时间顺序排列。
//输出描述:
//对每组测试数据，在单独的行中输出小B的旅行方向。
//forward - 由N到M方向；
//backward -由M到N方向
//both - 两种方向都有可能；
//invalid - 不可能看到这样的颜色序列；
//输入
//atob
//a
//b
//aaacaaa
//aca
//aa
//输出
//forward
//both
public class SuperBrain {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String part1 = bf.readLine();
        String part2 = bf.readLine();

        boolean forward = false;
        boolean backward = false;

        if (line.matches(".*" + part1 + ".*" + part2 + ".*")) forward = true;

        StringBuilder sb = new StringBuilder(line);

        if (sb.reverse().toString().matches(".*" + part1 + ".*" + part2 + ".*")) backward = true;

        if (forward && backward) System.out.println("both");
        else if (forward && !backward) System.out.println("forward");
        else if (!forward && backward) System.out.println("backward");
        else if (!forward && !backward) System.out.println("invalid");
    }
}
