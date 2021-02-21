import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);
        Pattern list = Pattern.compile("LIST");
        Pattern addEndList = Pattern.compile("ADD \\w.+");
        Pattern addPositionList = Pattern.compile("ADD [0-9]+ \\w.+");
        Pattern editList = Pattern.compile("EDIT [0-9]+ \\w.+");
        Pattern deleteList = Pattern.compile("DELETE [0-9]+");
        TodoList toList = new TodoList();
        StringBuilder builder = new StringBuilder();

        String enter;
        System.out.println("Введите действия со списком\n");

        while (true) {

            enter = scanner.nextLine();
            if (enter.equals("exit")) {
                break;
            }
            if (list.matcher(enter).matches()) {
                int i = 0;
                if (toList.getTodos().isEmpty()) {
                    System.out.println("Список пуст, нужно добавить");
                    continue;
                }
                for (var element : toList.getTodos()) {
                    System.out.printf("%d %s%n", i++, element);
                }
                System.out.println(builder.toString());

            } else if (addEndList.matcher(enter).matches()) {
                toList.add(enter.replaceAll("ADD", "").trim());
            } else if (addPositionList.matcher(enter).matches()) {
                int index = Integer.parseInt(enter.replaceAll("\\D+", ""));
                String todo = enter.replaceFirst("ADD [0-9]+ ", "");
                toList.add(index, todo);
            } else if (editList.matcher(enter).matches()) {
                int index = Integer.parseInt(enter.replaceAll("\\D+", ""));
                String todo = enter.replaceFirst("EDIT [0-9]+ ", "");
                toList.edit(todo, index);
            } else if (deleteList.matcher(enter).matches()) {
                int index = Integer.parseInt(enter.replaceAll("\\D+", ""));
                toList.delete(index);
            }

        }

    }
}
