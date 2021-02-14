import java.sql.SQLOutput;
import java.util.Scanner;

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
            boolean isValid = true;
            int spaceCount = 0;
            for (int i = 0; i < input.length(); i++) {
                if (!(Character.isLetter(input.charAt(i)))) {
                    if (input.charAt(i) == '-')
                        continue;
                    else if (input.charAt(i) == ' ') {
                        spaceCount++;
                        isValid = spaceCount <= 2 ? true : false;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            // Изменил условие для проверки валидности введенной строки
            if (!isValid || spaceCount != 2) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }
            String surname = "";
            String name = "";
            String patronymic = "";
            surname = input.substring(0, input.indexOf(" "));
            name = input.substring((1 + input.indexOf(" ")), (input.lastIndexOf(" ")));
            patronymic = input.substring(input.lastIndexOf(" ") + 1);
            System.out.printf("Фамилия: %s\nИмя: %s\nОтчество: %s", surname, name, patronymic);
        }
    }
}