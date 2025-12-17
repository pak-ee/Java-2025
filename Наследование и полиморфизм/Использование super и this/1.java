public class Practice1SuperDemo {
    static class Parent {
        protected int value;

        Parent(int value) {
            this.value = value;
        }

        void printValue() {
            System.out.println("Parent.value = " + value);
        }
    }

    static class Child extends Parent {
        private final int value; // скрывает поле Parent.value

        // 1) обращение к конструктору суперкласса
        Child(int parentValue, int childValue) {
            super(parentValue);
            this.value = childValue;
        }

        void demo() {
            // 2) доступ к полю суперкласса
            int parentField = super.value;
            System.out.println("super.value = " + parentField);

            // 3) доступ к методу суперкласса
            super.printValue();

            System.out.println("Child.value = " + this.value);
        }
    }

    public static void main(String[] args) {
        new Child(10, 99).demo();
    }
}
