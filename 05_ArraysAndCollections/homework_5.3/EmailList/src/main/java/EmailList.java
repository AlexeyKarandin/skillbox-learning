import org.apache.commons.collections.list.TreeList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class EmailList {

    private final Set<String> mailSet = new TreeSet<>();
    private final List<String> mailList = new TreeList();
    Pattern addMail = Pattern.compile("\\w+@\\w+\\.[A-z]{2,3}");

    public void add(String email) {
        // TODO: валидный формат email добавляется
        if (addMail.matcher(email).matches()) {
            mailSet.add(email.toLowerCase());
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        mailList.addAll(mailSet);
        return mailList;
    }
}
