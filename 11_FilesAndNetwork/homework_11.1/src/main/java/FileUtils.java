import java.io.File;
import java.util.Arrays;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long sumSize;
        File file = new File(path);
        sumSize = Arrays.stream(file.listFiles()).mapToLong(file1 ->
                file1.isDirectory() ? calculateFolderSize(file1.getAbsolutePath())
                : file1.length()).sum();
        return sumSize;
    }
}
