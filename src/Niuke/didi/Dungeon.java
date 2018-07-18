package Niuke.didi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
//地下迷宫
//题目描述
//小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格
//子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)
//位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距
//离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到
//达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
//输入描述:
//输入包括n+1行:
// 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
// 接下来的n行:
// 每行m个0或者1,以空格分隔
//输出描述:
//如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证
//答案唯一
//输入
//4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
//输出
//[0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
public class Dungeon {
    public static boolean flag = false;
    public static int row;
    public static int col;
    public static int maxRemainEnergy = 0;
    public static int[][] map;
    public static String path = "";
    public static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = bf.readLine().trim().split(" ");

        row = Integer.parseInt(arg[0]);
        col = Integer.parseInt(arg[1]);
        int power = Integer.parseInt(arg[2]);

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] line = bf.readLine().trim().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dfs(0, 0, power);

        if (!flag) {
            System.out.println("Can not escape!");
        } else System.out.println(path);

    }

    public static void dfs(int trow, int tcol, int energy) {
        if (energy < 0 || tcol < 0 || trow < 0 || tcol >= col || trow >= row || map[trow][tcol] == 0) {
            return;
        } else {
            list.add("[" + trow + "," + tcol + "]");
            //标记被访问过
            map[trow][tcol] = 0;
            if (trow == 0 && tcol == col - 1) {
                if (energy >= maxRemainEnergy) {
                    maxRemainEnergy = energy;
                    update();
                }
                map[trow][tcol] = 1;
                list.removeLast();
                flag = true;
                return;
            }
            dfs(trow, tcol + 1, energy - 1);
            dfs(trow, tcol - 1, energy - 1);
            dfs(trow + 1, tcol, energy);
            dfs(trow - 1, tcol, energy - 3);
            map[trow][tcol] = 1;
            list.removeLast();
        }
    }

    public static void update() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next() + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        path = sb.toString();
    }
}
