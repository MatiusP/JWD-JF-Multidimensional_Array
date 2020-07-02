package by.epamtc.protsko.multidimensionalarray.task04;

public class Task_02 {


    public static int[][] resultMatrix(int elementsCount) {
        int[][] matrix = new int[elementsCount][elementsCount];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = (i + 1) * (i + 2);
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
        printResultMatrix(resultMatrix(2));
    }
}
