import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 24;
        int month = 12;
        int year = 1993;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        /**
         * 3 - 31.12.1991 - Пт Для вывода русского формата дня недели изменить Locale("ru","RU")
         */
        DateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy - E", new Locale("us", "RU"));
        Calendar calendar = new GregorianCalendar(year, --month, day);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; calendar.getTimeInMillis() <= System.currentTimeMillis();
             calendar.add(Calendar.YEAR, 1), ++i) {
            builder.append(i + dateFormat.format(calendar.getTime()) + "\r\n");
        }
        return builder.toString();
    }
}
