import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        final int MAX_BOXES = Integer.parseInt(boxes);
        final int MAX_CARGO = 12;
        final int MAX_CONTAINER = 27;

        int counterContainer = 1;
        int counterCargo = 1;
        for (int i = 1; i <= Integer.parseInt(boxes); counterCargo++) {
            System.out.println("Грузовик: " + counterCargo);
            for (counterContainer = 1; counterContainer <= MAX_CONTAINER; counterContainer++) {
                System.out.println("\tКонтейнер: " + counterContainer);

            }

        }

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t
        // System.out.println("\t\tЯщик: " + i);
        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
