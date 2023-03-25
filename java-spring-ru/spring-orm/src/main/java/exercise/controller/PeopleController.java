package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {

    // Автоматически заполняем значение поля
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return this.personRepository.findById(id);
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }


    // BEGIN
/*  Допишите метод, который обрабатывает POST-запросы по пути /people и добавляет новую сущность в базу данных.
    Чтобы привязать параметр метода к телу запроса, используйте аннотацию @RequestBody  */
    @PostMapping(path = "")
    public void addPerson(@RequestBody Person person) {
        this.personRepository.save(person);
    }


  /*  Допишите метод, который обрабатывает DELETE-запросы по пути /people/{id} и удаляет сущность из базы.
    Чтобы получить id сущности из пути, используйте аннотацию @PathVariable*/

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable long id) {
        this.personRepository.deleteById(id);
    }

    /*Допишите метод, который обрабатывает PATCH-запросы по пути /people/{id} и обновляет данные сущности*/
    /*Метод save() не только добавляет новую сущность в базу, но и обновляет данные уже существующей.
    Чтобы обновить сущность при помощи метода save(), потребуется установить её id. Для этого вам понадобится написанный сеттер*/
    @PatchMapping(path = "/{id}")
    public void updatePerson(@PathVariable long id, @RequestBody Person person) {
        person.setId(id);
        this.personRepository.save(person);
    }


    // END
}
