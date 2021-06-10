import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("connection.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String url = "jdbc:mysql://localhost:3306/skillbox";
//        String user = "root";
//        String pass = "123456";

        try (Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pass"))) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select p.course_name, count(p.subscription_date) / month(max(p.subscription_date)) as avg from purchaselist p group by p.course_name order by p.subscription_date");
            while (rs.next()) {
                System.out.printf("%s - %s%n", rs.getString(1), rs.getString("avg"));
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
