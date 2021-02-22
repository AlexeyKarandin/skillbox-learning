import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        list.add(todo);
        System.out.printf("Добавлено дело \"%s\"%n", todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указанный индекс,
        //  проверьте возможность добавления
        if (index < list.size()) {
            list.add(index, todo);
            System.out.printf("Добавлено дело \"%s\"%n", todo);
        } else {
            list.add(todo);
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index < list.size()) {
            System.out.printf("Дело \"%s\" заменено \"%s\"", list.get(index), todo);
            list.set(index, todo);

        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < list.size()) {
            String deleteTodo = list.remove(index);
            System.out.printf("Было удалена строка: %d %s%n", index, deleteTodo);
        } else {
            System.out.println("Дела с таким индексом не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }

}