package Niuke.ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Time {
    //输入进行排序，最小时间为最小排序时间，例如123456，两位两位判断，首先判断前两位是否小于等于23，后两位小于等于59，再后两位小于等于59
    //最大时间进行贪心，ab:cd:ef，a的贪心目标从高到低为2，1 ，0，b的贪心目标为3,2,1,0。
    //cd和ef的贪心目标相似，均是接近59，所以c的贪心目标从高到低为5，4,3,2,1,0，d的贪心目标为9,8,7,6,5,4,3,2,1，
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] num = new int[6];
        for (int i = 0; i < 6; i++) {
            num[i] = s.charAt(i) - '0';
        }
        Arrays.sort(num);
        StringBuffer small_time = new StringBuffer();
        if (num[0] * 10 + num[1] > 23 || (num[2] >= 5 && num[3] >= 5)) {
            small_time.append("N/A");
            System.out.println(small_time.toString());
            return;
        } else {
            small_time.append(num[0]).append(num[1]).append(num[2]).append(num[3]).append(num[4]).append(num[5]);
        }

        StringBuffer max_time = new StringBuffer();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            array.add(num[i]);
        }
        for (int i = 2; i >= 0; i--) {
            if (array.contains(i)) {
                max_time.append(i);
                array.remove(array.indexOf(i));
                break;
            }
        }
        if (max_time.charAt(0) - '0' == 2) {//num[0] =2
            for (int i = 3; i >= 0; i--) {
                if (array.contains(i)) {
                    max_time.append(i);
                    array.remove(array.indexOf(i));
                    break;
                }
            }
        } else if (max_time.charAt(0) - '0' <= 1) {//num[0]<=1
            for (int i = 9; i >= 0; i--) {
                if (array.contains(i)) {
                    max_time.append(i);
                    array.remove(array.indexOf(i));
                    break;
                }
            }
        } else {
            max_time.append("N/A");
            System.out.println(max_time.toString());
            return;
        }

        //num[3~5]
        for (int i = 5; i >= 0; i--) {
            if (array.contains(i)) {
                max_time.append(i);
                array.remove(array.indexOf(i));
                break;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (array.contains(i)) {
                max_time.append(i);
                array.remove(array.indexOf(i));
                break;
            }
        }
        for (int i = 5; i >= 0; i--) {
            if (array.contains(i)) {
                max_time.append(i);
                array.remove(array.indexOf(i));
                break;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (array.contains(i)) {
                max_time.append(i);
                array.remove(array.indexOf(i));
                break;
            }
        }
        if (small_time.length() < 6 || max_time.length() < 6) {
            System.out.println("N/A");
        } else if (small_time.toString().equals(max_time.toString())) {
            System.out.println(small_time.toString());
        } else {
            System.out.println(small_time.toString());
            System.out.println(max_time.toString());
        }

    }
}
