public class Manager implements Employee {

    private String name;
    private final double percentSalary = 0.05;
    private double salary;

    public Manager(Company company, double salary) {
        this.salary = salary + (company.getIncome() * percentSalary);
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
