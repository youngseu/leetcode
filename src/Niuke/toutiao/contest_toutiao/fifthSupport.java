package Niuke.toutiao.contest_toutiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//最大区间调度问题
//数轴上有n个区间，选出最多的区间，使得这些区间不互相重叠。
//算法：
//将所有区间按右端点坐标从小到大排序，顺序处理每个区间。如果它与当前已选的所有区间都没有重叠，则选择该区间，否则不选。
public class fifthSupport {

    public static int solution(int[][] arrays) {
        Arrays.sort(arrays, (o1, o2) -> o1[1] - o2[1]);
        int lastEnd = arrays[0][1];
        int count = 1;
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i][0] >= lastEnd) {
                count++;
                lastEnd = arrays[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int m = Integer.parseInt(bf.readLine().trim());
        int[][] array = new int[n][2];
        String[] str = bf.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            array[i][0] = Integer.parseInt(str[2 * i]);
            array[i][1] = Integer.parseInt(str[2 * i + 1]);
            if (array[i][1] < array[i][0]) {
                array[i][1] = m;
            }
        }
        System.out.println(solution(array));
    }
}
