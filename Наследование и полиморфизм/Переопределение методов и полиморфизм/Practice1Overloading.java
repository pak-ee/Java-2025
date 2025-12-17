public class Practice1Overloading {
    static class Calculator {
        // Перегрузка: одно имя sum, но разные параметры
        int sum(int a, int b) {
            return a + b;
        }

        double sum(double a, double b) {
            return a + b;
        }

        int sum(int... numbers) {
            int result = 0;
            for (int n : numbers) result += n;
            return result;
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("sum(int,int) = " + c.sum(2, 3));
        System.out.println("sum(double,double) = " + c.sum(2.5, 3.1));
        System.out.println("sum(int...) = " + c.sum(1, 2, 3, 4));
    }
}

