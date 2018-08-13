package Niuke.netease.contest_huyu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

//第一行输入为n个堆，第二行输入为每堆的值，第三行为查询的次数，查询值为该堆和值落在第几个堆
//输入
//5
//2 7 3 4 9
//3
//1 25 11
//输出
//1
//5
//3
public class second {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int dui_num = Integer.parseInt(bf.readLine());
        int[] dui_arrays = new int[dui_num];
        int[] sum = new int[dui_num + 1];
        String[] duistr = bf.readLine().trim().split(" ");
        for (int i = 0; i < dui_num; i++) {
            dui_arrays[i] = Integer.parseInt(duistr[i]);
            sum[i + 1] = sum[i] + dui_arrays[i];
        }

        int cha_num = Integer.parseInt(bf.readLine());
        int[] copy = new int[cha_num];
        int[] cha_arrays = new int[cha_num];
        String[] chastr = bf.readLine().trim().split(" ");
        for (int i = 0; i < cha_num; i++) {
            cha_arrays[i] = Integer.parseInt(chastr[i]);
            copy[i] = cha_arrays[i];
        }

        //sort
//        Arrays.sort(cha_arrays);
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int p_sum = 1;
//        for (int j = 0; j < cha_num; j++) {
//            while (p_sum < dui_num + 1 && cha_arrays[j] > sum[p_sum - 1]) {
//                ++p_sum;
//            }
//            map.put(cha_arrays[j], p_sum - 1);
//        }
//        for (int i = 0; i < cha_num; i++) {
//            System.out.println(map.get(copy[i]));
//        }

        //binarySearch
        System.out.println();
        for (int i = 0; i < cha_num; i++) {
            int order = Arrays.binarySearch(sum, copy[i]);
            System.out.println(order > 0 ? order : -order - 1);
        }
    }
}
