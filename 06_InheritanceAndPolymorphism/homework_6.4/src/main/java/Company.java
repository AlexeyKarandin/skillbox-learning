import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Company {
    private final double MAX_INCOME = 140000.0;
    private final double MIN_INCOME = 115000.0;
    private double income = Math.random() * (MAX_INCOME - MIN_INCOME) + MIN_INCOME;
    private List<Employee> employees = new ArrayList<>();
    private String nameCompany;

    public String getNameCompany() {
        return nameCompany;
    }

    public Company(String name, double income) {
        nameCompany = name;
        this.income = income;
    }

    // Найм сотрудника
    public void hire(Employee e) {
        employees.add(e);
    }

    // Найм списка сотрудников
    public void hireAll(List<Employee> list) {
        employees.addAll(list);
    }

    // Увольнение сотрудника
    public void fire() {
        employees.remove(0);
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (!employees.isEmpty()) {
            employees.sort((o1, o2) -> {
                if (o1.getMonthSalary() > o2.getMonthSalary()) return -1;
                if (o1.getMonthSalary() < o2.getMonthSalary()) return 1;
                return 0;
            });
            return new LinkedList<Employee>(employees.subList(0, count));
        }
        return new LinkedList<>();
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (!employees.isEmpty()) {
            employees.sort((o1, o2) -> {
                if (o1.getMonthSalary() > o2.getMonthSalary()) return 1;
                if (o1.getMonthSalary() < o2.getMonthSalary()) return -1;
                return 0;
            });
            return new LinkedList<Employee>(employees.subList(0, count));
        }
        return new LinkedList<>();
    }
}
