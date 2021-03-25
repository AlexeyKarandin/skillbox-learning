public class TopManager implements Employee {

    private final double salary;

    public TopManager(Company company, double salary) {
        double percentSalary = 2.5;
        double incomeForPercent = 10_000_000.0;
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
