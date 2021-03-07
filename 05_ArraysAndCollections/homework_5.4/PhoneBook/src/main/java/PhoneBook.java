import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class PhoneBook {
    private final Map<String, String> phoneBook = new TreeMap<>();
    private final Set<String> phones = new TreeSet<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (checkPhone(phone) && checkName(name)) {
            if (phoneBook.containsKey(phone)) {
                phoneBook.replace(phone, name);
            } else phoneBook.put(phone, name);
            System.out.println("Контакт сохранен!\n");
        }

    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        phones.clear();
        String phone = "";
        if (phoneBook.containsValue(name)) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (entry.getValue().equals(name)) phone = entry.getKey();
            }
            phones.add(name + " - " + phone);
        }

        return phones;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        phones.clear();
        if (phoneBook.isEmpty()) {
            return new TreeSet<>();
        } else {
            for (String k :
                    phoneBook.keySet()) {
                phones.add(phoneBook.get(k) + " - " + k);
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
}