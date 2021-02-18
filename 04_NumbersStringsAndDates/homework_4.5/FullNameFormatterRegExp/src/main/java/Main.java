import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            input = input.trim();
            Pattern pattern = Pattern.compile("[А-Я][а-я]+(-?[А-Я][а-я]+?)? [А-Я][а-я]+(-?[А-Я][а-я]+?)? [А-Я][А-я]+( [А-Я][А-я]+)?");
            if (pattern.matcher(input).matches()) {
                String[] fio = input.split("\\s");
                if (fio.length == 4) {
                    System.out.printf("Фамилия: %s%nИмя: %s%nОтчество: %s %s", fio[0], fio[1], fio[2], fio[3]);
                } else
                    System.out.printf("Фамилия: %s%nИмя: %s%nОтчество: %s", fio[0], fio[1], fio[2]);
            } else {
                System.out.println("Введенная строка не является ФИО");
            }

        }
    }

}