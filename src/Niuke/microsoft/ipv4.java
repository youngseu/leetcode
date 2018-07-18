package Niuke.microsoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ipv4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] temp = input.split("\\.");
        long res = 0;
        res += Integer.parseInt(temp[0]) << 24;
        res += Integer.parseInt(temp[1]) << 16;
        res += Integer.parseInt(temp[2]) << 8;
        res += Integer.parseInt(temp[3]);
        System.out.println(res);
    }
}
