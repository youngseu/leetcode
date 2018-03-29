package Math;

import java.util.Scanner;
//矩阵旋转90°
public class RotateRectangle {
    public static void rotate(String[][] matrix, int num) {
        String[][] copy = new String[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                copy[i][j] = matrix[num - j - 1][i];
                System.out.print(copy[i][j] + ' ');
                if (j == num -1)
                    System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] chars = line.split(" ");
        int num = chars.length;
        String[][] strings = new String[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == 0) strings[i][j] = chars[j];
                else
                    strings[i][j] = sc.next();
            }
        }
        rotate(strings, num);
    }
}
