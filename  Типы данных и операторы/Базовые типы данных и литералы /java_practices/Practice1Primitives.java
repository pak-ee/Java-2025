public class Practice1Primitives {
    public static void main(String[] args) {

        // целочисленные
        byte b1 = 12;
        byte b0 = 0;

        short s1 = 32000;
        short s0 = 0;

        int i1 = 123456;
        int i0 = 0;

        long l1 = 9_000_000_000L;
        long l0 = 0L;

        // с плавающей точкой
        float f1 = 3.14f;
        float f0 = 0.0f;

        double d1 = 2.71828;
        double d0 = 0.0;

        // символы (Unicode)
        char c1 = 'A';
        char c0 = '\u0000'; // нулевой символ (на экране его не видно)

        // булевский
        boolean bool1 = true;
        boolean bool0 = false;

        System.out.println("byte: " + b1 + " / " + b0);
        System.out.println("short: " + s1 + " / " + s0);
        System.out.println("int: " + i1 + " / " + i0);
        System.out.println("long: " + l1 + " / " + l0);
        System.out.println("float: " + f1 + " / " + f0);
        System.out.println("double: " + d1 + " / " + d0);
        System.out.println("char: " + c1 + " / (zero char)");
        System.out.println("boolean: " + bool1 + " / " + bool0);
    }
}
