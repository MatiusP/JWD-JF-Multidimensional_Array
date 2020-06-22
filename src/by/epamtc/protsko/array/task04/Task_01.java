package by.epamtc.protsko.array.task04;

public class Task_01 {

    public static int[][] getResultMatrix(int elementsCount) {
        int[][] resultMatrix = new int[elementsCount][elementsCount];

        for (int i = 0; i < resultMatrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] = resultMatrix.length - j;
                }
            }
        }
        return resultMatrix;
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
        printResultMatrix(getResultMatrix(10));
        printResultMatrix(getResultMatrix(7));
    }
}
