# Wrapper practice (java.lang wrappers)

Тут один файл `WrapperPractice.java`, который закрывает задания:

- Практика #1: примеры `decode()`
- Практика #2: все способы создать `Boolean`
- Практика #3: когда при boxing/unboxing ловим `NullPointerException`
- Практика #4: вывод для 128 и 127 + объяснение `IntegerCache`

## Как запустить

```bash
javac WrapperPractice.java
java WrapperPractice
```

## Важные мысли (кратко)

- `Integer.decode(...)` понимает `0x`, `#` (hex) и ведущий `0` (oct). `0b` не понимает.
- `==` для `Integer` vs `Integer` сравнивает ссылки (объекты), а не значения.
- `IntegerCache` экономит память и ускоряет работу для маленьких чисел (обычно -128..127).
