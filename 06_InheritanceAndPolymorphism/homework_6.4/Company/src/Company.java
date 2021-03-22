import java.util.*;


public class Company {
    private final double MAX_INCOME = 140000.0;
    private final double MIN_INCOME = 115000.0;
    private double income = Math.random() * (MAX_INCOME - MIN_INCOME) + MIN_INCOME;
    private List<Employee> employees = new ArrayList<>();

    public String getNameCompany() {
        return nameCompany;
    }

    private String nameCompany;

    public Company(String name) {
        nameCompany = name;
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
    public void fire(Employee e) {
        employees.remove(e);
    }

    public double getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (!employees.isEmpty()) {
            employees.sort((o1, o2) -> {
                if (o1.getMonthSalary() > o2.getMonthSalary()) return 1;
                if (o1.getMonthSalary() < o2.getMonthSalary()) return -1;
                return 0;
            });
            return new LinkedList<Employee>().subList(0, count);
        }
        return new LinkedList<>();
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (!employees.isEmpty()) {
            employees.sort((o1, o2) -> {
                if (o1.getMonthSalary() > o2.getMonthSalary()) return -1;
                if (o1.getMonthSalary() < o2.getMonthSalary()) return 1;
                return 0;
            });
            return new LinkedList<Employee>().subList(0, count);
        }
        return new LinkedList<>();
    }
}
