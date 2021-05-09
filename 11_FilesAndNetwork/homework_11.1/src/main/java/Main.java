import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum;
        String path;
        while (true) {
            System.out.print("Введите путь до папки(для выхода ввести exit): ");
            path = scanner.nextLine();
            if (path.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                sum = FileUtils.calculateFolderSize(path);
                if (sum == -1) throw new InvalidParameterException();
                System.out.printf("Размер папки %s составляет: %s%n", path, getVieSum(sum));
            } catch (InvalidParameterException e) {
                System.out.println("Не указана или указана не верно директория поиска");
            }

        }
    }

    public static String getVieSum(Long sum) {
        double viewSum;
        if (sum < 1024) {
            return (sum + " byte");
        } else if (sum < 1_048_576) {
            viewSum = (double)sum / 1024;
            return (viewSum + " Kb");
        } else if (sum < 1_073_741_824) {
            viewSum = (double)sum / 1024;
            viewSum /= 1024;
            return (viewSum + " Mb");
        } else {
            viewSum = (double)sum / 1024;
            viewSum /= 1024;
            viewSum /= 1024;
            return (viewSum + " Gb");
        }
    }
}
