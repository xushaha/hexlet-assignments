class Example {
    public static void main(String[] args) {
        // Допустим, нам нужно вывести на экран
        // список домашних животных и возвращает только имена питомцев,
        // отсортированные по алфавиту

        List<Map<String, String>> animals = List.of(
            Map.of("name", "Spooky", "animal", "dog"),
            Map.of("name", "Tom", "animal", "cat"),
            Map.of("name", "Jimmy", "animal", "bird"),
            Map.of("name", "Buddy", "animal", "dog"),
            Map.of("name", "Elsa", "animal", "dog"),
            Map.of("name", "Murka", "animal", "cat")
        );

        // Создадим метод getPetNames() в классе AppExample
        // Для этого будем использовать Stream API и лямбды

        AppExample.getPetNames(animals, "dog"); // [Buddy, Elsa, Spooky]
    }
}

