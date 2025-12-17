import java.io.IOException;
import java.sql.SQLException;

public class Practice1 {
    public static void main(String[] args) {
        demoMultiCatchIdenticalHandling(true);
        demoMultiCatchIdenticalHandling(false);

        demoHierarchyCatches(1);
        demoHierarchyCatches(2);
        demoHierarchyCatches(3);
    }

    // Ситуация 1: несколько исключений обрабатываются идентично (multi-catch)
    private static void demoMultiCatchIdenticalHandling(boolean io) {
        try {
            mightThrowIoOrSql(io);
            System.out.println("OK: исключения не было (io=" + io + ")");
        } catch (IOException | SQLException e) {
            System.out.println("Одинаковая обработка для IOException и SQLException: " + e.getClass().getSimpleName());
        }
    }

    private static void mightThrowIoOrSql(boolean io) throws IOException, SQLException {
        if (io) {
            throw new IOException("I/O problem");
        }
        throw new SQLException("DB problem");
    }

    // Ситуация 2: иерархия исключений Ex1 <|-- Ex2 <|-- Ex3 и правильный порядок catch
    private static void demoHierarchyCatches(int which) {
        try {
            throwHierarchy(which);
        } catch (Ex3 e) {
            System.out.println("Пойман Ex3");
        } catch (Ex2 e) {
            System.out.println("Пойман Ex2");
        } catch (Ex1 e) {
            System.out.println("Пойман Ex1");
        }

        // Нельзя объединять исключения из одной цепочки наследования:
        // catch (Ex1 | Ex2 e) { } // Ошибка компиляции: Ex2 является подклассом Ex1
    }

    private static void throwHierarchy(int which) throws Ex1 {
        switch (which) {
            case 1 -> throw new Ex1();
            case 2 -> throw new Ex2();
            default -> throw new Ex3();
        }
    }

    static class Ex1 extends Exception {}
    static class Ex2 extends Ex1 {}
    static class Ex3 extends Ex2 {}
}

