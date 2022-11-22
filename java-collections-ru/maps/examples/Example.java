package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

    public static void main(String[] args) {
        // Maps
        // проблематика: как по номеру машины найти модель автомобиля
        // можно попробовать сделать через List
        String model = getModelByPlateNumber("O023TO198");
        System.out.println("Используя List, мы определили модель авто: " + model);

        // А как сделать лучше? Используем коллекцию Map
        Map<String, String> cars = new HashMap<>();
        // метод put добавляет в ассоциативный массив пару ключ-значение
        cars.put("O023TO198", "Volvo");
        cars.put("O025XE777", "Nissan");
        cars.put("O001OO777", "BMW");

        System.out.println("Получили следующую структуру данных: " + cars);
//
        // метод get возвращает значение по ключу
        String modelFromMap = cars.get("O023TO198");
        System.out.println("Используя Map, мы определили модель авто: " + modelFromMap);
        System.out.println("Используя Map, мы определили модель авто: " + cars.get("O025XE700"));
//
        // key может быть null
        cars.put(null, "Lada");
        System.out.println(cars);
//
//        // замена одного значения на другое
        cars.put("O025XE777", "Audi");
        System.out.println(cars);
//
//
//        // базовые операции
        Map<String, Integer> people = new HashMap<>();
        people.put("Max", 2006);
        people.put("Petr", 1998);
        people.put("Ivan", 1981);
//
        System.out.println(people);
        System.out.println("Размер Map: " + people.size());
//
        Map<String, Integer> additionalPeopleMap = new HashMap<>();
        additionalPeopleMap.put("Vladimir", 1978);
        additionalPeopleMap.put("Robert", 2010);
        additionalPeopleMap.put("Ibrahim", 2011);
//
        people.putAll(additionalPeopleMap);
//
        System.out.println(people);
//
//
        System.out.println("contains key = Max ? - " + people.containsKey("Max"));
        System.out.println("contains value = 2010 ? - " + people.containsValue(2021));
//
        people.remove("Robert");
        System.out.println(people);

        people.clear();
        System.out.println(people);
//
//
//        // Map.Entry
        Map<String, String> students = new HashMap<>();
        students.put("Max", "Maximov");
        students.put("Petr", "Petrov");
        students.put("Ivan", "Ivanov");

        System.out.println(students.entrySet());

        // 1 способ получения значения по ключу
//        for (String s: students.keySet()) {
//            String lastname = students.get(s);
//        }

        // 2 cпособ получения значения по ключу - более употребим
        for (Map.Entry<String, String> student: students.entrySet()) {
            System.out.println(
                "Student name is = " + student.getKey() + " and student lastname is = " + student.getValue()
            );
        }
//
    }
//
//    /**
//     * Метод возвращает заполненный список строк в заданном формате: [госномер номер]:[марка автомобиля]
//     * @return Заполненный список номеров и моделей автомобилей.
//     */
    private static List<String> getCarsList() {
        // создаем список строк
        List<String> cars = new ArrayList<>();
        // добавляем элементы в список
        cars.add("O023TO198:Volvo");
        cars.add("O025XE777:Nissan");
        cars.add("O001OO777:BMW");
        return cars;
    }

    /**
     * Метод пытается найти модель автомобиля по указанному госномеру.
     * @param plateNumber Госномер авто.
     * @return Модель автомобиля.
     */
    private static String getModelByPlateNumber(String plateNumber) {
        // перебираем элементы списка
        for (String car : getCarsList()) {
            // метод split помещает элементы строки, разделенные строкой (в нашем случае - : ) в строчный массив
            String[] modelAndPlateNumber = car.split(":");
            // проверяем, госномер элемента списка совпадает с переданным значением в качестве аргумента
            if (modelAndPlateNumber[0].equals(plateNumber)) {
                // возвращаем модель авто и прекращаем выполнение метода
                return modelAndPlateNumber[1];
            }
        }
        return null;
    }
}
