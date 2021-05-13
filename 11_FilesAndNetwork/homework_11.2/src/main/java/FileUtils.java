import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FileUtils {
    private final static Logger logger = LogManager.getLogger();

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {

        Path pathIn = Paths.get(sourceDirectory);
        Path pathOut = Paths.get(destinationDirectory);
        try (Stream<Path> stream = Files.walk(pathIn)) {
            if (!Files.exists(pathIn)) {
                logger.error("Не найден путь: " + pathIn);
                throw new IOException();
            }
//            stream.forEach(path -> {
//                try {
//                    logger.info(String.format("Копируемый файл: %s. Путь файла: %s", path.getFileName(), path));
//                    Files.copy(path, pathOut.resolve(pathIn.relativize(path)), StandardCopyOption.REPLACE_EXISTING);
//                    logger.info(String.format("Файл %s скопирован в: %s", path.getFileName().toString(), pathOut.resolve(pathIn.relativize(path).toString())));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
            Files.walkFileTree(pathIn, new MyVisitor(pathIn, pathOut));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyVisitor implements FileVisitor<Path> {

        private final Path source;
        private final Path target;

        MyVisitor(Path source, Path target) {
            this.source = source;
            this.target = target;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Path newDir = target.resolve(source.relativize(dir));
            Files.copy(dir, newDir, StandardCopyOption.REPLACE_EXISTING);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Files.copy(file, target.resolve(source.relativize(file)), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            exc.printStackTrace();
            return FileVisitResult.TERMINATE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            return FileVisitResult.CONTINUE;
        }
    }

}
