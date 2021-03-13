public abstract class Client {
    private double amount;

    public Client() {
        System.out.println("Новый клиент!");
    }
    // Добавил конструктор, что бы можно было создать объекты с суммой на счете
    public Client(double amount) {
        this.amount = amount;
        System.out.println("Новый клиент с балансом: " + this.getAmount());
    }


    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut >= 0) amount += amountToPut;
    }

    public void take(double amountToTake) {
        if (amount >= amountToTake) amount -= amountToTake;
    }

}
