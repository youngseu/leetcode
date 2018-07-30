package Niuke.didi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSumNumBacktracing {
    public static void backtracing(List<List<Integer>> res, List<Integer> tmp, int[] array, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < array.length; i++) {
//                if (i > start && array[i] == array[i - 1]) continue;
                tmp.add(array[i]);
                backtracing(res, tmp, array, target - array[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = bf.readLine().trim().split(" ");
        int amount = Integer.parseInt(arg[0]);
        int target = Integer.parseInt(arg[1]);

        int[] numarray = new int[amount];
        String[] strs = bf.readLine().trim().split(" ");
        for (int i = 0; i < amount; i++) {
            numarray[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(numarray);

        List<List<Integer>> res = new ArrayList<>();
        backtracing(res, new ArrayList<Integer>(), numarray, target, 0);
        System.out.println(res.size());
    }
}
