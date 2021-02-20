public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] theXX = new char[size][size];
        size--;
        for (int i = 0; i < theXX.length; i++, size--) {
            for (int j = 0; j < theXX.length; j++) {
                if (i == j || j == size) {
                    theXX[i][j] = symbol;
                } else {
                    theXX[i][j] = ' ';
                }
            }
        }
        return theXX;
    }
}
