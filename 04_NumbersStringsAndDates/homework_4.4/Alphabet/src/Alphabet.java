public class Alphabet {
    public static void main(String[] args) {
        int first = 'A';
        int last = 'z';

        for (; first <= last; ++first) {
            if (Character.isLetter(first))
                System.out.print((char) first + " ");
        }
    }
}
