public class Practice7ByteCast {
    public static void main(String[] args) {
        int a = 120;

        // Такое НЕ скомпилируется (a + 10 -> int, а не byte):
        // byte b = a + 10;

        // Если привести явно — компилируется.
        byte c = (byte) (a + 10); // 120 + 10 = 130 -> -126 в byte
        byte d = (byte) (a + 1);  // 121 нормально влезает

        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }
}
