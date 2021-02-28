import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static void main(String[] args) {
        EmailList emailList = new EmailList();
        Scanner scanner = new Scanner(System.in);
        final String enterList = "LIST";
        Pattern addMail = Pattern.compile("ADD .+");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            } else if (input.trim().equals(enterList)) {
                for (String str :
                        emailList.getSortedEmails()) {
                    System.out.println(str);
                }
            } else if (addMail.matcher(input).matches()) {
                emailList.add(input.replaceAll("ADD ", ""));
            } else {
                System.out.println(WRONG_EMAIL_ANSWER);
            }

        }

    }
}
