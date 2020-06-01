package Niuke.tencent.contest_2020;

import java.util.Scanner;
import java.util.Stack;

// 逛街
//单调栈
//小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
//小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
//（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
//
//输入描述:
//输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
//1<=n<=100000;
//1<=wi<=100000;
//
//输出描述:
//输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
//
//输入例子1:
//6
//5 3 8 3 2 5
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int total;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j++) {
            // i look left
            a[i] = left.size();
            // j look right
            b[j] = right.size();

            while (!left.isEmpty() && left.peek() <= nums[i]) left.pop();
            while (!right.isEmpty() && right.peek() <= nums[j]) right.pop();

            left.push(nums[i]);
            right.push(nums[j]);
        }

        for (int i = 0; i < n; i++) {
            total = a[i] + b[i] + 1;
            if (i == n - 1)
                System.out.print(total);
            else
                System.out.print(total + " ");
        }
    }
}
