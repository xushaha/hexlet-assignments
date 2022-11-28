# Тестирование

## src/test/java/exercise/AppTest.java

## Задачи

Напишите тесты для публичного статического метода `take()`. Метод принимает в качестве аргументов список `List` целых чисел и число элементов, а возвращает новый список, который содержит первые `n` элементов исходного списка.

```java
List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
System.out.println(App.take(numbers1, 2)); // => [1, 2]

List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
System.out.println(App.take(numbers2, 8)); // => [7, 3, 10]
```
