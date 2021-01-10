
public class Cat {
    private final double originWeight;
    private double weight;

    private final double minWeight;
    private final double maxWeight;
    private double feedCounter = .0;
    private static int count;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;

    }

    // метод возвращаемый кол-во живых кошек, т.к. переменная count приватная,
    // то получить данную переменную можно только через данный метод
    public int getCount() {
        return count;
    }
    // подсчет съеденного для текущего экземпляра
    public double getFeedCounter() {
        return feedCounter;
    }

    // Метод для похода в туалет
    public void pee() {
        if (weight > minWeight) {
            --weight;
            System.out.println("Ппссссс....");
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void meow() {
        if (weight > minWeight) {
            --weight;
            System.out.println("Meow");
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void feed(Double amount) {
        if (weight < maxWeight) {
            weight += amount;
            // производим подсчет съеденной еды
            feedCounter += amount;
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void drink(Double amount) {
        if (weight < maxWeight) {
            weight += amount;
            // производим подсчет съеденной еды
            feedCounter += amount;
        } else
            System.out.println("Кошку пора закопать...");
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            count--;
            return "Dead";
        } else if (weight > maxWeight) {
            count--;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}