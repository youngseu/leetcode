package Niuke.ali.first;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class second {
    public double pointToLine(int x1, int y1, int x2, int y2, int x0,
                              int y0) {
        double space = 0;
        double a, b, c;
        a = lineSpace(x1, y1, x2, y2);
        b = lineSpace(x1, y1, x0, y0);
        c = lineSpace(x2, y2, x0, y0);
        if (c <= 0.000001 || b <= 0.000001) {
            space = 0;
            return space;
        }
        if (a <= 0.000001) {
            space = b;
            return space;
        }
        if (c * c >= a * a + b * b) {
            space = b;
            return space;
        }
        if (b * b >= a * a + c * c) {
            space = c;
            return space;
        }
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        space = 2 * s / a;
        return space;
    }

    private double lineSpace(int x1, int y1, int x2, int y2) {
        double lineLength = 0;
        lineLength = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2)
                * (y1 - y2));
        return lineLength;
    }

    public static boolean IsPtInPoly(Point2D.Double point, List<Point2D.Double> pts) {

        int N = pts.size();
        boolean boundOrVertex = true;
        int intersectCount = 0;
        double precision = 2e-10;
        Point2D.Double p1, p2;
        Point2D.Double p = point;

        p1 = pts.get(0);
        for (int i = 1; i <= N; ++i) {
            if (p.equals(p1)) {
                return boundOrVertex;
            }

            p2 = pts.get(i % N);
            if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {
                p1 = p2;
                continue;
            }

            if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {
                if (p.y <= Math.max(p1.y, p2.y)) {
                    if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {
                        return boundOrVertex;
                    }

                    if (p1.y == p2.y) {
                        if (p1.y == p.y) {
                            return boundOrVertex;
                        } else {
                            ++intersectCount;
                        }
                    } else {
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;
                        if (Math.abs(p.y - xinters) < precision) {
                            return boundOrVertex;
                        }

                        if (p.y < xinters) {
                            ++intersectCount;
                        }
                    }
                }
            } else {
                if (p.x == p2.x && p.y <= p2.y) {
                    Point2D.Double p3 = pts.get((i + 1) % N);
                    if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {
                        ++intersectCount;
                    } else {
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;
        }

        if (intersectCount % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().trim().split(",");
        int tx = Integer.parseInt(input[0]);
        int ty = Integer.parseInt(input[1]);
        Point2D.Double point = new Point2D.Double(tx, ty);
        List<Point2D.Double> pts = new ArrayList<Point2D.Double>();
        String[] inputs = bf.readLine().trim().split(",");
        for (int i = 0; 2 * i < inputs.length; i++) {
            pts.add(new Point2D.Double(Integer.parseInt(inputs[2 * i]), Integer.parseInt(inputs[2 * i + 1])));
        }

        double min = Integer.MAX_VALUE;
        if (IsPtInPoly(point, pts)) {
            System.out.println("yes,0");
        } else {
            second s = new second();
            for (int i = 0; 2 * i < pts.size(); i++) {
                double dis = s.pointToLine((int) pts.get(2 * i).getX(), (int) pts.get(2 * i).getY(),
                        (int) pts.get(2 * i + 1).getX(), (int) pts.get(2 * i + 1).getY(), tx, ty);
                min = Math.min(min, dis);
            }
            min = Math.min(min, s.pointToLine((int) pts.get(0).getX(), (int) pts.get(0).getY(),
                    (int) pts.get(pts.size() - 1).getX(), (int) pts.get(pts.size() - 1).getY(), tx, ty));
            System.out.println("no," + (int) (min + 0.5));
        }
    }
}
