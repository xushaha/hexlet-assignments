# Продвинутые стримы

При работе с разными окружениями часто возникает необходимость передавать в них разные переменные окружения из конфигурационного файла.

## Ссылки

* [Метод строки startsWith](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#startsWith(java.lang.String))
* [Метод строки replaceAll](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#replaceAll(java.lang.String,java.lang.String))

## main/java/exercise/App.java

## Задачи

* Создайте класс `App` и публичный статический метод `getForwardedVariables()`. Метод принимает на вход содержимое конфигурационного файла в виде строки, находит в нем переменные окружения, которые нужно передать и возвращает их в виде строки формата "имя1=значение1,имя2=значение2,имя3=значение3,...".

  Переменные окружения в конфигурационном файле устанавливаются командой `environment`, после которой в кавычках указан список переменных через запятую.

  ```
  environment="X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en"
  ```

  Те переменные, которые нужно пробросить, начинаются с префикса `X_FORWARDED_`. В итоговую строку имена переменных должны попадать без этого префикса. Например, если в конфигурационном файле переменная устанавливается так: `X_FORWARDED_HOME=/home/tirion`, то в итоговой строке она должна выглядеть так: "HOME=/home/tirion".

Конфигурационный файл *s.conf*

```
[program:prepare]
command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'
autorestart=false
environment="X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en"

[program:http_server]
command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make environment'
environment="key5=value5,X_FORWARDED_var3=value,key6=value6"
```

```java
// Читаем содержимое файла и записываем его в переменную content. Реализовывать это в домашней работе не нужно.
String content = Files.readString("s.conf");

// Передаем содержимое файла в метод
String result = App.getForwardedVariables(content);
System.out.println(result); // => "MAIL=tirion@google.com,HOME=/home/tirion,var3=value"
```

## Подсказки

* Примеры конфигурационных файлов можно посмотреть в директории *src/test/resources/fixtures*
