import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        List<String> list = CoolNumbers.generateCoolNumbers();
        String number = list.get((int) (Math.random() * 2000000));
        long time = System.nanoTime();
        System.out.printf("Поиск перебором: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.bruteForceSearchInList(list, number) ? "найден" : "не найден", System.nanoTime() - time);

        time = System.nanoTime();
        System.out.printf("Поиск в HashSet: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.searchInHashSet(new HashSet<>(list), number) ? "найден" : "не найден", System.nanoTime() - time);

        time = System.nanoTime();
        System.out.printf("Поиск в TreeSet: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.searchInTreeSet(new TreeSet<>(list), number) ? "найден" : "не найден", System.nanoTime() - time);

        Collections.sort(list);
        time = System.nanoTime();
        System.out.printf("Бинарный поиск: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.binarySearchInList(list, number) ? "найден" : "не найден", System.nanoTime() - time);
    }
}
