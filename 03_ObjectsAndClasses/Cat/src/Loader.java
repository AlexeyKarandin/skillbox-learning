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
            if (!murca.getStatus().equals("Dead"))
                murca.meow();
            if (murca.getStatus().equals("Dead")) {
                System.out.println("Померла Мурка...");
                System.out.println("Мяукнула мурка: " + counter + " раз");
            }
            counter++;
        }
        // пытался понять почему барсик взрывается сразу, потом понял, что мне не выводится, что он выпил. Решил создать счетчик выпитого
        counter = 0;
        System.out.println(murca.getCount());
        while (!(barsic.getStatus().equals("Exploded"))) {
            barsic.drink(1.0);
            barsic.feed(2.0);
            if (barsic.getStatus().equals("Exploded")) {
                System.out.println("Взорвался барсик...");
                // добавил, что бы выдало, что пора закапывать
                barsic.drink(1.0);
                System.out.println("Барсик выпил: " + counter + " литров...");
                System.out.println("И съел: " + barsic.getFeedCounter());
            }
            counter++;
        }
        System.out.println(murca.getCount());
    }
}
