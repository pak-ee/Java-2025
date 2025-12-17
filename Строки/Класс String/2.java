import java.util.StringJoiner;

public class StringJoinerExamples {
    public static void main(String[] args) {
        // Пример 1: базовое объединение строк с разделителем.
        // StringJoiner удобен, когда нужно собрать строку из частей без "лишнего" разделителя в конце.
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("apple").add("banana").add("orange");
        System.out.println("1) " + joiner1); // apple, banana, orange

        // Пример 2: разделитель + префикс + суффикс.
        // Полезно, например, для вывода списков в скобках.
        StringJoiner joiner2 = new StringJoiner(" | ", "[", "]");
        joiner2.add("A").add("B").add("C");
        System.out.println("2) " + joiner2); // [A | B | C]

        // Пример 3: setEmptyValue(...) — что выводить, если ни одного элемента не добавили.
        StringJoiner joiner3 = new StringJoiner("; ", "{", "}");
        joiner3.setEmptyValue("{EMPTY}");
        System.out.println("3) " + joiner3); // {EMPTY}
        joiner3.add("one");
        System.out.println("   " + joiner3); // {one}

        // Пример 4: merge(...) — объединение двух StringJoiner с одинаковым разделителем/обрамлением.
        StringJoiner left = new StringJoiner(", ", "(", ")");
        left.add("x").add("y");
        StringJoiner right = new StringJoiner(", ", "(", ")");
        right.add("z");
        left.merge(right);
        System.out.println("4) " + left); // (x, y, z)
    }
}

