import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        // Файл можно передать первым аргументом командной строки,
        // иначе будет использован input.txt из текущей папки.
        String fileName = args.length > 0 ? args[0] : "input.txt";
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            // Пример 1: чтение построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Если нужно читать токены/числа, используйте hasNextInt()/nextInt(), next(), etc.
            // Например:
            // while (scanner.hasNextInt()) {
            //     int number = scanner.nextInt();
            //     System.out.println(number);
            // }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file.getAbsolutePath());
        }
    }
}

