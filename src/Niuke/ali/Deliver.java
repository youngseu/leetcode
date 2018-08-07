package Niuke.ali;

import java.util.Scanner;

//point class
class MyPoint {
    int x;
    int y;
    boolean flag;

    public MyPoint(int col, int row) {
        x = col;
        y = row;
        //mark whether visited
        this.flag = false;
    }

    public int getDistance(MyPoint point) {
        return Math.abs(x - point.x) + Math.abs(y - point.y);
    }

}

//物流配送
public class Deliver {
    static MyPoint startpoint = new MyPoint(0, 0);
    static int minpath = Integer.MAX_VALUE;

    //backtracing
    public static int backtracing(MyPoint start, MyPoint[] pointsarray, int sum, int count) {
        //all visited
        if (count == pointsarray.length) {
            minpath = Math.min(minpath, sum + start.getDistance(startpoint));
            return minpath;
        }
        //every point
        for (int i = 0; i < pointsarray.length; i++) {
            if (pointsarray[i].flag == false) {
                sum += pointsarray[i].getDistance(start);
                if (sum <= minpath) {
                    pointsarray[i].flag = true;
                    backtracing(pointsarray[i], pointsarray, sum, count + 1);
                }
                sum -= pointsarray[i].getDistance(start);
                pointsarray[i].flag = false;
            }
        }
        return minpath;
    }

    public static void main(String[] args) {
        int sumdistance = 0, countstep = 0;
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        MyPoint[] points = new MyPoint[num];
        for (int i = 0; i < num; i++) {
            String str[] = sc.nextLine().trim().split(",");
            points[i] = new MyPoint(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        System.out.print(backtracing(startpoint, points, sumdistance, countstep));
    }
}
