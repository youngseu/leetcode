package Niuke.netease.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
2
5 2 5 1
1 2 string dfs
1 1 heap
2 1 dfs
3 2 math search
4 1 dp
5 2 5 0
1 2 string dfs
1 1 heap
2 1 dfs
3 2 math search
4 1 dp
 */
class Problem {
    public int nandu;
    public List<String> tags;

    public Problem(int nandu, List<String> tags) {
        this.nandu = nandu;
        this.tags = tags;
    }
}

public class third {
    public static int count = 0;

    public static void dfs(int n, int m, int l, int s, List<Problem> list, List<Problem> temp, int start) {
        if (temp.size() == m) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < temp.size(); i++) {
                sum += temp.get(i).nandu;
                min = Math.min(min, temp.get(i).nandu);
                max = Math.max(max, temp.get(i).nandu);
                for (String s1 : temp.get(i).tags) {
                    int c = map.getOrDefault(s1, 0);
                    if (c == 0)
                        map.put(s1, 1);
                    else return;
                }
            }
            if (sum <= l && max - min >= s) {
                count++;
                return;
            }
        } else if (start < n) {
            for (int i = start; i < n; i++) {
                temp.add(list.get(i));
                dfs(n, m, l, s, list, temp, i + 1);
                temp.remove(temp.remove(temp.size() - 1));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine().trim());
        for (int i = 0; i < num; i++) {
            String[] str = bf.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int L = Integer.parseInt(str[2]);
            int S = Integer.parseInt(str[3]);

            ArrayList<Problem> arrays = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String[] input = bf.readLine().trim().split(" ");
                int nandu = Integer.parseInt(input[0]);
                int tagslen = Integer.parseInt(input[1]);
                LinkedList<String> list = new LinkedList<>();
                for (int k = 0; k < tagslen; k++) {
                    list.add(input[2 + k]);
                }
                arrays.add(new Problem(nandu, list));
            }

            dfs(N, M, L, S, arrays, new ArrayList<Problem>(), 0);
            System.out.println(count);
            count = 0;
        }

    }
}
