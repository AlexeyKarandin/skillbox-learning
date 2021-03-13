public class LegalPerson extends Client {
    private final double COMMISSION = 0.01;

    public LegalPerson() {
        super();
    }

    public LegalPerson(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + (amountToTake * COMMISSION));
    }
}
