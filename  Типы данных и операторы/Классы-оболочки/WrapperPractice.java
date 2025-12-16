/**
 * Небольшая шпаргалка/демка по wrapper-классам из java.lang.
 *
 * Тут специально всё в одном файле, чтобы было проще закинуть в репозиторий.
 * Запуск:
 *   javac WrapperPractice.java
 *   java WrapperPractice
 */
public class WrapperPractice {

    public static void main(String[] args) {
        System.out.println("=== Практика по wrapper-классам ===\n");

        demoDecode();
        demoBooleanCreation();
        demoNullPointerWithUnboxing();
        demoIntegerCacheComparisons();

        System.out.println("\nГотово.");
    }

    /**
     * Практика #1
     * Примеры использования методов decode().
     *
     * decode() удобен тем, что сам понимает основание системы счисления по префиксу:
     *   "0x" / "0X" или "#"  -> 16-ричная
     *   "0" в начале        -> 8-ричная
     *   иначе               -> 10-ричная
     * Плюс знак "-" тоже поддерживается.
     */
    private static void demoDecode() {
        System.out.println("---- Практика #1: decode() ----");

        // 8-ричное число (012) -> 10 в десятичной
        Integer a = Integer.decode("012");

        // 16-ричные варианты
        Integer b = Integer.decode("0x12"); // 0x12 -> 18
        Integer c = Integer.decode("#12");  // #12  -> 18 (тот же смысл)

        // можно и со знаком
        Integer d = Integer.decode("-0xA"); // -10

        System.out.println("Integer.decode(\"012\")  = " + a);
        System.out.println("Integer.decode(\"0x12\") = " + b);
        System.out.println("Integer.decode(\"#12\")  = " + c);
        System.out.println("Integer.decode(\"-0xA\") = " + d);

        // decode() есть и у Long/Short/Byte (смысл такой же)
        Long l = Long.decode("0b1010"); // ВНИМАНИЕ: "0b" decode НЕ понимает, будет NumberFormatException
        // строку выше оставлять нельзя, поэтому демонстрируем корректно ниже:
        Long l2 = Long.decode("10");     // обычная 10-ричная

        System.out.println("Long.decode(\"10\")      = " + l2);

        // Как выглядит ошибка, если формат не тот:
        try {
            System.out.println("Пробуем Integer.decode(\"0b1010\") ...");
            Integer.decode("0b1010"); // в decode нет поддержки 0b
        } catch (NumberFormatException ex) {
            System.out.println("Поймали NumberFormatException: " + ex.getMessage());
        }

        System.out.println();
    }

    /**
     * Практика #2
     * Все способы создания экземпляра Boolean.
     *
     * Важно: конструкторы Boolean(...) существуют, но считаются "старым стилем".
     * В современных версиях Java они помечены как deprecated, но как способ — это всё равно способ :)
     */
    private static void demoBooleanCreation() {
        System.out.println("---- Практика #2: способы создать Boolean ----");

        // 1) valueOf(boolean)
        Boolean b1 = Boolean.valueOf(true);

        // 2) valueOf(String)
        // true только если строка (без учёта регистра) равна "true". Всё остальное => false.
        Boolean b2 = Boolean.valueOf("true");
        Boolean b3 = Boolean.valueOf("TrUe");
        Boolean b4 = Boolean.valueOf("yes"); // false

        // 3) автоупаковка (boxing)
        Boolean b5 = true;

        // 4) готовые константы (это уже готовые объекты)
        Boolean b6 = Boolean.TRUE;
        Boolean b7 = Boolean.FALSE;

        // 5) через конструктор (deprecated, но существует)
        Boolean b8 = new Boolean(true);
        Boolean b9 = new Boolean("true");

        System.out.println("Boolean.valueOf(true)      -> " + b1);
        System.out.println("Boolean.valueOf(\"true\")   -> " + b2);
        System.out.println("Boolean.valueOf(\"TrUe\")   -> " + b3);
        System.out.println("Boolean.valueOf(\"yes\")    -> " + b4);
        System.out.println("Boolean b = true           -> " + b5);
        System.out.println("Boolean.TRUE / FALSE       -> " + b6 + " / " + b7);
        System.out.println("new Boolean(true)          -> " + b8 + " (устаревший способ)");
        System.out.println("new Boolean(\"true\")       -> " + b9 + " (устаревший способ)");

        // Небольшой нюанс: Boolean обычно кешируется, поэтому == часто "случайно" работает:
        System.out.println("Boolean.TRUE == Boolean.valueOf(true) -> " + (Boolean.TRUE == Boolean.valueOf(true)));

        System.out.println();
    }

