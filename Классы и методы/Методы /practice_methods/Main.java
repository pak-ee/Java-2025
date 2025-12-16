/**
 * Практика: перегрузка (overloading) и переопределение (override) методов.
 *
 * Идея простая:
 * 1) Перегрузка: один и тот же метод add(...) существует в нескольких вариантах,
 *    отличается количеством и/или типами аргументов.
 * 2) Переопределение: подкласс (Dog) меняет поведение метода speak(), который есть в суперклассе (Animal).
 */
public class Main {

    /**
     * Пример ПЕРЕГРУЗКИ.
     * У метода одно имя, но разные параметры.
     * (Важно: тип возвращаемого значения сам по себе перегрузку не делает.)
     */
    static class Calculator {

        // Складываем 2 int
        int add(int a, int b) {
            return a + b;
        }

        // Складываем 3 int (другой набор параметров -> это перегрузка)
        int add(int a, int b, int c) {
            return a + b + c;
        }

        // Складываем 2 double (другие типы параметров -> тоже перегрузка)
        double add(double a, double b) {
            return a + b;
        }

        // Пример: нельзя сделать так же:
        // double add(int a, int b) { ... }
        // Потому что параметры те же (int, int), а возвращаемый тип другой.
        // Java считает это ДУБЛИРОВАНИЕМ, а не перегрузкой.
    }

    /**
     * Суперкласс для примера ПЕРЕОПРЕДЕЛЕНИЯ.
     */
    static class Animal {
        protected String name; // protected, чтобы подкласс мог обращаться

        Animal(String name) {
            this.name = name;
        }

        // Базовая реализация
        void speak() {
            System.out.println(name + ": издаёт какой-то звук");
        }
    }

    /**
     * Подкласс, который ПЕРЕОПРЕДЕЛЯЕТ метод speak().
     */
    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        void speak() {
            // Тут мы меняем поведение метода суперкласса
            System.out.println(name + ": гав-гав!");
        }
    }

    public static void main(String[] args) {
        // ===== 1) Перегрузка =====
        Calculator calc = new Calculator();

        int sum2 = calc.add(2, 3);
        int sum3 = calc.add(2, 3, 4);
        double sumDouble = calc.add(1.5, 2.25);

        System.out.println("Перегрузка методов add(...):");
        System.out.println("add(2, 3) = " + sum2);
        System.out.println("add(2, 3, 4) = " + sum3);
        System.out.println("add(1.5, 2.25) = " + sumDouble);

        System.out.println();

        // ===== 2) Переопределение =====
        // Полиморфизм: переменная типа Animal, а объект может быть Animal или Dog
        Animal a1 = new Animal("Животное");
        Animal a2 = new Dog("Бобик");

        System.out.println("Переопределение метода speak():");
        a1.speak(); // вызовется Animal.speak()
        a2.speak(); // вызовется Dog.speak() благодаря @Override
    }
}
