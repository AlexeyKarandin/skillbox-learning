import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook book = new PhoneBook();
        String input;
        String nextInput;

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            input = scanner.nextLine();
            switch (Main.checkInput(input)) {
                case 0:
                    System.out.println("Неверный формат ввода");
                    break;
                case 1:
                    book.getAllContacts().forEach(System.out::println);
                    break;
                case 2:
                    if (book.getPhonesByName(input).isEmpty()) {
                        System.out.println("Такого имени в телефонной книге нет.");
                        do {
                            System.out.printf("Введите номер телефона для абонента \"%s\".\n", input);
                            nextInput = scanner.nextLine();
                        } while (!(Pattern.matches("7\\d{10}", nextInput.trim())));
                        book.addContact(nextInput, input);
                    } else book.getPhonesByName(input).forEach(System.out::println);
                    break;
                case 3:
                    if (book.getNameByPhone(input).isEmpty()) {
                        System.out.println("Такого номера в телефонной книге нет.");
                        do {
                            System.out.printf("Введите имя для номера \"%s\".\n", input);
                            nextInput = scanner.nextLine();
                        } while (!(Pattern.matches("[A-я]+", nextInput.trim())));
                        book.addContact(input, nextInput);
                    } else
                        System.out.println(book.getNameByPhone(input));
                    break;
            }
        }
    }

    static int checkInput(String input) {
        Pattern inputPhone = Pattern.compile("7\\d{10}");
        Pattern inputName = Pattern.compile("[A-я]+");
        final String inputList = "LIST";
        if (input.equals(inputList)) {
            return 1;
        } else if (inputName.matcher(input).matches()) {
            return 2;
        } else if (inputPhone.matcher(input).matches()) {
            return 3;
        } else
            return 0;

    }
}
