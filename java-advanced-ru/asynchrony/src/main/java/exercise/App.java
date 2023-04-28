
package exercise;

import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String sourcePath1, String sourcePath2, String resultPath) {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                return readFile(sourcePath1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });



        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                return readFile(sourcePath2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });



        CompletableFuture<String> futureResult = future1.thenCombine(future2, (str1, str2) -> {
            String result = str1 + str2;
            try {
                writeFile(resultPath, result);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return result;

        }).exceptionally(ex -> {
            System.out.println("NoSuchFileException");
            return null;
        });

        return futureResult;
    }

    public static String readFile(String sourcePath) throws Exception {
        Path path = Path.of(sourcePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return Files.readString(path);

    }
    public static void writeFile(String sourcePath, String content) throws Exception {
        Path path = Path.of(sourcePath).toAbsolutePath().normalize();
        Files.writeString(path, content);
    }

    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles(
                "./src/main/resources/file1.txt",
                "./src/main/resources/file2.txt",
                "./src/main/resources/result.txt");
        // END
    }
}
