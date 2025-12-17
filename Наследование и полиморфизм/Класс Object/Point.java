public final class Point {
    private final int x;
    private final int y;

    // Создаём неизменяемую точку (x, y).
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        // Рефлексивность: объект равен сам себе.
        if (this == other) return true;
        // Сравнение с null должно возвращать false.
        // getClass() вместо instanceof — строгая проверка, что классы совпадают (без равенства с подклассами).
        if (other == null || getClass() != other.getClass()) return false;
        // На этом этапе мы уверены, что other — Point, можно приводить тип.
        Point point = (Point) other;
        // Смысловое равенство: сравниваем значимые поля.
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        // Должен быть согласован с equals():
        // если equals() возвращает true, то hashCode() обязан совпадать.
        return 31 * x + y;
    }

    @Override
    public String toString() {
        // Удобное строковое представление для отладки/логов.
        return "Point{x=" + x + ", y=" + y + '}';
    }

    public static void main(String[] args) {
        // Небольшая проверка работы equals/hashCode/toString.
        Point a = new Point(1, 2);
        Point b = new Point(1, 2);
        Point c = new Point(2, 3);

        System.out.println("a.equals(b) = " + a.equals(b));
        System.out.println("a.hashCode()==b.hashCode() = " + (a.hashCode() == b.hashCode()));
        System.out.println("a.equals(c) = " + a.equals(c));
        System.out.println("a = " + a);
    }
}
