import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalValueException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format!\n Correct format: " +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        } else if (!components[2].matches("\\w+\\.?\\w+@\\w+\\.[A-z]{2,3}")) {
            throw new IllegalValueException("Не верно указан почтовый адрес.", components[2]);
        } else if (!components[3].matches("\\+7\\d{10}"))
            throw new IllegalArgumentException("Не верно указан номер телефона. Пример +79215637722");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (storage.remove(name) == null)
            throw new IllegalArgumentException("Customer not found or need more arguments");
    }

    public Customer getCustomer(String name) {
        if (storage.get(name) != null)
            return storage.get(name);
        else
            throw new IllegalArgumentException("Customer not found or need more arguments");

    }

    public int getCount() {
        return storage.size();
    }
}