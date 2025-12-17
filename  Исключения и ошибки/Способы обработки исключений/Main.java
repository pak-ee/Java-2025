public class Main {
    public static void main(String[] args) {
        try {
            // 1) Исключение будет перехвачено здесь
            parseAge("abc");
        } catch (NumberFormatException e) {
            System.out.println("Поймали NumberFormatException: " + e.getMessage());
        }

        // 2) Исключение НЕ перехватывается и приведёт к аварийному завершению
        crash();
    }

    static int parseAge(String s) {
        return Integer.parseInt(s); // бросит NumberFormatException для "abc"
    }

    static void crash() {
        String text = null;
        System.out.println(text.length()); // бросит NullPointerException
    }
}
