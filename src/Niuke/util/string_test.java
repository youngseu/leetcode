package Niuke.util;

import java.math.BigInteger;

public class string_test {
    public static void main(String[] args) {

        //indexOf
        String a = "typedef int INT";
        int index = a.lastIndexOf(" ");
        System.out.println(index);

        //replace
        StringBuffer sb = new StringBuffer();
        sb.append('a').append('b').append('c');
        sb.replace(1, 2, "");
        System.out.println(sb.toString());

        //replaceAll
        String b = "ab  cd  ef";
        b = b.replaceAll("[" + "  " + "]", "");
        System.out.println(b);

        //compare
        String c = "12";
        String d = "21";
        System.out.println(c.compareTo(d));

        //radix
        String e = "ff";
        BigInteger bi = new BigInteger(e, 16);
        System.out.println(bi.toString(10));

        System.out.println(Integer.parseInt(e, 16));

        String f = "222248A";
        BigInteger b6 = new BigInteger(f, 16);
        System.out.println(b6.toString(10));

    }
}
