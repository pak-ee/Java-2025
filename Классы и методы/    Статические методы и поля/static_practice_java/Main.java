public class Main {
    public static void main(String[] args) {
        // 1) Рекомендуемый вариант — через имя класса:
        A.printVars();

        // 2) Вызов через объект (так можно, но так делать не принято):
        A obj = new A();
        obj.printVars();
        new A().printVars();

        // 3) Вызовы "изнутри" A (через методы-посредники):
        A.callFromStaticInsideA();
        obj.callFromInstanceInsideA();

        // 4) Через имя наследника:
        B.printVars();

        // 5) Через ссылку типа A, которая указывает на B:
        A ref = new B();
        ref.printVars();
        // Важно: static выбирается на этапе компиляции, поэтому по сути это A.printVars()
    }
}
