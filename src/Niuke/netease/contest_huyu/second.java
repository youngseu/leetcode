package Niuke.netease.contest_huyu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

//题目描述
//又到了丰收的季节，恰好小易去牛牛的果园里游玩。 牛牛常说他多整个果园的每个地方都了如指掌，小易不太相信，所以他想
//考考牛牛。 在果园里有N堆苹果，每堆苹果的数量为ai,小易希望知道从左往右数第x个苹果是属于哪一堆的。 牛牛觉得问题太
//简单了，所以希望你来替他回答。
//输入描述
//第一行 一个数 n (1<= n <= $10^5$)
//第二行 n个数 $a{i}$ (1<=$a{i}$<=1000),表示从左往右数第i堆有多少苹果
//第三行 一个数m (1<= m <= $10^5$),表示有m次询问
//第四行 m个数$q{i}$, 表示小易希望知道第$q{i}$个苹果属于哪一堆。
//输出描述
//m行，第i行输出第$q_{i}$个苹果属于哪一堆。
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
