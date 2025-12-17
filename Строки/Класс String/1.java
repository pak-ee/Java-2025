public class StringMethodsDemo {
    public static void main(String[] args) {
        String text = "  Hello, Java String!  ";

        // 1) length() — возвращает количество символов в строке.
        System.out.println("1) length(): " + text.length());

        // 2) trim() — удаляет пробелы (и другие пробельные символы) в начале и в конце строки.
        String trimmed = text.trim();
        System.out.println("2) trim(): '" + trimmed + "'");

        // 3) charAt(int index) — возвращает символ по указанному индексу (нумерация с 0).
        System.out.println("3) charAt(0): " + trimmed.charAt(0));

        // 4) substring(int beginIndex, int endIndex) — возвращает подстроку: [beginIndex, endIndex).
        System.out.println("4) substring(0, 5): " + trimmed.substring(0, 5));

        // 5) toUpperCase() — возвращает новую строку в верхнем регистре.
        System.out.println("5) toUpperCase(): " + trimmed.toUpperCase());

        // 6) toLowerCase() — возвращает новую строку в нижнем регистре.
        System.out.println("6) toLowerCase(): " + trimmed.toLowerCase());

        // 7) replace(CharSequence target, CharSequence replacement) — заменяет все вхождения target на replacement.
        System.out.println("7) replace(\"Java\", \"Kotlin\"): " + trimmed.replace("Java", "Kotlin"));

        // 8) contains(CharSequence s) — проверяет, содержит ли строка указанную последовательность.
        System.out.println("8) contains(\"String\"): " + trimmed.contains("String"));

        // 9) indexOf(String str) — возвращает индекс первого вхождения подстроки, либо -1 если не найдено.
        System.out.println("9) indexOf(\"String\"): " + trimmed.indexOf("String"));

        // 10) split(String regex) — разбивает строку по регулярному выражению и возвращает массив частей.
        String[] parts = trimmed.split(" ");
        System.out.println("10) split(\" \"):");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("   part[" + i + "] = '" + parts[i] + "'");
        }
    }
}

