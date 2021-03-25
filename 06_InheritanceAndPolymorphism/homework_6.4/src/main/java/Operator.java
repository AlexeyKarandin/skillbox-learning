public class Operator implements Employee {

    private final double salary;

    public Operator(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
