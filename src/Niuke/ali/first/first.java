package Niuke.ali.first;


import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }
        int dis = array[1] - array[0];
        boolean flag = true;
        for (int i = 1; i < num; i++) {
            if (array[i] - array[i - 1] != dis)
                flag = false;
        }
        if (!flag)
            System.out.println(0);
        else
            System.out.println(num / 3);
    }
}
