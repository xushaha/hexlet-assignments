# Словари

## Ссылки

* [Класс HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

## main/java/exercise/App.java

## Задачи

* Создайте класс `App` с публичным статическим методом `getWordCount()`, который принимает в качестве аргумента предложение. Метод возвращает словарь `Map`, в котором ключи — это слова исходного предложения, а значения — количество соответствующих слов в предложении. Слова в предложении разделены пробелами.

```java
String sentence = "java is the best programming language java";
Map wordsCount = App.getWordCount(sentence);
System.out.println(wordsCount); // => {the=1, java=2, is=1, best=1, language=1, programming=1}
```

* В классе `App` создайте публичный статический метод `toString()`, который принимает в качестве аргумента словарь `Map` с количеством слов в предложении. Метод должен возвращать строковое представление словаря. Обратите внимание на форматирование вывода. Результат должен быть заключен в фигурные скобки, каждое слово выводится с новой строки с отступом в 2 пробела.

```java
String sentence = "the java is the best programming language java";
Map wordsCount = App.getWordCount(sentence);
String result = App.toString(wordsCount);
System.out.println(result); // =>
// {
//   the: 2
//   java: 2
//   is: 1
//   best: 1
//   language: 1
//   programming: 1
// }

Map wordsCount2 = App.getWordCount("");
String result2 = App.toString(wordsCount2);
System.out.println(result2); // => {}
```

## Подсказки

* Можно получить все ключи словаря при помощи метода `keySet()` класса `HashMap` и обойти их в цикле.
