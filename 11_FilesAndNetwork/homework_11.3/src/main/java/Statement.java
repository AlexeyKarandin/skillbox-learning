public class Statement {
    private String description;
    private double income;
    private double expense;


    public Statement(String description, double income, double expense) {
        this.description = description;
        this.income = income;
        this.expense = expense;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    public String getDescription() {
        return description;
    }
}
