package exercise;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        // problem
//        Animal frog = new Frog();
//        frog.setX(1);
//        frog.setY(1);
//        frog.go();
//        frog.eat();
//        frog.jump();

//        Animal dog = new Dog();
//        dog.setX(3);
//        dog.setY(2);
//        dog.go();
//        dog.eat();
//        dog.bite();

        List<Animal> animals = List.of(new Frog(), new Dog());
        for (Animal animal : animals) {
            animal.go();
        }

        for (Animal animal: animals) {
            animal.eat();
        }

        // Dog and Frog extends Animal

        // super

        // abstract
    }
}
