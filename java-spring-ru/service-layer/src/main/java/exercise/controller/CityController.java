package exercise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN

    /* Создайте в контроллере метод, который обрабатывает GET запросы по адресу /cities/{id}
     и выводит информацию о конкретном городе и о погоде в нём в виде JSON.
     Например, запрос на адрес /cities/1 должен вернуть такие данные:
  {   "name":"San Simon",
      "temperature":"25",
      "cloudy":"Partly cloudy",
      "humidity":"90",
      "wind":"13"} */
    @GetMapping(path = "/cities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getCityByName(@PathVariable long id) throws JsonProcessingException {
/*        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City with id " + id + " is not found"));*/
        return weatherService.getWeatherById(id);
    }
    /* Создайте в контроллере метод, который обрабатывает GET запросы по адресу /search
    и возвращает список городов. Метод должен поддерживать фильтрацию по названию города.
    Метод должен возвращать список всех городов, имя которых начинается с переданного префикса без учёта регистра.
    Данные для фильтрации передаются в query string. Например, GET запрос на адрес /search?name=be должен вернуть
    все города, название которых начинается со строки "be", регистр при этом не учитывается.

    Возвращаемые данные должны содержать имя города и температуру в нём:
  GET  /search?name=ca

      {   "temperature":"1",
          "name":"Capas"
      },*/

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, String>> getCities(@RequestParam(required = false) String name) {

        List<City> cities = new ArrayList<>();

        if (name == null) {
            cities = cityRepository.findAllByOrderByName();
        } else {
            cities = cityRepository.findAllByNameStartingWithIgnoreCase(name);
        }

        return cities.stream()
                .map(x -> {
                    Map<String, String> weather = new HashMap<>();
                    try {
                        weather = weatherService.getWeatherById(x.getId());
                    } catch (JsonProcessingException e) {
                        throw new CityNotFoundException("City with id " + x.getId() + " is not found");
                    }
                    return Map.of(
                            "name", x.getName(),
                            "temperature", weather.get("temperature")
                    );
                })
                .collect(Collectors.toList());

    }


    // END
}



