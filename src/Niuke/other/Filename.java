package Niuke.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//java正则表达式
public class Filename {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\.");
        if (str.length != 1) {
            System.out.println(str[str.length - 1]);
        } else {
            System.out.println("null");
        }
    }
}
