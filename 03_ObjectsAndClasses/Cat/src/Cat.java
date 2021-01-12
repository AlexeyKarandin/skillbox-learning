
public class Cat {
    private final double originWeight;
    private double weight;

    private final double MIN_WEIGHT;
    private final double MAX_WEIGHT;
    private double feedCounter = .0;
    private boolean isAlive;
    private static int count;
    private static final int EYE = 2; // Предпологаю глаза нужны будут позже, при создании конструкторов

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        MIN_WEIGHT = 1000.0;
        MAX_WEIGHT = 9000.0;
        count++;
        isAlive = true;
    }

    public boolean isWeightNormal() {
        return (weight > MIN_WEIGHT && weight < MAX_WEIGHT);
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
        if (isWeightNormal()) {
            --weight;
            System.out.println("Ппссссс....");
            if (!isWeightNormal()) {
                getStatus();
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void meow() {
        if (isWeightNormal()) {
            --weight;
            System.out.println("Ппссссс....");
            if (!isWeightNormal()) {
                getStatus();
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void feed(Double amount) {
        if (isWeightNormal()) {
            weight += amount;
            System.out.println("Ппссссс....");
            if (!isWeightNormal()) {
                getStatus();
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void drink(Double amount) {
        if (isWeightNormal()) {
            weight += amount;
            System.out.println("Ппссссс....");
            if (!isWeightNormal()) {
                getStatus();
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            if (isAlive) {
                count--;
                isAlive = false;
                System.out.println("Померла от обезвоживания");
            }
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            if (isAlive) {
                count--;
                isAlive = false;
                System.out.println("Померла от еды");
            }
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}