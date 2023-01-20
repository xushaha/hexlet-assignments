package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {

    public static void save(Path path, Car car) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path.toString()), car);
    }

    public static Car extract(Path path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path.toString()), Car.class);
    }

    }
// END