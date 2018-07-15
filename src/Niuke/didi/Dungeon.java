package Niuke.didi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

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
