public class Main {
    public static void main(String[] args) {
        final String path = "src/main/resources/movementList.csv";
        Movements movements = new Movements(path);
        System.out.printf("Сумма расходов: %.2f руб%n", movements.getExpenseSum());
        System.out.printf("Сумма доходов: %.2f руб%n%n", movements.getIncomeSum());

        movements.getExpenceOrganization();
    }
}
