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
    private final List<Statement> statements = new ArrayList<>();
    private final Map<String, Double> organizationSum = new HashMap<>();
    private final Map<String, String> organization = new HashMap<>();
    Pattern pattern = Pattern.compile(" {4,6}(.+>?\\w) {10,22}.+(MCC\\d+)");
    Matcher m;

    public Movements(String pathMovementsCsv) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(pathMovementsCsv));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            csvParser.getRecords().stream().skip(1).forEach(str -> statements.add(new Statement(str.get(5),
                    Double.parseDouble(str.get(6).replaceAll(",", ".")),
                    Double.parseDouble(str.get(7).replaceAll(",", ".")))));
        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void getExpenceOrganization() {
        statements.stream().filter(m -> m.getExpense() != 0).forEach(movements1 -> {
            m = pattern.matcher(movements1.getDescription());
            m.find();
            organization.put(m.group(2), m.group(1));
            if (organizationSum.containsKey(m.group(2))) {
                organizationSum.put(m.group(2), organizationSum.get(m.group(2)) + movements1.getExpense());
            } else {
                organizationSum.put(m.group(2), movements1.getExpense());
            }
        });
        System.out.println("Суммы расходов по организациям:");
        organizationSum.forEach((key, value) -> System.out.printf("%s\t\t%.2f руб.%s", organization.get(key),
                value, System.lineSeparator()));
    }

    public double getExpenseSum() {
        return statements.stream().mapToDouble(Statement::getExpense).sum();
    }

    public double getIncomeSum() {
        return statements.stream().mapToDouble(Statement::getIncome).sum();
    }

}
