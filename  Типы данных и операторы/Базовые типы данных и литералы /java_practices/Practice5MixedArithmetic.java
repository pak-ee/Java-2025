public class Practice5MixedArithmetic {
    public static void main(String[] args) {
        byte a = 10;
        short b = 300;
        int c = 1000;
        double d = 2.5;

        // byte/short в выражениях обычно превращаются в int
        int r1 = a + b; // 310

        // int + double -> double
        double r2 = c + d; // 1002.5

        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);

        // long + int -> long
        long big = 10_000_000_000L;
        long r3 = big + c;
        System.out.println("r3 = " + r3);
    }
}
