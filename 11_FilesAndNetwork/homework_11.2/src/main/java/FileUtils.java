import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class FileUtils {
    private final static Logger logger = LogManager.getLogger();

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        Path pathIn = Paths.get(sourceDirectory);
        Path pathOut = Paths.get(destinationDirectory);
        try (Stream<Path> stream = Files.walk(pathIn)) {
            if (!Files.exists(pathIn)) {
                logger.error("Не найден путь: " + pathIn);
                throw new IOException();
            }
            stream.forEach(path -> {
                try {
                    Files.copy(path, pathOut.resolve(pathIn.relativize(path)), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
