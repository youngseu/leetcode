package Interview.Java;


public class StaticTest {

    private static class TClass {
        public char c;
        public int i;
    }

    public static void main(String[] args) {
        TClass tClass = new TClass();
        System.out.println(tClass.c);
        System.out.println(tClass.i);
    }
}
