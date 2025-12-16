public class FinalInitExamples {

    // 1) Инициализация прямо в месте объявления
    static class A1 {
        public final int a = 10; // сразу дали значение — всё ок
    }

    // 2) Инициализация в обычном блоке инициализации
    static class A2 {
        public final int a;

        { 
            // этот блок выполняется при создании объекта, до конструктора
            a = 20;
        }
    }

    // 3) Инициализация в конструкторе без параметров
    static class A3 {
        public final int a;

        public A3() {
            // главное — присвоить значение тут
            a = 30;
        }
    }

    // 3) Инициализация в конструкторе с параметром (часто самый удобный вариант)
    static class A4 {
        public final int a;

        public A4(int a) {
            // "a" снаружи кладём в поле объекта
            this.a = a;
        }
    }

    // 3) Если конструкторов несколько — обычно делают цепочку this(...)
    static class A5 {
        public final int a;

        public A5() {
            // чтобы не повторять присваивание, зовём другой конструктор
            this(50);
        }

        public A5(int value) {
            this.a = value; // присваивание происходит в одном месте
        }
    }

    public static void main(String[] args) {
        System.out.println(new A1().a);
        System.out.println(new A2().a);
        System.out.println(new A3().a);
        System.out.println(new A4(40).a);
        System.out.println(new A5().a);
    }
}

