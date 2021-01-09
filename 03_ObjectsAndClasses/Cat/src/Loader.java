
public class Loader {
    public static void main(String[] args) {
        Cat murca = new Cat();
        Cat barsic = new Cat();
        int counter = 0;
        while (!murca.getStatus().equals("Dead")) {
            if (!murca.getStatus().equals("Dead"))
                murca.meow();
            if (murca.getStatus().equals("Dead")) {
                System.out.println("Померла Мурка...");
                System.out.println("Мяукнула мурка: " + counter + " раз");
            }
            counter++;
            continue;
        }
        // пытался понять почему барсик взрывается сразу, потом понял, что мне не выводится, что он выпил. Решил создать счетчик выпитого
        counter = 0;

        while (!(barsic.getStatus() == ("Exploded"))) {
            barsic.drink(1.0);

            if (barsic.getStatus().equals("Exploded")) {
                System.out.println("Взорвался барсик...");
                System.out.println("Барсик выпил: " + counter + " литров...");
                if (counter > 7_000) {
                    System.out.println("Проглот");
                }
            }
            counter++;
            continue;
        }

    }
}
