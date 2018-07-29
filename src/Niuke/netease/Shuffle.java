package Niuke.netease;

import java.util.Arrays;
import java.util.Scanner;
//洗牌
//洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张
//一直到第2n张。首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）
//接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手
//的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。 例如有6张牌，
//最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了
//6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
//现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
//输入描述:
//第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行
//有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
//输出描述:
//对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
//示例1
//输入
//3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
//输出
//1 4 2 5 3 6 1 5 4 3 2 6 1 1 1 1
public class Shuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            //读取数字
            int[] array = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                array[j] = sc.nextInt();
            }

            int[] copy;
            for (int m = 0; m < k; m++) {
                copy = Arrays.copyOf(array, 2 * n);
                for (int j = 0; j < n; j++) {
                    array[2 * j] = copy[2 * n - 1 - j];
                    array[2 * j + 1] = copy[n - 1 - j];
                }
                for (int j = 0; j < n; j++) {
                    int tmp = array[j];
                    array[j] = array[2 * n - 1 - j];
                    array[2 * n - 1 - j] = tmp;
                }
            }

            if (array.length > 0) System.out.print(array[0]);
            for (int j = 1; j < 2 * n; j++) {
                System.out.print(" " + array[j]);
            }
            System.out.println();
        }
    }
// * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
// * 根据当前数的位置，可以算出经过一次洗牌后的位置
// * 如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
// * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
//    public class IncAndDecQueue {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int groups = sc.nextInt();
//            while (groups-- > 0){
//                int n = sc.nextInt();
//                int k = sc.nextInt();
//                int[] res = new int[2*n];
//                for(int i=0;i<2*n;i++){
//                    int tmp = i + 1;
//                    for(int j = 0; j < k;j++){
//                        if (tmp <= n) tmp = 2*tmp - 1;
//                        else tmp = 2 * (tmp - n);
//                    }
//                    res[tmp - 1]=sc.nextInt();
//                }
//                //输出
//                if(res.length> 0) System.out.print(res[0]);
//                for(int i = 1;i< 2*n;i++){
//                    System.out.print(" "+res[i]);
//                }
//                System.out.println();
//            }
//        }
//    }
}
