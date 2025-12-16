package demo.pkg2;

import demo.pkg1.Thing;

/**
 * Другой пакет, и мы НЕ наследуемся от Thing.
 * Поэтому тут нормально доступен только public.
 */
public class OtherPackage {

    public void run() {
        Thing t = new Thing();

        System.out.println("В другом пакете (не наследник):");

        System.out.println("pubValue = " + t.pubValue);
        t.publicMethod();

        // protected / default / private тут недоступны:
        // System.out.println(t.protValue);   // НЕ скомпилируется
        // System.out.println(t.defValue);    // НЕ скомпилируется
        // System.out.println(t.privValue);   // НЕ скомпилируется

        // t.protectedMethod();              // НЕ скомпилируется
        // t.defaultMethod();                // НЕ скомпилируется
        // t.privateMethod();                // НЕ скомпилируется
    }
}
