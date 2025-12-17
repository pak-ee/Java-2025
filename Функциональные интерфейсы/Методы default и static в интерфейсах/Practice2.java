/**
 * Практика #2: конфликт одинаковых default-методов из двух интерфейсов.
 *
 * Что произойдёт:
 * - Если класс реализует два интерфейса, которые имеют default-метод с одинаковой сигнатурой,
 *   компилятор потребует явно разрешить конфликт: класс ОБЯЗАН переопределить этот метод.
 *
 * Как выйти из положения:
 * - Переопределить метод в классе и (при желании) внутри вызвать нужную реализацию через
 *   InterfaceName.super.method(...).
 *
 * Как запустить:
 *   javac Practice2.java
 *   java Practice2
 */
interface LoggerA {
    default void log(String message) {
        System.out.println("LoggerA: " + message);
    }
}

interface LoggerB {
    default void log(String message) {
        System.out.println("LoggerB: " + message);
    }
}

public class Practice2 implements LoggerA, LoggerB {
    // Без этого метода будет ошибка компиляции:
    // "class Practice2 inherits unrelated defaults for log(String) from types LoggerA and LoggerB"
    @Override
    public void log(String message) {
        System.out.println("Practice2: выбираю, что вызвать дальше...");
        LoggerA.super.log(message); // можно выбрать A
        LoggerB.super.log(message); // или B (или оба)
    }

    public static void main(String[] args) {
        Practice2 app = new Practice2();
        app.log("Конфликт default-методов решён переопределением.");

        LoggerA a = app;
        a.log("Вызов через ссылку LoggerA.");

        LoggerB b = app;
        b.log("Вызов через ссылку LoggerB.");
    }
}

