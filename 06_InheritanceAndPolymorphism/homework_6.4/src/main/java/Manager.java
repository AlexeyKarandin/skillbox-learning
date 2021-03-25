public class Manager implements Employee {

    private final double salary;

    public Manager(Company company, double salary) {
        double percentSalary = 0.05;
        this.salary = salary + (company.getIncome() * percentSalary);
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
