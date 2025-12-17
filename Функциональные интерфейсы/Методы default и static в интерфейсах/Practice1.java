/**
 * Практика #1: default + static методы в интерфейсе (Java 8+).
 *
 * Как запустить:
 *   javac Practice1.java
 *   java Practice1
 */
interface Greeter {
    // default-метод (неабстрактный) — наследуется реализующим классом и может быть переопределён.
    default void sayHello(String name) {
        System.out.println("Greeter.default: Привет, " + name + "!");
    }

    // static-метод интерфейса — вызывается только по имени интерфейса.
    static void printInfo() {
        System.out.println("Greeter.static: Это статический метод интерфейса.");
    }
}

public class Practice1 implements Greeter {
    @Override
    public void sayHello(String name) {
        System.out.println("Practice1.override: Мой вариант приветствия для " + name);
        // Вызов дефолтной реализации из интерфейса:
        Greeter.super.sayHello(name);
    }

    public static void main(String[] args) {
        Practice1 obj = new Practice1();

        // 1) Вызов default-метода через объект реализующего класса:
        obj.sayHello("Аня");

        // 2) Вызов default-метода через ссылку на интерфейс:
        Greeter g = obj;
        g.sayHello("Петя");

        // 3) Вызов static-метода интерфейса (только так — по имени интерфейса):
        Greeter.printInfo();

        // НЕЛЬЗЯ (ошибка компиляции):
        // obj.printInfo();
        // g.printInfo();
        // Practice1.printInfo();
    }
}

