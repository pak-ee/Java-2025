import java.util.*;

public class LspDemo {

    public static void main(String[] args) {
        List<Bird> birds = List.of(
                new Sparrow("Чижик"),
                new Penguin("Пингвин Петрович")
        );

        // всех птиц можно кормить — это ок
        for (Bird b : birds) {
            b.eat();
        }

        System.out.println();

        // а летать просим только тех, кто реально умеет
        List<Flyable> flyers = List.of(
                new Sparrow("Воробей Вася")
                // Penguin сюда просто не попадёт, и это нормально
        );

        for (Flyable f : flyers) {
            f.fly();
        }
    }

    // базовый тип: "птица"
    static abstract class Bird {
        protected final String name;

        protected Bird(String name) {
            this.name = name;
        }

        public void eat() {
            System.out.println(name + " ест зерно (или что там есть)");
        }
    }

    // отдельная способность: "умеет летать"
    interface Flyable {
        void fly();
    }

    static class Sparrow extends Bird implements Flyable {
        Sparrow(String name) {
            super(name);
        }

        @Override
        public void fly() {
            System.out.println(name + " летит: фрррр!");
        }
    }

    static class Penguin extends Bird {
        Penguin(String name) {
            super(name);
        }

        @Override
        public void eat() {
            System.out.println(name + " ест рыбу");
        }

        // и всё — никаких "fly()" и никаких исключений
    }
}

