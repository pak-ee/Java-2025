public class Main {

    static class VarargLogger {

        void log(String... lines) {
            System.out.println("[обычный лог]");
            for (String line : lines) {
                System.out.println(line);
            }
        }

        void log(int repeat, String... lines) {
            int times = Math.max(1, repeat); // хотя бы один раз выводим
            System.out.println("[лог с повторами x" + times + "]");
            for (int i = 0; i < times; i++) {
                for (String line : lines) {
                    System.out.println("#" + (i + 1) + ": " + line);
                }
            }
        }
    }

    public static void main(String[] args) {
        VarargLogger logger = new VarargLogger();

        logger.log("Привет!", "Это обычный вызов varargs без доп. параметров.");

        System.out.println();

        logger.log(2, "Повторяем одну и ту же запись", "И вторую строку для примера");
    }
}
