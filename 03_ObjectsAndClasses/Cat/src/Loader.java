
public class Loader {
    public static void main(String[] args) {
        Cat murca = new Cat();
        Cat barsic = new Cat();
        int counter = 0;
        barsic.pee();
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

        while (!(barsic.getStatus().equals("Exploded"))) {
            barsic.drink(1.0);
            barsic.feed(2.0);
            if (barsic.getStatus().equals("Exploded")) {
                System.out.println("Взорвался барсик...");
                System.out.println("Барсик выпил: " + counter + " литров...");
                System.out.println("И съел: " + barsic.getFeedCounter());
            }
            counter++;
        }

    }
}
