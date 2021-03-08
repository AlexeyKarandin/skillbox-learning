import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {


        List<String> list;
        list = CoolNumbers.generateCoolNumbers();
        System.out.printf("Поиск перебором: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.bruteForceSearchInList(list, list.get((int) (Math.random() * 2000000))) ? "найден" : "не найден", CoolNumbers.time);
        System.out.printf("Бинарный поиск: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.binarySearchInList(list, list.get((int) (Math.random() * 2000000))) ? "найден" : "не найден", CoolNumbers.time);
        System.out.printf("Поиск в HashSet: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.searchInHashSet(new HashSet<>(list), list.get((int) (Math.random() * 2000000))) ? "найден" : "не найден", CoolNumbers.time);
        System.out.printf("Поиск в TreeSet: М000ВВ01 %s, поиск занял %d\n",
                CoolNumbers.searchInTreeSet(new TreeSet<>(list), list.get((int) (Math.random() * 2000000))) ? "найден" : "не найден", CoolNumbers.time);
    }
}
