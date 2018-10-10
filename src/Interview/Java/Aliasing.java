package Interview.Java;


public class Aliasing {
    private static class C {
        float f;

        public C(float f) {
            this.f = f;
        }
    }

    private static void func(C a) {
        a.f = 2;
    }

    public static void main(String[] args) {
        C c = new C(1);
        System.out.println(c.f);
        C b = c;
        func(b);
        System.out.println(c.f);
    }
}
