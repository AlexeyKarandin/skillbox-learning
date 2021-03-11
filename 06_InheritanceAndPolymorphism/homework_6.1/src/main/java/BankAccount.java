public class BankAccount {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut >= 0) amount += amountToPut;
    }

    public void take(double amountToTake) {
        if (amount >= amountToTake) amount -= amountToTake;

    }

    boolean send(BankAccount receiver, double amount) {
        double thisAmount = this.getAmount();
        this.take(amount);
        if (thisAmount - amount == this.getAmount()) {
            thisAmount = receiver.getAmount();
            receiver.put(amount);
            return receiver.getAmount() == thisAmount + amount;
        } else
            this.put(amount);
        return false;

    }
}
