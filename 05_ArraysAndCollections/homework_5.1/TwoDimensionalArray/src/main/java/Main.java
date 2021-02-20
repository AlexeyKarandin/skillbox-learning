public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] mass = TwoDimensionalArray.getTwoDimensionalArray(10);
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                System.out.print(mass[i][j]);
            }
            System.out.print(System.lineSeparator());;
        }
    }
}
