package Niuke.toutiao.contest_toutiao3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 雀魂启动
public class Third {
    public static final int Num = 9;

    public static boolean bingo(int[] arr, int total, boolean hasHead) {
        if (total == 0) return true;
        if (!hasHead) {
            for (int i = 0; i < 9; i++) {
                if (arr[i] > 2) {
                    arr[i] -= 2;
                    if (bingo(arr, total - 2, true)) return true;
                    arr[i] += 2;
                }
            }
        } else {
            for (int i = 0; i < 9; i++) {
                if (arr[i] > 0) {
                    if (arr[i] >= 3) {
                        arr[i] -= 3;
                        if (bingo(arr, total - 3, true)) return true;
                        arr[i] += 3;
                    }
                    if (i + 2 < 9 && arr[i + 1] > 0 && arr[i + 2] > 0) {
                        arr[i]--;
                        arr[i + 1]--;
                        arr[i + 2]--;
                        if (bingo(arr, total - 3, true)) return true;
                        arr[i]++;
                        arr[i + 1]++;
                        arr[i + 2]++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] record = new int[Num];
        int[] addRecord;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < 13; i++) {
            int num = sc.nextInt();
            record[num - 1]++;
        }

        for (int i = 0; i < 9; i++) {
            if (record[i] < 4) {
                int num = i + 1;
                addRecord = Arrays.copyOf(record, record.length);
                addRecord[i]++;
            }
        }
    }
}
