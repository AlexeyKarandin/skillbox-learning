public class Main {
    public static void main(String[] args) {
        Company home = new Company();
        Company work = new Company();

        home.hire(new TopManager(home.getCompany(), 150_000));
        home.hire(new TopManager(home, 170_000));
        home.getLowestSalaryStaff(2).forEach(x -> System.out.println((int)x.getMonthSalary() + " руб."));

        work.hire(new TopManager(work, 150_000));
        work.hire(new Operator(170_000));
        work.hire(new Manager(work, 170_000));
        work.getTopSalaryStaff(3).forEach(x -> System.out.println( (int)x.getMonthSalary() + " руб."));

        work.fire();
        work.getTopSalaryStaff(2).forEach(x -> System.out.println( (int)x.getMonthSalary() + " руб."));

    }
}
