package Niuke.toutiao.contest_toutiao3;

import java.util.Scanner;

// 万万没想到之聪明的编辑
public class First {

    public static String edit(String line){
        char[] chars = line.toCharArray();
        StringBuilder strb = new StringBuilder();
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            chars[slow] = chars[fast];
            strb.append(chars[slow]);
            slow++;

            if (slow >= 3 && chars[slow - 3] == chars[slow - 2] && chars[slow - 2] == chars[slow - 1]) {
                strb.deleteCharAt(slow - 1);
                slow--;
            }

            if (slow >= 4 && chars[slow - 4] == chars[slow - 3] && chars[slow - 2] == chars[slow - 1]) {
                strb.deleteCharAt(slow - 1);
                slow--;
            }
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            String line = sc.nextLine();
            System.out.println(edit(line));
        }
    }
}
