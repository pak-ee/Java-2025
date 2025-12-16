interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
        System.out.println("Гав!");
    }
}

public class Practice8InterfaceVar {
    static Animal createAnimal() {
        return new Dog();
    }

    public static void main(String[] args) {
        Animal a1 = new Dog();
        a1.speak();

        // var доступен с Java 10
        var a2 = createAnimal(); // тут тип выведется как Animal
        a2.speak();
    }
}
