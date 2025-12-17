/**
 * Практика #2
 *
 * Показано, какими методами/способами String, StringBuilder и StringBuffer
 * могут быть преобразованы друг в друга.
 */
public class Practice2 {
    public static void main(String[] args) {
        System.out.println("=== Практика #2: преобразования String / StringBuilder / StringBuffer ===");

        // String -> StringBuilder: конструктор StringBuilder(String)
        String s = "Hello";
        StringBuilder sb = new StringBuilder(s);

        // String -> StringBuffer: конструктор StringBuffer(String)
        StringBuffer sbuf = new StringBuffer(s);

        // StringBuilder -> String: toString()
        String fromSb = sb.toString();

        // StringBuffer -> String: toString()
        String fromSbuf = sbuf.toString();

        // StringBuilder -> StringBuffer: через toString() + конструктор (или sbuf.append(sb))
        StringBuffer sbufFromSb = new StringBuffer(sb.toString());

        // StringBuffer -> StringBuilder: через toString() + конструктор (или sb.append(sbuf))
        StringBuilder sbFromSbuf = new StringBuilder(sbuf.toString());

        // Дополнительно: String.valueOf(...) также использует toString() для объектов.
        String viaValueOf = String.valueOf(sb);

        System.out.println("String: " + s);
        System.out.println("String -> StringBuilder: " + sb);
        System.out.println("String -> StringBuffer: " + sbuf);
        System.out.println("StringBuilder -> String (toString): " + fromSb);
        System.out.println("StringBuffer -> String (toString): " + fromSbuf);
        System.out.println("StringBuilder -> StringBuffer: " + sbufFromSb);
        System.out.println("StringBuffer -> StringBuilder: " + sbFromSbuf);
        System.out.println("StringBuilder -> String (String.valueOf): " + viaValueOf);
    }
}

