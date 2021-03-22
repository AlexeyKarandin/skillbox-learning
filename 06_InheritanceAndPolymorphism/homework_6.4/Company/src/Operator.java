public class Operator implements Employee {

    private final double percentSalary = 0.05;
    private double salary;


    public Operator(Company company, double salary) {
        this.salary = salary + (company.getIncome() * percentSalary);
    }

    @Override
    public double getMonthSalary() {
        return 0.0;
    }
}
