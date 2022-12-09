# Другие коллекции

Иногда в программировании возникает задача поиска разницы между двумя наборами данных, такими как ассоциативные массивы. Например, при поиске различий в json файлах. Для этого даже существуют специальные сервисы, например, http://www.jsondiff.com/ (попробуйте нажать на ссылку sample data и затем кнопку Compare).

## Ссылки

* [Класс TreeSet](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeSet.html)
* [Класс LinkedHashMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedHashMap.html)

## main/java/exercise/App.java

## Задачи

* Создайте класс `App`. В классе реализуйте публичный статический метод `genDiff()`, который принимает в качестве аргументов два словаря `Map`. Ключами в этих словарях всегда являются строки, а вот значениями могут быть данные любого типа (например, строки, целые числа, булевы значения).
Метод должен сравнивать значения в словарях и возвращать результат сравнения в виде словаря `LinkedHashMap`. Ключами результирующего словаря будут все ключи из двух входящих словарей, а значением каждого ключа — строка с описанием отличий (added, deleted, changed или unchanged).

  Возможные значения:

  * "added" — ключ отсутствовал в первом массиве, но был добавлен во второй
  * "deleted" — ключ был в первом массиве, но отсутствует во втором
  * "changed" — ключ присутствовал и в первом и во втором массиве, но значения отличаются
  * "unchanged" — ключ присутствовал и в первом и во втором массиве с одинаковыми значениями

  Ключи в результирующем словаре должны быть отсортированы в алфавитном порядке.

```java
Map<String, Object> data1 = new HashMap<>(
    Map.of("one", "eon", "two", "two", "four", true)
);
System.out.println(data1); //=> {two=two, four=true, one=eon}

Map<String, Object> data2 = new HashMap<>(
    Map.of("two", "own", "zero", 4, "four", true)
);
System.out.println(data2); //=> {zero=4, two=own, four=true}

Map<String, String> result = App.genDiff(data1, data2);
System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
```

## Подсказки

* Так как значением в исходных словарях могут быть данные любого типа, вам понадобится использовать тип `Object`
