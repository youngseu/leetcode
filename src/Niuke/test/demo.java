package Niuke.test;

public class demo {
    public static void main(String[] args) {

        String a = "typedef int INT";
        int index = a.lastIndexOf(" ");
        System.out.println(index);

        StringBuffer sb = new StringBuffer();
        sb.append('a').append('b').append('c');
        sb.replace(1, 2, "");
        System.out.println(sb.toString());
    }
}
