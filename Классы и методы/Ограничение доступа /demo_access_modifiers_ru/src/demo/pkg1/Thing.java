package demo.pkg1;

/**
 * Класс просто для демонстрации доступа.
 * Тут специально есть поля/методы с разными модификаторами.
 */
public class Thing {

    // public — видно вообще отовсюду
    public int pubValue = 10;

    // protected — видно в этом пакете и в наследниках (даже если наследник в другом пакете)
    protected int protValue = 20;

    // default (без слова) — видно только внутри этого пакета
    int defValue = 30;

    // private — видно только внутри самого класса Thing
    private int privValue = 40;

    public void publicMethod() {
        System.out.println("publicMethod(): можно вызывать откуда угодно");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod(): видно пакету и наследникам");
    }

    void defaultMethod() {
        System.out.println("defaultMethod(): видно только в demo.pkg1");
    }

    private void privateMethod() {
        System.out.println("privateMethod(): видно только внутри Thing");
    }

    public void showAllInside() {
        // Внутри класса доступны вообще все поля/методы — даже private.
        System.out.println("Внутри Thing вижу всё: " +
                pubValue + ", " + protValue + ", " + defValue + ", " + privValue);

        privateMethod(); // ок, потому что мы внутри Thing
    }
}
