package by.epamtc.protsko.multidimensionalarray.task04;

public class Task_04 {

    public static double[][] resultMatrix(double[] array) {
        double[][] matrix = new double[array.length][array.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.pow(array[j], (i + 1));
            }
        }
        return matrix;
    }

    public static void printResultMatrix(double[][] array) {
        for (double[] row : array) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    //----- check result -----
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4};

        printResultMatrix(resultMatrix(array));
    }
}
