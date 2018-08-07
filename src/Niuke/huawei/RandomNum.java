package Niuke.huawei;

import java.util.Scanner;
import java.util.TreeSet;
//明明的随机数
//treeset的使用
public class RandomNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < num; i++) {
                treeSet.add(sc.nextInt());
            }
            for (Integer integer : treeSet) {
                System.out.println(integer);
            }
        }
    }
}
