package by.epamtc.protsko.array.task04;

public class Task_04 {

    public static double[][] getResultMatrix(double[] array) {
        double[][] resultMatrix = new double[array.length][array.length];

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                resultMatrix[i][j] = Math.pow(array[j], (i + 1));
            }
        }
        return resultMatrix;
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

        printResultMatrix(getResultMatrix(array));
    }
}
