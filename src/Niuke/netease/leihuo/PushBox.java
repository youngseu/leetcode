package Niuke.netease.leihuo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//推箱子
//大家一定玩过“推箱子”这个经典的游戏。具体规则就是在一个N*M的地图上，有1个玩家、1个箱子、1个目的地以及若干障碍，其余
//是空地。玩家可以往上下左右4个方向移动，但是不能移动出地图或者移动到障碍里去。如果往这个方向移动推到了箱子，箱子也会
//按这个方向移动一格，当然，箱子也不能被推出地图或推到障碍里。当箱子被推到目的地以后，游戏目标达成。现在告诉你游戏开始
//是初始的地图布局，请你求出玩家最少需要移动多少步才能够将游戏目标达成。
//输入描述:
//每个测试输入包含1个测试用例
//第一行输入两个数字N，M表示地图的大小。其中0<N，M<=8。
//接下来有N行，每行包含M个字符表示该行地图。其中 . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
//每个地图必定包含1个玩家、1个箱子、1个目的地。
//输出描述:
//输出一个数字表示玩家最少需要移动多少步才能将游戏目标达成。当无论如何达成不了的时候，输出-1。
//输入例子1:
//4 4
//....
//..*@
//....
//.X..
//6 6
//...#..
//......
//#*##..
//..##.#
//..X...
//.@#...
//输出例子1:
//3
//11
public class PushBox {
    //四维空间的状态节点
    private static class State {
        int pr, pc, br, bc;
        State pre;

        public State(int pr, int pc, int br, int bc, State pre) {
            this.pr = pr;
            this.pc = pc;
            this.br = br;
            this.bc = bc;
            this.pre = pre;
        }
    }

    //bfs第一次遇到目标位置时 即为最短路径
    private static List<State> bfs(char[][] maze, State start) {
        int row = maze.length;
        int col = maze[0].length;

        //标记是否遍历过
        boolean[][][][] added = new boolean[row][col][row][col];

        Queue<State> queue = new LinkedList<>();
        LinkedList<State> list = new LinkedList<>();
        ((LinkedList<State>) queue).add(start);
        added[start.pr][start.pc][start.br][start.bc] = true;

        //四个方向
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        State end = null;

        //bfs保持队列
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            //到达最终目标
            if (maze[cur.br][cur.bc] == '@') {
                end = cur;
                break;
            }
            //遍历方向
            for (int[] dir : move) {
                State next = new State(cur.pr + dir[0], cur.pc + dir[1], cur.br, cur.bc, cur);
                //判断能否推箱子
                if (next.pr == next.br && next.pc == next.bc) {
                    next.br += dir[0];
                    next.bc += dir[1];
                    if (next.br < 0 || next.br >= row || next.bc < 0 || next.bc >= col || maze[next.br][next.bc] == '#')
                        continue;
                }
                //不能推箱子则人移动
                else if (next.pr < 0 || next.pr >= row || next.pc < 0 || next.pc >= col || maze[next.pr][next.pc] == '#')
                    continue;

                //更新bfs队列
                if (!added[next.pr][next.pc][next.br][next.bc]) {
                    ((LinkedList<State>) queue).add(next);
                    added[next.pr][next.pc][next.br][next.bc] = true;
                }
            }
        }
        //获得行走路径
        if (end != null) {
            while (end != null) {
                list.addFirst(end);
                end = end.pre;
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().trim().split(" ");
        int row = Integer.parseInt(arg[0]);
        int col = Integer.parseInt(arg[1]);

        int tpr = -1, tpc = -1, tbr = -1, tbc = -1;
        char[][] maze = new char[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < col; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'X') {
                    tpr = i;
                    tpc = j;
                } else if (maze[i][j] == '*') {
                    tbr = i;
                    tbc = j;
                }
            }
        }
        State start = new State(tpr, tpc, tbr, tbc, null);
        List<State> list = bfs(maze, start);
        System.out.println(list.size() - 1);
    }
}
