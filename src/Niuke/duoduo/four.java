package Niuke.duoduo;

import java.util.*;
//A国的手机号由且仅由N位十进制数字（0-9）组成，一个手机号码中至少K位数字相同则被定义为靓号，A国的手机号可以有
//前导零，比如000123456是一个合法的手机号
//小多想花钱将自己的手机号修改成为一个靓号，修改号码中一个数字需要花费的金额为新数字与旧数字之间的差值，比如将1修改
//为6或6修改为1都需要花费5块钱
//给出小多现在的手机号码，问将其修改成为一个靓号，最少需要多少钱
//输入描述
//第一行包含2个整数N，K，分别表示手机号码数字个数以及靓号至少有K个数字相同
//第二行包含N个字符，每个字符都是一个数字（‘0’-‘9’），数字之间没有任何其他空白行，表示小多的手机号码
//数据范围
//2<=K<=N<=10000
//输出描述
//第一行包含一个整数，表示最少需要的金额
//第二行包含N个数字字符，表示最少花费修改的新手机号码，若有多个靓号花费都最少，则输出字典序最小的靓号
//输入
//6 5
//787585
//输出
//4
//777577
public class four {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);
        String in = s.nextLine();
        int min_sum = (int) (1e5 + 5);
        int[] num = new int[10];
        String ans = "";
        char[] tmp = in.toCharArray();
        //每个数值进行计数
        for (int i = 0; i < n; i++)
            num[tmp[i] - '0']++;

        for (int i = 0; i < 10; i++) {//对每一个数字的结果进行枚举
            int need = k - num[i], sum = 0;//当前最小消耗和当前消耗
            tmp = in.toCharArray();//从最小的距离开始改变，进行模拟计数
            for (int j = 1; j < 10 && need > 0; j++) {
                if (i + j <= 9)
                    //这里的修改操作会使得字符值变小，所以优先进行改变
                    //并且排在前面的优先，所以从前往后遍历
                    for (int v = 0; v < n && need > 0; v++)
                        if (tmp[v] - '0' == i + j) {
                            tmp[v] = (char) (i + '0');
                            sum += j;
                            need--;
                        }
                if (i - j >= 0)//与上述情形刚好相反
                    for (int v = n - 1; v > -1 && need > 0; v--)
                        if (tmp[v] - '0' == i - j) {
                            tmp[v] = (char) (i + '0');
                            sum += j;
                            need--;
                        }
            }
            if (sum < min_sum && need <= 0) {
                ans = String.valueOf(tmp);
                min_sum = sum;
            } else if (sum == min_sum && String.valueOf(tmp).compareTo(ans) > 0)
                ans = String.valueOf(tmp);
        }
        System.out.println(min_sum);
        System.out.println(ans);
    }


}
