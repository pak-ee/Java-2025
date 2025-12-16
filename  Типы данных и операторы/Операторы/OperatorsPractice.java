public class OperatorsPractice {

    // Маленькие классы для instanceof
    static class Animal { }
    static class Dog extends Animal { }
    static class Cat extends Animal { }

    public static void main(String[] args) {

        System.out.println("=== Практика #1: операторы ===");

        // = (присваивание)
        int a = 10;
        System.out.println("a = " + a);

        // += -= *= /= %= (операторы присваивания с вычислением)
        a += 5;  // a = a + 5
        System.out.println("a += 5 -> " + a);

        a -= 3;  // a = a - 3
        System.out.println("a -= 3 -> " + a);

        a *= 2;  // a = a * 2
        System.out.println("a *= 2 -> " + a);

        a /= 4;  // a = a / 4 (целочисленное деление!)
        System.out.println("a /= 4 -> " + a);

        a %= 3;  // a = a % 3
        System.out.println("a %= 3 -> " + a);

        // ?: (тернарный оператор)
        int value = 7;
        String msg = (value % 2 == 0) ? "чётное" : "нечётное";
        System.out.println("value = " + value + ", (value%2==0) ? ... : ... -> " + msg);

        // || && (логические операторы, короткое замыкание)
        boolean p = true;
        boolean q = false;
        System.out.println("p || q -> " + (p || q));
        System.out.println("p && q -> " + (p && q));

        // | ^ & (побитовые на int)
        int x = 6;  // 110
        int y = 3;  // 011
        System.out.println("x | y  -> " + (x | y));  // 111 = 7
        System.out.println("x ^ y  -> " + (x ^ y));  // 101 = 5
        System.out.println("x & y  -> " + (x & y));  // 010 = 2

        // | ^ & (можно и для boolean, только без short-circuit)
        boolean b1 = true;
        boolean b2 = false;
        System.out.println("b1 | b2 -> " + (b1 | b2));
        System.out.println("b1 ^ b2 -> " + (b1 ^ b2));
        System.out.println("b1 & b2 -> " + (b1 & b2));

        // == != (сравнение)
        System.out.println("x == y -> " + (x == y));
        System.out.println("x != y -> " + (x != y));

        // > >= < <= (сравнения)
        System.out.println("x >  y -> " + (x > y));
        System.out.println("x >= y -> " + (x >= y));
        System.out.println("x <  y -> " + (x < y));
        System.out.println("x <= y -> " + (x <= y));

        // >> >>> << (сдвиги)
        int shiftLeft = x << 1;
        int shiftRight = x >> 1;

        int neg = -8;
        int signedRight = neg >> 1;     // сохраняет знак
        int unsignedRight = neg >>> 1;  // заполняет нулями слева

        System.out.println("x << 1   -> " + shiftLeft);
        System.out.println("x >> 1   -> " + shiftRight);
        System.out.println("-8 >> 1  -> " + signedRight);
        System.out.println("-8 >>> 1 -> " + unsignedRight);

        // + - * / % (арифметика)
        System.out.println("x + y -> " + (x + y));
        System.out.println("x - y -> " + (x - y));
        System.out.println("x * y -> " + (x * y));
        System.out.println("x / y -> " + (x / y));
        System.out.println("x % y -> " + (x % y));

        // ++ и -- (префикс и постфикс)
        int i = 5;

        int postInc = i++; // сначала вернули старое значение, потом увеличили i
        System.out.println("i=5; postInc = i++ -> postInc=" + postInc + ", i=" + i);

        int preInc = ++i;  // сначала увеличили i, потом вернули новое
        System.out.println("preInc = ++i -> preInc=" + preInc + ", i=" + i);

        int j = 5;

        int postDec = j--; // сначала вернули, потом уменьшили
        System.out.println("j=5; postDec = j-- -> postDec=" + postDec + ", j=" + j);

        int preDec = --j;  // сначала уменьшили, потом вернули
        System.out.println("preDec = --j -> preDec=" + preDec + ", j=" + j);

        // ~ и ! (унарные)
        System.out.println("~x -> " + (~x));     // побитовая инверсия
        System.out.println("!p -> " + (!p));     // логическое НЕ

        // ( ) и [ ] (скобки и индексация массива)
        int grouped = (2 + 3) * 4; // скобки меняют порядок вычислений
        int[] arr = {10, 20, 30};
        int second = arr[1];       // [] доступ к элементу
        System.out.println("(2 + 3) * 4 -> " + grouped);
        System.out.println("arr[1] -> " + second);

        // String: + и += (конкатенация)
        String s = "Hello";
        String concat = s + ", " + "world" + " " + x; // + склеивает строки
        System.out.println("concat -> " + concat);

        s += "!!!"; // += тоже умеет конкатенацию для String
        System.out.println("s после s += \"!!!\" -> " + s);

        // == != для String (сравнивает ссылки, не содержимое — просто показать сам оператор)
        String s1 = new String("hi");
        String s2 = new String("hi");
        System.out.println("s1 == s2 -> " + (s1 == s2));     // почти всегда false
        System.out.println("s1 != s2 -> " + (s1 != s2));     // почти всегда true
        System.out.println("s1.equals(s2) -> " + s1.equals(s2)); // вот так сравнивают текст

        System.out.println("\n=== Практика #2: instanceof ===");

        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = null;

        // instanceof true, если объект — экземпляр типа или его подкласса
        System.out.println("a1 instanceof Dog -> " + (a1 instanceof Dog));       // true
        System.out.println("a1 instanceof Animal -> " + (a1 instanceof Animal)); // true
        System.out.println("a1 instanceof Cat -> " + (a1 instanceof Cat));       // false

        System.out.println("a2 instanceof Cat -> " + (a2 instanceof Cat));       // true

        // Важно: если слева null — результат просто false (и исключения нет)
        System.out.println("a3 (null) instanceof Animal -> " + (a3 instanceof Animal)); // false
    }
}

