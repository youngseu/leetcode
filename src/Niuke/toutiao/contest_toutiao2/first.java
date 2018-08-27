package Niuke.toutiao.contest_toutiao2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class first {
    public static void bfs(List<List<Integer>> map, boolean[] flag, int order, TreeSet<Integer> treeSet) {
        if (flag[order + 1] == true) return;
        treeSet.add(order + 1);
        flag[order + 1] = true;
        for (int i = 0; i < map.size(); i++) {
            List<Integer> t = map.get(order);
            if (t.contains(order + 1))
                treeSet.add(i + 1);
            bfs(map,flag,i,treeSet);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine().trim());
        //邻接矩阵
        List<List<Integer>> map = new ArrayList<>(num);
        //标记
        boolean[] flag = new boolean[num + 1];
        for (int i = 0; i < num; i++) {
            String[] input = bf.readLine().trim().split(" ");
            List<Integer> tmp = new LinkedList<>();
            for (int j = 0; j < input.length; j++) {
                int mem = Integer.parseInt(input[j]);
                if (mem != 0)
                    tmp.add(mem);
            }
            map.add(tmp);
        }
        List<TreeSet<Integer>> group = new ArrayList<>();

        for (int i = 0; i < flag.length; i++) {
            if (map.get(i).size() != 0 && flag[i] == false) {
                TreeSet<Integer> treeSet = new TreeSet<>();
                bfs(map, flag, i, treeSet);
                if (treeSet.size() != 0) {
                    group.add(treeSet);
                }
            }
        }
        System.out.println(group.size());
    }
}
