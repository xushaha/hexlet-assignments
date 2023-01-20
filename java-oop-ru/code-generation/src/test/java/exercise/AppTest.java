package exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Map;
import java.util.HashMap;



class ValidationTest {

    private static ObjectMapper objectMapper;
    private static Path tempPath;

    @BeforeAll
    static void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    void createTempFile() throws Exception {
        tempPath = Files.createTempFile("temp", "");
    }

    @AfterEach
    void deleteTempFile() throws Exception {
        Files.deleteIfExists(tempPath);
    }

    private static String readFile(Path path) throws Exception {
        return Files.readString(path);
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src/test/resources/", fileName).toAbsolutePath().normalize();
    }

    @Test
    void testSave() throws Exception {
        User owner = new User(1, "Ivan", "Petrov", 25);
        Car car = new Car(1, "bmv", "x5", "black", owner);
        App.save(tempPath, car);
        String actualContent = readFile(tempPath);
        Map<String, Object> actual = objectMapper.readValue(actualContent, HashMap.class);
        String expectedContent = readFile(getFixturePath("expected1.json"));
        Map<String, Object> expected = objectMapper.readValue(expectedContent, HashMap.class);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testExtract() throws Exception {
        Path fixturePath = getFixturePath("car.json");
        Car instance = App.extract(fixturePath);
        assertThat(instance).isInstanceOf(Car.class);
        assertThat(instance.getId()).isEqualTo(5);
        assertThat(instance.getBrand()).isEqualTo("audi");
        assertThat(instance.getModel()).isEqualTo("q7");
        assertThat(instance.getColor()).isEqualTo("white");
        User owner = instance.getOwner();
        assertThat(owner).isInstanceOf(User.class);
        assertThat(owner.getFirstName()).isEqualTo("Nikolay");
        assertThat(owner.getLastName()).isEqualTo("Ivanov");
    }
}
