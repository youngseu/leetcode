package Niuke.toutiao.contest_toutiao3;

import java.util.HashMap;
import java.util.Scanner;

// 特征提取
public class Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            HashMap<String, Integer> record = new HashMap<>();
            int res = 0;
            for (int j = 0; j < m; j++) {
                String[] feature = sc.nextLine().split(" ");
                HashMap<String, Integer> trecord = new HashMap<>();
                for (int k = 1; k < feature.length; k += 2) {
                    String f = feature[k] + "," + feature[k+1];
                    int count = 1;
                    if (record.containsKey(f))
                        count = record.get(f) + 1;
                    if (count>res)
                        res = count;
                    trecord.put(f, count);
                }
                record = trecord;
            }
            System.out.println(res);
        }
    }
}
