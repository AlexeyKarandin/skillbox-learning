import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new TreeMap<>();
    private Set<String> phones;

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        phones = new TreeSet<>();
        if (checkPhone(phone) && checkName(name)) {
            if (phoneBook.containsKey(name)) {
                phones.addAll(phoneBook.get(name));
                phones.add(phone);
                phoneBook.put(name, phones);
            } else {
                searchPhoneAndDelete(phone);
                phones.add(phone);
                phoneBook.put(name, new TreeSet<>(phones));
            }
            System.out.println("Контакт сохранен!\n");
        }

    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        for (Map.Entry<String, Set<String>> entry: phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey() + " - " + phone;
            }
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        phones = new TreeSet<>();
        if (phoneBook.containsKey(name)) {
            for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
                if (entry.getKey().equals(name)) entry.getValue().forEach(o -> phones.add(name + " - " + o));
            }
        }

        return phones;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        phones = new TreeSet<>();
        if (phoneBook.isEmpty()) {
            return new TreeSet<>();
        } else {
            for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
                if (!entry.getValue().isEmpty() && entry.getValue().iterator().hasNext())
                    phones.add(String.format("%s - %s", entry.getKey(), entry.getValue().toString().replaceAll("[\\[\\]]", "")));
            }
            return phones;
        }

    }

    private boolean checkName(String input) {
        Pattern inputName = Pattern.compile("[A-я]+");
        return inputName.matcher(input).matches();
    }

    private boolean checkPhone(String input) {
        Pattern inputPhone = Pattern.compile("7\\d{10}");
        return inputPhone.matcher(input).matches();
    }

    private void searchPhoneAndDelete(String search) {
        phones.clear();
        for (Map.Entry<String, Set<String>> entry: phoneBook.entrySet()) {
            if (entry.getValue().contains(search)) {
                entry.getValue().removeIf(s -> s.equals(search));
            }
        }
    }
}