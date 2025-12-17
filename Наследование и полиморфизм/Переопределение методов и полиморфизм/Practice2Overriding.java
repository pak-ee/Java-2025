public class Practice2Overriding {
    static class Animal {
        String speak() {
            return "???";
        }

        Animal child() {
            return new Animal();
        }
    }

    static class Dog extends Animal {
        @Override
        String speak() {
            return "Woof!";
        }

        // Ковариантный тип возвращаемого значения: можно вернуть подтип (Dog вместо Animal).
        @Override
        Dog child() {
            return new Dog();
        }

        /*
        // Так НЕЛЬЗЯ: возвращаемый тип не является подтипом Animal -> ошибка компиляции.
        @Override
        int child() {   // error: return type int is not compatible with Animal
            return 1;
        }
        */
    }

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Dog(); // тип переменной Animal, но объект Dog

        // Динамическое связывание: вызывается версия метода по РЕАЛЬНОМУ типу объекта.
        System.out.println("Animal.speak(): " + a1.speak());
        System.out.println("Dog as Animal.speak(): " + a2.speak());
    }
}

