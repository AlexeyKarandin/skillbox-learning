import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        Pattern pattern1 = Pattern.compile("7(\\d{10})|$");
        Pattern pattern2 = Pattern.compile("8(\\d{10})|$");
        Pattern pattern3 = Pattern.compile("9(\\d{9})|$");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            input = input.trim();
            input = input.trim().replaceAll("\\D+", "");

            if (pattern1.matcher(input).matches()) {
                System.out.println(input);
            } else if (pattern2.matcher(input).matches()) {
                System.out.println(input.replaceFirst("8", "7"));
            } else if (pattern3.matcher(input).matches()) {
                System.out.println("7" + input);
            } else {
                System.out.println("Неверный формат номера\n");
            }
        }
    }

}
