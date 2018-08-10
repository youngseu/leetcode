package Niuke.util;

public class string_test {
    public static void main(String[] args) {

        String a = "typedef int INT";
        int index = a.lastIndexOf(" ");
        System.out.println(index);

        StringBuffer sb = new StringBuffer();
        sb.append('a').append('b').append('c');
        sb.replace(1, 2, "");
        System.out.println(sb.toString());

        String b = "ab  cd  ef";
        b = b.replaceAll("[" + "  " + "]", "");
        System.out.println(b);

        String c = "12";
        String d = "21";
        System.out.println(c.compareTo(d));
    }
}
