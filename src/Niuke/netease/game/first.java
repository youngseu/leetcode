package Niuke.netease.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//
public class first {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine().trim());
        for (int i = 0; i < num; i++) {
            //String input = bf.readLine().trim();
            StringBuffer input = new StringBuffer();
            input.append(bf.readLine().trim()).append('0');
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for (int j = 0; j < input.length(); j++) {
                if (sb.length() == 0) sb.append(input.charAt(0));
                else if (input.charAt(j) - input.charAt(j - 1) == 1) count++;
                else if (count >= 4) {
                    //大于4
                    sb.append('-').append(input.charAt(j - 1)).append(input.charAt(j));
                    count = 1;
                } else if (count == 1) {
                    //
                    sb.append(input.charAt(j));
                } else {
                    //小于4
                    for (int m = count - 1; m >= 0; m--)
                        sb.append(input.charAt(j - m));
                    count = 1;
                }
            }
            if (count != 1) {
                for (int j = count - 1; j >= 1; j--) {
                    sb.append(input.charAt(input.length() - j));
                }
            }
            System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
        }
    }
}
