# Генерация кода

В этом задании вам предстоит поработать с библиотекой Lombok, которая позволяет генерировать код с помощью аннотаций.

## Ссылки

* [Проект Lombok](https://projectlombok.org/)
* [Объект DataMapper](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html)
* [Метод readValue()](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html#readValue(java.lang.String,%20java.lang.Class))
* [Метод writeValueAsString()](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html#writeValueAsString(java.lang.Object))
* [Класс Files для работы с файлами](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html)

## main/java/exercise/User.java

## Задачи

* В файле создан класс `User`, который описывает владельца автомобиля. В классе уже определены все свойства, но нет конструктора и геттеров. Допишите нужную аннотацию lombock, чтобы автоматически сгенерировать конструктор и геттеры для всех свойств и сделать класс неизменяемым.

```java
User owner = new User(1, "Ivan", "P", 25);
// Вызываем автоматически сгенерированный геттер
owner.getFirstName(); // "Ivan"
```

## main/java/exercise/Car.java

## Задачи

* В файле уже создан класс `Car`, который описывает автомобиль. Допишите нужную аннотацию lombock, чтобы автоматически сгенерировать конструктор и геттеры для всех свойств и сделать класс неизменяемым.

* Дополнительно создайте в классе два метода:

  * Публичный метод `serialize()` — cериализует объект. Метод возвращает JSON представление объекта (в виде строки).
  * Публичный статический метод `unserialize()`, который принимает в качестве аргумента строку (JSON представление объекта класса `Car`) и возвращает объект класса `Car` с соответствующими свойствами.

  ```java
  Car car = new Car(1, "bmv", "x5", "black", owner);
  String jsonRepresentation = car.serialize();
  System.out.println(jsonRepresentation); // =>
  /*
  {
    "id":1,
    "brand":"bmv",
    "model":"x5",
    "color":"black",
    "owner":{
        "id":1,
        "firstName":"Ivan",
        "lastName":"P",
        "age":25
    }
  }
  */

  String jsonRepresentation = // получаем JSON представление объекта
  Car instance = Car.unserialize(jsonRepresentation);
  instance.getBrand(); // "bmv"
  instance.getModel(); // "x5"
  ```

## main/java/exercise/App.java

## Задачи

* Создайте класс `App` с публичными статическими методами:

  * `save()` — принимает в качестве аргумента путь к файлу (объект класса `Path`) и объект класса `Car`. Метод сохраняет представление объекта в файл по переданному пути. Чтобы сохранить объект в файл, вам нужно будет представить его в виде строки (сериализовать).

  * `extract()` — принимает в качестве аргумента путь к файлу (объект класса `Path`), в котором содержится JSON представление объекта `Car` и возвращает инстанс класса `Car` с соответствующими свойствами.

```java
Path path1 = Paths.get("/tmp/file1.json");
Car car1 = new Car(1, "audi", "q3", "black", owner);
App.save(path1, car1); // Сохраняет представление объекта в файл

Path path2 = Paths.get("/tmp/file2.json");
Car car2 = App.extract(path2); // Возвращает инстанс класса Car
car2.getModel(); // "passat"
```

## Подсказки

* Для преобразования объекта в JSON строку и обратно, воспользуйтесь классом [ObjectMapper](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html)
