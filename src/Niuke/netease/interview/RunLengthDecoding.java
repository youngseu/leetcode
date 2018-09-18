package Niuke.netease.interview;

public class RunLengthDecoding {
    public static String decoding(String str) {
        if (str == null) return null;
        if (str.length() <= 1) return str;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int j = i + 1;
            int count = 0;
            for (; j < str.length(); j++) {
                int n = str.charAt(j) - '0';
                if (n >= 0 && n <= 9) count = count * 10 + n;
                else break;
            }
            for (int k = 0; k < count; k++) sb.append(c);
            i = j - 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decoding("a12c1d20"));
    }
}
