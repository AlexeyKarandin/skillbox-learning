import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathIn, pathOut;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Программа копирования файла(ов). Для выхода ввести exit");
        while (true) {
            try  {
                System.out.print("Откуда копировать: ");
                pathIn = scanner.nextLine();
                if (pathIn.equals("exit")) break;
                System.out.print("Куда копировать: ");
                pathOut = scanner.nextLine();
                if (pathOut.equals("exit")) break;
                FileUtils.copyFolder(pathIn, pathOut);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
