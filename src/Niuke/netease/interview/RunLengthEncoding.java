package Niuke.netease.interview;

//行程长度压缩算法
public class RunLengthEncoding {
    public static String encoding(String str) {
        if (str == null) return null;
        if (str.length() <= 1) return str;
        StringBuffer sb = new StringBuffer();
        char pre_c = str.charAt(0);
        sb.append(pre_c);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == pre_c) {
                count++;
                continue;
            } else {
                sb.append(count);
                sb.append(c);
                count = 1;
                pre_c = c;
            }
        }
        sb.append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encoding("aaacbbbbdeeeef"));
        System.out.println(encoding("wwwwaaadexxxxxx"));
    }
}
