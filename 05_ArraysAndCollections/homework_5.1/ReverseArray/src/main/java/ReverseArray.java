public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse(String[] strings) {

        String temp;
        for (int i = 0; i <= strings.length / 2; ++i) {
            temp = strings[strings.length - 1 - i];
            strings[strings.length - 1 - i] = strings[i];
            strings[i] = temp;
        }

        return strings;

    }
}
