public class Practice6NarrowingCast {
    public static void main(String[] args) {
        int x = 100;
        byte b1 = (byte) x; // ок, 100 влезает
        System.out.println("b1 = " + b1);

        int y = 130;
        byte b2 = (byte) y; // переполнение: 130 -> -126
        System.out.println("b2 = " + b2);

        double pi = 3.99;
        int i = (int) pi; // дробная часть отрезается
        System.out.println("i = " + i);
    }
}
