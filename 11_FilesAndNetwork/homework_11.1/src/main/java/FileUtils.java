import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {
    private static final Logger logger = LogManager.getLogger();

    public static long calculateFolderSize(String path) {
        long sumSize;
        File file = new File(path);
        try {
            if (!file.exists()) {
                logger.error("Не найден путь: " + path);
                throw new IOException();
            }
            sumSize = Arrays.stream(file.listFiles()).mapToLong(file1 -> {
                logger.info("В обработке: " + file1.getAbsolutePath());
                return file1.isDirectory() ? calculateFolderSize(file1.getAbsolutePath())
                        : file1.length();
            }).sum();
            logger.info("Сумма составляет: " + sumSize + " byte");
            return sumSize;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
