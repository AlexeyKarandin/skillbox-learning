public class CardAccount extends BankAccount {
    private final double COMMISSION = 0.01;

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + (amountToTake * COMMISSION));
    }
}
