public class Practice4StringPlus {
    public static void main(String[] args) {
        int age = 19;
        double score = 4.5;

        String s1 = "Возраст: " + age;
        String s2 = "Оценка: " + score;

        Object obj = "текст";
        String s3 = "Объект: " + obj;

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // ещё пример: слева String -> дальше всё склеивается как строки
        System.out.println("Сумма как строка: " + 10 + 5); // будет "105"
        System.out.println("Сумма как число: " + (10 + 5)); // будет "15"
    }
}
