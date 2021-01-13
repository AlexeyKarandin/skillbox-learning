/**
 * Не совсем верно отрабатывает getCount т.к. циклы завязаны на вызове getStatus
 */
public class Loader {
    public static void main(String[] args) {
        Cat murca = new Cat();
        Cat barsic = new Cat();
        int counter = 0;
        barsic.pee();
        System.out.println(murca.getCount());
        while (!murca.getStatus().equals("Dead")) {
            murca.pee();
        }
        //murca.feed(100.0); // проверяем, что мертвый кот не кормится
        System.out.println(murca.getStatus());
        System.out.println(murca.getCount());

    }
}
