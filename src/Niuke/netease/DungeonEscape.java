package Niuke.netease;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//地牢逃脱
//题目描述
//给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，
//遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边
//界，也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开
//这个地牢。
//输入描述:
//每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。
//接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。接下来的一行，包含两个整数 x0, y0，表示牛牛
//的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），出发位置一定是 '.'）。之后的一行包含一个整
//数 k（0 < k <= 50）表示牛牛合法的步长数，接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长
//（-50 <= dx, dy <= 50）
//输出描述:
//输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。以下测试用例中，牛牛可以
//上下左右移动，在所有可通行的位置.上，地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。
//输入
//3 3
//...
//...
//...
//0 1
//4
//1 0
//0 1
//-1 0
//0 -1
//输出
//3
public class DungeonEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        //the map
        char[][] points = new char[row][col];
        //count step's length
        int[][] count = new int[row][col];
        for (int i = 0; i < row; i++) {
            String str = sc.nextLine();
            points[i] = str.toCharArray();
        }
        //start point
        int startx = sc.nextInt();
        int starty = sc.nextInt();
        //types of step
        int stepnums = sc.nextInt();
        int[] stepx = new int[stepnums];
        int[] stepy = new int[stepnums];
        for (int i = 0; i < stepnums; i++) {
            stepx[i] = sc.nextInt();
            stepy[i] = sc.nextInt();
        }
        //keep the step
        Queue<Integer> xqueue = new LinkedList<Integer>();
        Queue<Integer> yqueue = new LinkedList<Integer>();

        ((LinkedList<Integer>) xqueue).add(startx);
        ((LinkedList<Integer>) yqueue).add(starty);

        count[startx][starty] = 1;
        while (!xqueue.isEmpty() && !yqueue.isEmpty()) {
            startx = xqueue.remove();
            starty = yqueue.remove();
            //iterate all types of step
            for (int i = 0; i < stepnums; i++) {
                if (startx + stepx[i] < row && startx + stepx[i] >= 0 && starty + stepy[i] < col && starty + stepy[i] >= 0) {
                    //not arrive
                    if (count[startx + stepx[i]][starty + stepy[i]] == 0) {
                        if (points[startx + stepx[i]][starty + stepy[i]] == '.') {
                            count[startx + stepx[i]][starty + stepy[i]] = count[startx][starty] + 1;
                            ((LinkedList<Integer>) xqueue).add(startx + stepx[i]);
                            ((LinkedList<Integer>) xqueue).add(starty + stepy[i]);
                        } else
                            count[startx + stepx[i]][starty + stepy[i]] = -1;
                    }
                }
            }
            int max = 0;
            boolean flag = true;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (points[i][j] == '.' && count[i][j] == 0) {
                        flag = false;
                    }
                    max = Math.max(max, count[i][j]);
                }
            }
            if (!flag) {
                System.out.println(-1);
            } else {
                System.out.println(max - 1);
            }
        }
    }
}
