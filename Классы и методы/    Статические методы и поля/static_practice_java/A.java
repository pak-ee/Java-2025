public class A {
    public static int a = 1;
    public static int b; // по умолчанию будет 0

    public static void printVars() {
        // Печатаем текущие значения статических полей.
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void callFromStaticInsideA() {
        // Находясь внутри A, можно вызвать и так, и так.
        printVars();      // коротко (мы внутри A)
        A.printVars();    // явно через имя класса
    }

    public void callFromInstanceInsideA() {
        // Это НЕ static-метод, но static-метод вызвать можно.
        printVars();         // нормально
        this.printVars();    // компилируется, но обычно так не пишут
    }
}
