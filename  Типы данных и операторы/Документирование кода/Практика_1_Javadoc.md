Практика №1: javadoc

Javadoc — это утилита из JDK, которая делает HTML-документацию из комментариев вида /** ... */.

Пример:

public class MathUtils {
    /**
     * Складывает два числа.
     * @param a первое число
     * @param b второе число
     * @return сумма
     */
    public static int add(int a, int b) {
        return a + b;
    }
}

Основные теги:
@author, @version, @since, @param, @return, @throws (@exception), @see, @deprecated

Как сгенерировать документацию:

1) Проверка, что javadoc есть:
javadoc -version

2) По одному файлу:
javadoc -d docs -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 MathUtils.java

3) По пакету из src:
javadoc -d docs -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 -sourcepath src -subpackages com.example

Результат: папка docs, открыть docs/index.html
