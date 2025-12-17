/**
 * Практика #1
 *
 * В отличие от String, классы StringBuilder и StringBuffer изменяемые (mutable):
 * их содержимое можно менять без создания новых объектов.
 *
 * StringBuffer потокобезопасен (его методы синхронизированы),
 * StringBuilder — нет (обычно быстрее в одном потоке).
 *
 * В программе продемонстрирована функциональность 10+ методов StringBuilder/StringBuffer.
 */
public class Practice1 {
    public static void main(String[] args) {
        System.out.println("=== Практика #1: методы StringBuilder / StringBuffer ===");

        // Создание изменяемой строки из начального значения (конструктор StringBuilder(String)).
        StringBuilder sb = new StringBuilder("Java");
        System.out.println("Исходный sb: " + sb);

        // 1) append(...) — дописывает в конец (перегружен для разных типов).
        sb.append(" ").append("StringBuilder");
        System.out.println("append: " + sb);

        // 2) insert(index, ...) — вставляет подстроку/символ по индексу.
        sb.insert(5, "класс ");
        System.out.println("insert: " + sb);

        // 3) replace(start, end, str) — заменяет диапазон [start, end) на новую строку.
        sb.replace(0, 4, "JAVA");
        System.out.println("replace: " + sb);

        // 4) delete(start, end) — удаляет диапазон [start, end).
        sb.delete(5, 11); // удалим "класс " (вместе с пробелом)
        System.out.println("delete: " + sb);

        // 5) deleteCharAt(index) — удаляет один символ по индексу.
        sb.deleteCharAt(sb.length() - 1); // удалим последнюю букву
        System.out.println("deleteCharAt: " + sb);

        // 6) setCharAt(index, ch) — заменяет символ на позиции index.
        sb.setCharAt(0, 'j');
        System.out.println("setCharAt: " + sb);

        // 7) reverse() — разворачивает последовательность символов "на месте".
        sb.reverse();
        System.out.println("reverse: " + sb);

        // 8) reverse() снова — чтобы вернуть обратно (и продолжить читаемо).
        sb.reverse();

        // 9) substring(start, end) — возвращает новую строку String (не меняет builder).
        String part = sb.substring(0, 4);
        System.out.println("substring(0,4) => \"" + part + "\", sb не изменился: " + sb);

        // 10) capacity() — текущая ёмкость буфера (сколько символов можно хранить без перераспределения).
        System.out.println("capacity (до ensureCapacity): " + sb.capacity());

        // 11) ensureCapacity(minCapacity) — гарантирует минимальную ёмкость буфера.
        sb.ensureCapacity(100);
        System.out.println("capacity (после ensureCapacity(100)): " + sb.capacity());

        // 12) length() — текущая длина (количество символов).
        System.out.println("length: " + sb.length());

        // Теперь StringBuffer (почти тот же API, но синхронизирован).
        StringBuffer sbuf = new StringBuffer("Thread-safe");
        System.out.println("Исходный sbuf: " + sbuf);

        // 13) append(...) у StringBuffer — аналогично дописывает в конец.
        sbuf.append(" ").append("StringBuffer");
        System.out.println("StringBuffer.append: " + sbuf);

        // 14) setLength(newLength) — изменяет длину: может обрезать или дополнить \u0000 символами.
        sbuf.setLength(12);
        System.out.println("StringBuffer.setLength(12): \"" + sbuf + "\" (обрезали до 12 символов)");
    }
}

