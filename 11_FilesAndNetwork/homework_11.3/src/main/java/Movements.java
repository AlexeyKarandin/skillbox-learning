import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {
    private String accType;
    private String accNumber;
    private String curr;
    private String date;
    private String reference;
    private String description;
    private double income;
    private double expense;
    private final List<Movements> movements = new ArrayList<>();
    private Map<String, Double> organization = new HashMap<>();
    Pattern pattern = Pattern.compile("((\\d{6}.+\\d{4}) {4,6}(\\S+ ?\\w+) {5,}.* MCC(\\d{4}))");
    Matcher m;

    public Movements(String pathMovementsCsv) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathMovementsCsv));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            csvParser.getRecords().stream().skip(1).forEach(str -> {
                movements.add(new Movements(str.get(0), str.get(1), str.get(2), str.get(3),
                        str.get(4), str.get(5),
                        Double.parseDouble(str.get(6).replaceAll(",", ".")),
                        Double.parseDouble(str.get(7).replaceAll(",", "."))));

            });
        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private Movements(String accType, String accNumber, String curr, String date, String reference, String description, double income, double expense) {
        this.accType = accType;
        this.accNumber = accNumber;
        this.curr = curr;
        this.date = date;
        this.reference = reference;
        this.description = description;
        this.income = income;
        this.expense = expense;
    }


    public double getExpenseSum() {
        return movements.stream().mapToDouble(Movements::getExpense).sum();
    }

    public double getIncomeSum() {
        return movements.stream().mapToDouble(Movements::getIncome).sum();
    }

    public void getExpenceOrganization() {

        movements.stream().filter(m -> m.getExpense() != 0).forEach(movements1 -> {
            m = pattern.matcher(movements1.getDescription());
            System.out.println(pattern.matcher(movements1.getDescription()).group());
            if (organization.containsKey(m.group(1))) {
                organization.put(m.group(1), organization.get(m.group(1)) + movements1.getExpense());
            } else {
                organization.put(m.group(1), movements1.getExpense());
            }
        });
        System.out.println("Суммы расходов по организациям:");
        organization.entrySet().forEach(System.out::println);
    }

    public String getAccType() {
        return accType;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getCurr() {
        return curr;
    }

    public String getDate() {
        return date;
    }

    public String getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    @Override
    public String toString() {
        return "Movements{" +
                "accType='" + accType + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", curr='" + curr + '\'' +
                ", date='" + date + '\'' +
                ", reference='" + reference + '\'' +
                ", description='" + description + '\'' +
                ", income=" + income +
                ", expense=" + expense +
                ", movements=" + movements +
                '}';
    }
}
