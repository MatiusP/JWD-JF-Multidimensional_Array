package by.epamtc.protsko.multidimensionalarray.task04;

public class Task_01 {

    public static int[][] resultMatrix(int elementsCount) {
        int[][] matrix = new int[elementsCount][elementsCount];

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = matrix.length - j;
                }
            }
        }
        return matrix;
    }

    public static void printResultMatrix(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    //----- check result -----
    public static void main(String[] args) {
        printResultMatrix(resultMatrix(10));
        printResultMatrix(resultMatrix(7));
    }
}
