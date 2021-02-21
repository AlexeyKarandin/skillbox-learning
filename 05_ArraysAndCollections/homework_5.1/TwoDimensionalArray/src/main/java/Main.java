public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] mass = TwoDimensionalArray.getTwoDimensionalArray(10);
        for (char[] chars : mass) {
            for (int j = 0; j < mass.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.print(System.lineSeparator());
        }
    }
}
