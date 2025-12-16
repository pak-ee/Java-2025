public class Practice3Scope {
    public static void main(String[] args) {
        int a = 1;

        {
            int b = 2;
            System.out.println("Внутри блока b = " + b);
        }

        // Ниже так делать нельзя — b вне блока уже не существует.
        // int c = a + b; // <-- будет ошибка компиляции

        // Если нужно посчитать c, b надо объявить "снаружи":
        int b = 2;
        int c = a + b;

        System.out.println("c = " + c);
    }
}
