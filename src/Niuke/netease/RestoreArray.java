package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//数列还原
//题目描述
//牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）
//看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合
//这个要求的合法排列的数目。
//输入描述:
//每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），接下来
//的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
//输出描述:
//输出一行表示合法的排列数目。
//输入
//5 5
//4 0 0 2 0
//输出
//2
//思路
//首先，顺序对的个数互不影响。也就是说，对于数组A来说，增加（插入）一个数字，其A的顺序对个数不变，所以新数组A+1的顺序
//对个数=数组A的顺序对+新插入的数字产生的顺序对.
//进而推广到，增加c个数字，新数组A+c的顺序对=数组A的顺序对+数组c的顺序对+每个新插入的数字产生顺序对（共c个数字）
public class RestoreArray {
    //全排列
    public static void prem(List<List<Integer>> prem, List<Integer> temp, List<Integer> num) {
        if (temp.size() == num.size()) {
            prem.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < num.size(); i++) {
                if (temp.contains(num.get(i))) continue;
                temp.add(num.get(i));
                prem(prem, temp, num);
                temp.remove(temp.size() - 1);
            }
        }
    }

    //统计丢失数据的顺序对，和丢失数据和原有数据的顺序对
    public static int calculate(List<Integer> list, int[] array) {
        int val = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = list.get(j++);
                for (int k = 0; k < i; k++) {
                    if (array[k] != 0 && array[k] < array[i]) {
                        val++;
                    }
                }
                for (int k = i + 1; k < array.length; k++) {
                    if (array[k] != 0 && array[k] > array[i]) {
                        val++;
                    }
                }
            }
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] factor = bf.readLine().trim().split(" ");
        int len = Integer.parseInt(factor[0]);
        int num = Integer.parseInt(factor[1]);

        //得到数组
        int[] array = new int[len];
        //缺失标记
        boolean[] flags = new boolean[len+1];
        String[] nums = bf.readLine().trim().split(" ");
        for (int i = 0; i < len; i++) {
            array[i] = Integer.parseInt(nums[i]);
            if (array[i] != 0) {
                flags[array[i]] = true;
            }
        }
        //缺失数组
        List<Integer> lost = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if (!flags[i]) {
                lost.add(i);
            }
        }

        List<List<Integer>> premutation = new ArrayList<>();
        prem(premutation, new ArrayList<>(), lost);

        //统计已有数据顺序对
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] != 0) {
                for (int j = i + 1; j < len; j++) {
                    if (array[j] != 0 && array[i] < array[j]) {
                        count++;
                    }
                }
            }
        }

        int res = 0;
        //遍历丢失数字全排列
        for (List<Integer> temp : premutation) {
            int val = count;
            int[] temp_array = Arrays.copyOf(array, len);
            val += calculate(temp, temp_array);
            if (val == num) res++;
        }
        System.out.println(res);
    }
}
