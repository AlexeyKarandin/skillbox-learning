import java.util.*;

public class CoolNumbers {

    public static StringBuilder builder = new StringBuilder();

    public static List<String> generateCoolNumbers() {
        List<String> list = new LinkedList<>();

        for (int i = 0; i < 2_000_010; i++)
            list.add(getNumber());
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String s : list) {
            if (s.equals(number)) return true;
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }


    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

    public static String getRand(int min, int max) {
        int i;
        i = (int) (Math.random() * max) + min;
        return i < 10 ? "0" + i : String.valueOf(i);
    }

    public static String getNumber() {
        final int maxR = 199;
        final int minR = 1;
        builder = new StringBuilder();
        final String LETTERS = "АВЕКМНОРСТУХ";
        builder.append(LETTERS.charAt((int) (Math.random() * (LETTERS.length() - 1))));
        builder.append((int) (Math.random() * 10));
        builder.append((int) (Math.random() * 10));
        builder.append((int) (Math.random() * 10));
        builder.append(LETTERS.charAt((int) (Math.random() * (LETTERS.length() - 1))));
        builder.append(LETTERS.charAt((int) (Math.random() * (LETTERS.length() - 1))));
        builder.append(getRand(minR, maxR));
        return builder.toString();
    }
}

