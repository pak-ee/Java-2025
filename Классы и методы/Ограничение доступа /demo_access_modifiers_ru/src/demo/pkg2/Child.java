package demo.pkg2;

import demo.pkg1.Thing;

/**
 * Наследник в другом пакете.
 * Важно: protected здесь доступен через наследование (через this).
 */
public class Child extends Thing {

    public void run() {
        System.out.println("Наследник в другом пакете:");

        // public — конечно доступен
        System.out.println("pubValue = " + pubValue);
        publicMethod();

        // protected — доступен, потому что мы наследник
        System.out.println("protValue = " + protValue);
        protectedMethod();

        // default — НЕ доступен, потому что другой пакет
        // System.out.println(defValue);     // НЕ скомпилируется
        // defaultMethod();                  // НЕ скомпилируется

        // private — не доступен вообще нигде снаружи
        // System.out.println(privValue);    // НЕ скомпилируется
        // privateMethod();                  // НЕ скомпилируется
    }
}
