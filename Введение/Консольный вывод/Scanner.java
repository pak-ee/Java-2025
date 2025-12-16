import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scan.nextLine(); // можно next(), но nextLine() читает всю строку

        System.out.println("Привет, " + name);

        scan.close();
    }
}

