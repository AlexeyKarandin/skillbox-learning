public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        String digits = "";
        int sum = 0;
        boolean isDigest = false;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                isDigest = true;
                digits += text.charAt(i);
            } else {
                if (isDigest) {
                    sum += Integer.parseInt(digits);
                    isDigest = false;
                    digits = "";
                }
            }
        }
        System.out.println(sum);
    }

}