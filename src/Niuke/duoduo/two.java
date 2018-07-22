package Niuke.duoduo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class two {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = bf.readLine().trim().split(" ");
        int m = Integer.parseInt(arg[0]);
        int n = Integer.parseInt(arg[1]);
        if (m == 1) {
            System.out.println("0");
        } else {
            int[] point = new int[m];
            Arrays.fill(point, 0);
            for (int i = 0; i < n; i++) {
                String line = bf.readLine().trim();
                for (int j = 0; j < m; j++) {
                    point[j] -= line.charAt(j);
                }
            }
            int[] copy = Arrays.copyOf(point, point.length);
            Arrays.sort(copy);
            if (copy[copy.length - 1] == copy[copy.length - 2]) {
                System.out.println("-1");
            } else {
                for (int i = 0; i < m; i++) {
                    if (point[i] == copy[copy.length - 1]) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
}
