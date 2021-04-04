import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        Calendar calendar = Calendar.getInstance();
        Optional<Employee> employee = staff.stream()
                .filter(x -> {
                    calendar.setTime(x.getWorkStart());
                    return calendar.get(Calendar.YEAR) == year;
                })
                .max(Comparator.comparing(Employee::getSalary));
        return employee.orElse(null);
    }
}