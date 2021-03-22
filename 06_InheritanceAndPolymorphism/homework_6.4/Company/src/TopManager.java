public class TopManager implements Employee {

    private final double percentSalary = 2.5;
    private final double incomeForPercent = 10_000_000.0;
    private double salary;

    public TopManager(Company company, double salary) {
        if (company.getIncome() > incomeForPercent)
            this.salary = salary + (company.getIncome() * percentSalary);
        else {
            this.salary = salary;
        }
    }


    @Override
    public double getMonthSalary() {
        return salary;
    }
}
