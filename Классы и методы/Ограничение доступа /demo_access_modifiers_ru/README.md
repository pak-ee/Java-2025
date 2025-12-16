# Демонстрация модификаторов доступа (public/protected/default/private)

Тут маленький пример на 2 пакета.

## Как собрать и запустить (Linux/macOS/Git Bash)
```bash
cd demo_access_modifiers_ru
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out demo.pkg1.Main
```

Если раскомментировать строки с пометкой "НЕ скомпилируется" — компилятор покажет ошибку,
это и есть демонстрация ограничений доступа.
