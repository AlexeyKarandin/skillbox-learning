import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Company {
    private final double MAX_INCOME = 140000.0;
    private final double MIN_INCOME = 115000.0;
    private final double income = Math.random() * (MAX_INCOME - MIN_INCOME) + MIN_INCOME;
    private final List<Employee> employees = new ArrayList<>();

    public Company getCompany() {
        return this;
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

    /**
     * Метод List<Employee> getTopSalaryStaff(int count).
     * Создание коллекции [count] самых высоких зарплат компании.
     *
     * @param count количество самых высоких зарплат.
     * @return коллекция [count] самых высоких зарплат.
     */
    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(Comparator.comparingDouble(Employee::getMonthSalary).reversed());
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++)
            result.add(employees.get(i));
        return result;
    }

    /**
     * Метод List<Employee> getTopSalaryStaff(int count).
     * Создание коллекции [count] самых низких зарплат компании.
     *
     * @param count количество самых низких зарплат.
     * @return коллекция [count] самых низких зарплат.
     */
    public List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++)
            result.add(employees.get(i));
        return result;
    }
}
