package Niuke.huawei.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class third {
    public static TreeMap<String, String> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine().trim();
        String target = bf.readLine();
        String[] str = input.split(";");
        if (input == null) System.out.println("none");
        else {
            for (int i = 0; i < str.length; i++) {
                String[] temp = str[i].trim().split(" ");
                if (temp.length == 3)
                    map.put(temp[2], temp[1]);
                else
                    map.put(temp[3], temp[1] + " " + temp[2]);
            }
            String source = map.get(target);
            if (source == null) {
                System.out.println("none");
            } else {
                boolean flag = true;
                while (flag) {
                    int count = 0;
                    for (String key : map.keySet()) {
                        if (source.contains(key)) {
                            source = source.replace(key, map.get(key));
                            count++;
                        }
                    }
                    if (count == 0) {
                        flag = false;
                    }
                }
                String res = source.replace("*", " *");
                boolean flag1 = false;
                byte[] bytes = res.getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] >= 65 && bytes[i] <= 90) {
                        flag1 = true;
                    }
                }
                if (flag1) System.out.println("none");
                else System.out.println(res);
            }
        }
    }
}