    /**
     * Практика #3
     * Когда при автоупаковке/автораспаковке получим NullPointerException.
     *
     * Самый частый случай: есть wrapper = null, и мы пытаемся использовать его как примитив.
     * Тогда JVM пытается сделать unboxing -> вызывает xxxValue() -> а объект-то null -> NPE.
     */
    private static void demoNullPointerWithUnboxing() {
        System.out.println("---- Практика #3: когда прилетает NullPointerException ----");

        Integer maybeNull = null;

        // 1) прямое присваивание в примитив
        try {
            int x = maybeNull; // тут и будет NPE
            System.out.println("x = " + x); // до сюда не дойдём
        } catch (NullPointerException ex) {
            System.out.println("NPE при 'int x = maybeNull;' потому что maybeNull == null");
        }

        // 2) то же самое, только более "скрыто": сравнение с числом тоже делает unboxing
        try {
            if (maybeNull == 0) { // unboxing перед сравнением
                System.out.println("maybeNull равен нулю");
            }
        } catch (NullPointerException ex) {
            System.out.println("NPE при 'maybeNull == 0' (сравнение тоже распаковывает)");
        }

        // 3) инкремент — это вообще комбо unboxing + boxing: (maybeNull.intValue() + 1) и обратно в Integer
        try {
            maybeNull++; // unboxing -> NPE
        } catch (NullPointerException ex) {
            System.out.println("NPE при 'maybeNull++' (инкремент распаковывает null)");
        }

        System.out.println();
    }

    /**
     * Практика #4
     * Что напечатает код и почему.
     *
     * Основной момент:
     *  - при сравнении Integer с int через == происходит unboxing (сравнение значений)
     *  - при сравнении Integer с Integer через == сравниваются ссылки (один и тот же объект или нет)
     *  - Integer.valueOf() использует IntegerCache для диапазона [-128..127] (по умолчанию)
     */
    private static void demoIntegerCacheComparisons() {
        System.out.println("---- Практика #4: вывод и объяснение IntegerCache ----");

        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;

        System.out.println("i1 = 128");
        System.out.println("a1==i1 " + (a1 == i1));
        System.out.println("b1==i1 " + (b1 == i1));
        System.out.println("a1==b1 " + (a1 == b1));
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));

        // Чтобы было нагляднее: покажем "личность" объектов (identityHashCode)
        System.out.println("identity(a1) = " + System.identityHashCode(a1));
        System.out.println("identity(b1) = " + System.identityHashCode(b1));

        System.out.println();

        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;

        System.out.println("i2 = 127");
        System.out.println("a2==i2 " + (a2 == i2));
        System.out.println("b2==i2 " + (b2 == i2));
        System.out.println("a2==b2 " + (a2 == b2));
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));

        System.out.println("identity(a2) = " + System.identityHashCode(a2));
        System.out.println("identity(b2) = " + System.identityHashCode(b2));

        System.out.println("\nПояснение:");
        System.out.println("- Для 128 кэш обычно не используется, поэтому a1 и b1 — разные объекты => (a1==b1) false.");
        System.out.println("- Для 127 (в диапазоне [-128..127]) JVM берёт объект из IntegerCache => a2 и b2 указывают на один объект => (a2==b2) true.");
        System.out.println("- equals() всегда сравнивает значения, поэтому везде true.");
        System.out.println("- Вывод: для wrapper-ов почти всегда сравнивай значения через equals(), а не через ==.");
    }
}
