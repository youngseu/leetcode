package Niuke.toutiao.contest_toutiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//满足条件二元数组的最大值
//要求：给出一个二元数组（a，b），从中找出两个集合,这两个集合的sum(a)相等，元素不能重复选，求Max sum(b) ，即
//两个集合的b加起来最大。
//输入
//4
//1 2
//1 2
//2 6
//3 1
public class third {
    class Card {
        public int x;
        public int y;
        boolean valid;

        Card() {
            valid = true;
        }
    }

    public static int[][] f = new int[101][100005];
    public static boolean[] g = new boolean[100005];

    public static boolean isValid(List<Integer> arrays, int sum) {
        for (int i = 0; i <= sum; i++) {
            g[i] = false;
        }
        int tmp = 0;
        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j <= tmp; j++) {
                if (g[j]) g[j + arrays.get(i)] = true;
            }
            g[arrays.get(i)] = true;
            tmp += arrays.get(i);
        }
        if (g[sum / 2]) return true;
        else return false;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine().trim());
        int sum = 0;
        Card[] cards = new Card[num];
        for (int i = 0; i < num; i++) {
            String[] strs = bf.readLine().trim().split(" ");
            cards[i].x = Integer.parseInt(strs[0]);
            cards[i].y = Integer.parseInt(strs[1]);
            sum += cards[i].x;
        }
        for (int i = 0; i < num; i++)
            for (int j = 0; j < sum; j++)
                f[i][j] = -1;
        f[0][0] = 0;
        f[0][cards[0].x] = cards[0].y;
        for (int i = 1; i < num; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= cards[i].x && f[i - 1][j - cards[i].x] != -1) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - cards[i].x] + cards[i].y);
                }
            }
        }
        for (int i = sum; i > 0; i--) {
            if (i % 2 == 0) {
                LinkedList<Integer> candidate = new LinkedList<>();
                int j = i;
                for (int k = num - 1; k > 0; k--) {
                    if (f[i][j] != f[i - 1][j]) {
                        candidate.add(cards[k].x);
                        j -= cards[k].x;
                    }
                }
                if (j >0)
                    candidate.add(cards[0].x);
                if (isValid(candidate, i)) {
                    System.out.println(f[sum-1][i]);
                    break;
                }
            }
        }


    }
}
