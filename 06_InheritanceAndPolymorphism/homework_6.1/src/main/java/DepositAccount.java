import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount {
    private Calendar lastIncome = new GregorianCalendar();

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = new GregorianCalendar();
        lastIncome.add(Calendar.MONTH, 1);
    }

    @Override
    public void take(double amountToTake) {
        if (Calendar.getInstance().after(lastIncome)) super.take(amountToTake);

    }
}
