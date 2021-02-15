
public class Main {

    public static void main(String[] args) {
        calculateSalarySum("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей");
    }

    public static int calculateSalarySum(String text) {
        //TODO: реализуйте метод
        int sum = 0;

        String[] digestArr = text.trim().split("[^0-9]");
        for (String s : digestArr) {
            if (s.isEmpty())
                continue;
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}