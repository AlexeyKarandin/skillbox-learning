
public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double feedCounter = .0;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    // подсчет съеденного для текущего экземпляра
    public double getFeedCounter() {
        return feedCounter;
    }

    // Метод для похода в туалет
    public void pee() {
        --weight;
        System.out.println("Ппссссс....");
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        weight = weight + amount;
        // производим подсчет съеденной еды
        feedCounter += amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}