public class IndividualBusinessman extends Client {
    private final double COMMISSION = 0.01;
    private final double BIG_AMOUNT_COMMISSION = 0.005;
    private final double AMOUNT_FOR_COMMISSION = 1000.0;

    public IndividualBusinessman() {
        super();
    }

    public IndividualBusinessman(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        if (amountToPut < AMOUNT_FOR_COMMISSION) {
            super.put(amountToPut - (amountToPut * COMMISSION));
        } else
            super.put(amountToPut - (amountToPut * BIG_AMOUNT_COMMISSION));
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake);
    }
}
