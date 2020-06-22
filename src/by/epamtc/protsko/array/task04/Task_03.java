package by.epamtc.protsko.array.task04;

public class Task_03 {

    public static int[][] getResultMatrix(int elementsCount) {
        int[][] resultMatrix = new int[elementsCount][elementsCount];

        for (int i = 0; i < resultMatrix.length; i++) {
            if (i <= (elementsCount / 2) && (i != (resultMatrix.length - i))) {
                for (int j = i; j < (resultMatrix[i].length - i); j++) {
                    resultMatrix[i][j] = 1;
                }
            } else {
                System.arraycopy(resultMatrix[elementsCount - (i + 1)], 0,
                        resultMatrix[i], 0, resultMatrix[i].length);
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
        printResultMatrix(getResultMatrix(16));
        printResultMatrix(getResultMatrix(15));
    }
}
