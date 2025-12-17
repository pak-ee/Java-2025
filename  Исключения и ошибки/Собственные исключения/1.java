/**
 * Пример собственного (пользовательского) исключения.
 *
 * По соглашению такие классы называют с суффиксом "Exception".
 * Наследуемся от {@link Exception}, чтобы сделать исключение проверяемым (checked).
 */
public class MyFirstException extends Exception {

    /**
     * Конструктор без параметров.
     */
    public MyFirstException() {
        super();
    }

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message текстовое описание причины ошибки
     */
    public MyFirstException(String message) {
        super(message);
    }

    /**
     * Конструктор с сообщением и причиной (вложенным исключением).
     *
     * @param message текстовое описание причины ошибки
     * @param cause   исходная причина, приведшая к ошибке
     */
    public MyFirstException(String message, Throwable cause) {
        super(message, cause);
    }
}
