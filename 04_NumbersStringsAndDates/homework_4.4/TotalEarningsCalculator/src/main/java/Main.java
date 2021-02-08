public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        String digits = "";
        Integer first = null;
        Integer second = null;
        int sum = 0;
        boolean isDigest = false;
        for (int i = 0; i < text.length(); i++) {
            isDigest =  Character.isDigit(text.charAt(i));
            if (isDigest && first == null && second == null) {
                first = i;
            } else if (isDigest) {
                second = i;
            } else if (!isDigest && second != null && first != null) {
                sum += Integer.parseInt(text.substring(first, ++second));
                second = first = null;
            }

        }

        System.out.println(sum);
    }

}