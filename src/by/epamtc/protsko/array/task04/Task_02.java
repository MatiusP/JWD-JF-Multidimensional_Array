package by.epamtc.protsko.array.task04;

public class Task_02 {


    public static int[][] getResultMatrix(int elementsCount) {
        int[][] resultMatrix = new int[elementsCount][elementsCount];

        for (int i = 0; i < resultMatrix.length; i++) {
            resultMatrix[i][i] = (i + 1) * (i + 2);
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
        printResultMatrix(getResultMatrix(2));
    }
}
