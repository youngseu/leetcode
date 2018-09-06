package Niuke.ali;

import java.util.Scanner;

//在自动化仓库中有若干障碍物，机器人需要从起点出发绕过这些障碍物到终点搬取货柜，现试求机器人从起点运动到终点用时
//最短的路径。 已知机器人只能沿着东西方向或南北方向移动，移动的速度为1m/s，机器人每转向90度需要花费1s。
// 输入：
//第一行：起点位置坐标及机器人朝向，如：
//1 0 EAST
//代表机器人初始坐标为x=1,y=0，机器人面朝东方
//第二行：终点位置坐标及机器人朝向，如：
//0 2 WEST
//代表机器人需要移动至点x=0,y=2，且面朝西方
//接下来输入的是地图：
//首先是两个数字r,c，代表有地图数据有多少行与多少列，如：
//2 3
//0 1 0
//0 0 0
//其中，左上角为坐标原点，从左向右为x轴增大的方向是东方，从上到下为y轴增大的方向是南方。
//地图中1代表有障碍物，机器人不能前往，0代表无障碍物机器人可以前往 地图中相邻的每两个点之间的距离为1m。
//0 <= l,w <= 128
//输出：
//机器人从起点移动到终点所需要的最短秒数，当不可达时输出65535
public class DeliverRobot {
    private static final int MAX_PATH_LENGTH = 65535;


    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);

        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        Direction startDirection = Direction.valueOf(scanner.next());

        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        Direction endDirection = Direction.valueOf(scanner.next());

        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] map = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        //实现此函数，或 完全按照自己想法进行函数编写
        int pathLength = cal(map, startDirection, startX, startY, endDirection, endX, endY, column);
        //输出
        System.out.print(pathLength);
    }

    //bfs
    private static int cal(int[][] map, Direction startDirection, int startX, int startY,
                           Direction endDirection, int endX, int endY, int column) {

        return 0;
    }

    public enum Direction {

        EAST(0),
        WEST(1),
        SOUTH(2),
        NORTH(3),
        UNKNOWN(4);

        int index;

        public int getIndex() {
            return index;
        }

        Direction(int index) {
            this.index = index;
        }

        static Direction getDirectionByIndex(int index) {
            for (Direction direction : Direction.values()) {
                if (direction.index == index) {
                    return direction;
                }
            }
            return UNKNOWN;
        }

    }
}
