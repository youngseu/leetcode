package Niuke.huawei.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class first {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().trim();
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            //如果ASCII在65-90之间为大写，加上32变为小写
            if (bytes[i] >= 65 && bytes[i] <= 90) {
                bytes[i] += 32;
                //如果ASCII在97-122之间为小写，减去32变为大写
            } else if (bytes[i] >= 97 && bytes[i] <= 122) {
                bytes[i] -= 32;
            }
        }
        String str2 = new String(bytes);
        System.out.println(str2);
    }
}
