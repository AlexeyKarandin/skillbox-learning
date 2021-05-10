import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    private static final Logger logger = LogManager.getLogger();

    public static long calculateFolderSize(String path) {
        long sumSize;
        Path pat = Paths.get(path);
        try {
            if (!Files.exists(pat)) {
                logger.error("Не найден путь: " + path);
                throw new IOException();
            }
            sumSize = Files.walk(pat)
                    .filter(Files::isRegularFile)
                    .filter(Files::exists)
                    .mapToLong(file1 -> {
                        try {
                            return Files.size(file1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return 0;
                    })
                    .sum();
            logger.info("Сумма составляет: " + sumSize + " byte");
            return sumSize;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
