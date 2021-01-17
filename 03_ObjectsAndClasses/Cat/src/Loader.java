/**
 * Не совсем верно отрабатывает getCount т.к. циклы завязаны на вызове getStatus
 */
public class Loader {
    public static void main(String[] args) {
        Cat murca = new Cat();
        murca.setName("murca");
        Cat kitty = getKitten();
        System.out.println("Вес котенка: " + kitty.getWeight());

        Cat clonMurca = murca.copyCat(murca);
        System.out.println("============================================");
        System.out.println("Weight: " + clonMurca.getWeight());
        System.out.println("Name: " + clonMurca.getName());
        System.out.println("Color: " + clonMurca.getColor());
        System.out.println("============================================");
        System.out.println("Weight: " + clonMurca.getWeight());
        System.out.println("Name: " + clonMurca.getName());
        System.out.println("Color: " + clonMurca.getColor());
    }
    private static Cat getKitten() {
        return new Cat(1100.0);
    }

}
