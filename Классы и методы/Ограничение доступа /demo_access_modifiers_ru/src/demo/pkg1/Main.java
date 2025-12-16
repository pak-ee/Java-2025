package demo.pkg1;

import demo.pkg2.Child;
import demo.pkg2.OtherPackage;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1) Доступ из того же пакета (demo.pkg1) ===");
        Thing t = new Thing();

        // В этом же пакете видим public / protected / default.
        System.out.println("pubValue = " + t.pubValue);
        System.out.println("protValue = " + t.protValue);
        System.out.println("defValue = " + t.defValue);

        t.publicMethod();
        t.protectedMethod();
        t.defaultMethod();

        // private — не видно, даже если пакет тот же.
        // System.out.println(t.privValue);     // НЕ скомпилируется
        // t.privateMethod();                  // НЕ скомпилируется

        t.showAllInside(); // внутри Thing всё видно, включая private

        System.out.println();
        System.out.println("=== 2) Доступ из другого пакета, но НЕ наследник (demo.pkg2) ===");
        new OtherPackage().run();

        System.out.println();
        System.out.println("=== 3) Доступ из другого пакета, НО через наследование (protected) ===");
        new Child().run();
    }
}
