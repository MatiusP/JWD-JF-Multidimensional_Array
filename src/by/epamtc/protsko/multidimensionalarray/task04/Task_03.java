package by.epamtc.protsko.multidimensionalarray.task04;

public class Task_03 {

    public static int[][] resultMatrix(int elementsCount) {
        int[][] matrix = new int[elementsCount][elementsCount];

        for (int i = 0; i < matrix.length; i++) {
            if (i <= (elementsCount / 2) && (i != (matrix.length - i))) {
                for (int j = i; j < (matrix[i].length - i); j++) {
                    matrix[i][j] = 1;
                }
            } else {
                System.arraycopy(matrix[elementsCount - (i + 1)], 0,
                        matrix[i], 0, matrix[i].length);
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
        printResultMatrix(resultMatrix(16));
        printResultMatrix(resultMatrix(15));
    }
}
