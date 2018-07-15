package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//题目描述
//二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕
//的欧几里得距离不能等于2。
//对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
//( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
//小易想知道最多可以放多少块蛋糕在网格盒子里。
//输入描述:
//每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
//输出描述:
//输出一个最多可以放的蛋糕数
//输入
//3 2
//输出
//4
public class NotTwo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().trim().split(" ");
        int row = Integer.parseInt(arg[0]);
        int col = Integer.parseInt(arg[1]);
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(flag[i], true);
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (flag[i][j]) {
                    count++;
                    if (i + 2 < row) flag[i + 2][j] = false;
                    if (j + 2 < col) flag[i][j + 2] = false;
                }
            }
        }
        System.out.println(count);
    }
    //基于数学规律的统计
}
