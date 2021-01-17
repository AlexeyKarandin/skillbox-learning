public class Cat {
    private static final int EYE = 2; // Предпологаю глаза нужны будут позже, при создании конструкторов
    private static int count;
    private final double originWeight;
    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private double weight;
    private final double feedCounter = .0;
    private boolean isAlive;
    private ColorsCat color;
    private String name;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
        isAlive = true;
        color = ColorsCat.GREEN;
    }

    public Cat(double weight, ColorsCat color, String name) {
        this.weight = weight;
        this.color = color;
        this.name = name;
        originWeight = weight;
        count++;
        isAlive = true;
    }

    public Cat(double weight) {
        this.weight = weight;
        originWeight = weight;
    }

    // вызываем конструктор с параметрами текучего объекта
    // и возвращаем ссылку на новый объект
    public Cat copyCat(Cat cat) {
        return new Cat(this.weight, this.color, this.name);
    }
    public ColorsCat getColor() {
        return color;
    }

    public void setColor(ColorsCat color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                if (isAlive) {
                    count--;
                    isAlive = false;
                    System.out.println("Померла от обезвоживания\nМинус кот");
                }
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void meow() {
        if (isWeightNormal()) {
            --weight;
            System.out.println("Ппссссс....");
            if (!isWeightNormal()) {
                if (isAlive) {
                    count--;
                    isAlive = false;
                    System.out.println("Померла от обезвоживания\nМинус кот");
                }
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void feed(Double amount) {
        if (isWeightNormal()) {
            weight += amount;
            System.out.println("Ппссссс....");
            if (!isWeightNormal()) {
                if (isAlive) {
                    count--;
                    isAlive = false;
                    System.out.println("Померла от еды\nМинус кот");
                }
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public void drink(Double amount) {
        if (isWeightNormal()) {
            weight += amount;
            System.out.println("Ппссссс....");
            if (!isWeightNormal()) {
                if (isAlive) {
                    count--;
                    isAlive = false;
                    System.out.println("Померла от воды\nМинус кот");
                }
            }
        } else
            System.out.println("Кошку пора закопать...");
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}