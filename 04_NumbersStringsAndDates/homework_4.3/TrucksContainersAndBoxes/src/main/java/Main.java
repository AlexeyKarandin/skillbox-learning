import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boxes = Integer.parseInt(scanner.nextLine());
        final String LS = System.lineSeparator();
        final int MAX_IN_CARGO = 12;
        final int MAX_IN_CONTAINER = 27;
        int counterContainer = 1;
        int counterCargo = 1;
        int sourceContainer = boxes % MAX_IN_CONTAINER == 0 ? boxes / MAX_IN_CONTAINER : (boxes / MAX_IN_CONTAINER) + 1;
        int sourceCargo = sourceContainer % MAX_IN_CARGO == 0 ? sourceContainer / MAX_IN_CARGO : (sourceContainer / MAX_IN_CARGO) + 1;
        for (int i = 1; i <= sourceCargo; i++) {
            System.out.println("Грузовик: " + i);
            for (int j = 1; j <= MAX_IN_CARGO && counterCargo <= sourceContainer; j++, counterCargo++) {
                System.out.println("\tКонтейнер: " + counterCargo);
                for (int k = 1; k <= MAX_IN_CONTAINER && counterContainer <= boxes; k++, counterContainer++) {
                    System.out.println("\t\tЯщик: " + counterContainer);
                }
            }

        }
        System.out.printf("Необходимо:" + LS + "грузовиков - %d шт." + LS + "контейнеров - %d шт.", sourceCargo, sourceContainer);

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
