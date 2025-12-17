public class Practice3OverrideAnnotation {
    static class Printer {
        void print(String text) {
            System.out.println("Printer: " + text);
        }
    }

    static class BadPrinter extends Printer {
        // Ошибка: хотели переопределить print(String), но случайно изменили параметры.
        // Без @Override код скомпилируется, но метод НЕ переопределится (это будет перегрузка).
        void print(int number) {
            System.out.println("BadPrinter: " + number);
        }

        /*
        // Если поставить @Override, компилятор поймает ошибку сигнатуры:
        @Override
        void print(int number) {
            System.out.println("BadPrinter: " + number);
        }
        */
    }

    static class GoodPrinter extends Printer {
        @Override
        void print(String text) {
            System.out.println("GoodPrinter: " + text);
        }
    }

    public static void main(String[] args) {
        Printer p1 = new BadPrinter();
        Printer p2 = new GoodPrinter();

        // Для BadPrinter вызовется Printer.print(String), т.к. переопределения нет.
        p1.print("hello");

        // Для GoodPrinter вызовется переопределенный метод.
        p2.print("hello");
    }
}

