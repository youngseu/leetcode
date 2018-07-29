package Niuke.ali;

import java.util.*;

public class IncAndDecQueue {

    public static int sticker(int[] score) {
        int length = score.length;
        if (length == 1) return 1;
        int inc_count = 1;
        int des_count = 1;
        int equal = 0;
        int sum = 0;
        for (int i = 0; i + 1 < length; i++) {
            while (i + 1 < length && score[i] > score[i + 1]) {
                des_count++;
                i++;
            }
            if (des_count != 1) sum += (1 + des_count) * des_count / 2;
            while (i + 1 < length && score[i] < score[i + 1]) {
                inc_count++;
                i++;
            }
            if (inc_count != 1) sum += (1 + inc_count) * inc_count / 2;
            while (i + 1 < length && score[i] == score[i + 1]) {
                equal++;
                i++;
            }
            if (inc_count != 1) sum += equal * inc_count;
            else sum += equal;
            inc_count = 1;
            des_count = 1;
            equal = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        if (in.hasNextLine()) {
            str = in.nextLine();
        }
        String[] s = str.split(",");
        int[] score = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            score[i] = Integer.parseInt(s[i]);
        }
        System.out.println(sticker(score));
    }
}