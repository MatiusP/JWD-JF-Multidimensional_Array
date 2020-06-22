package by.epamtc.protsko.array.task04;

public class Task_05 {

    static double[][] matrixMultiplication(double[][] leftMatrix, double[][] rightMatrix) {
        double[][] resultMatrix = {{}, {}};

        if (leftMatrix[0].length == rightMatrix.length) {
            resultMatrix = new double[leftMatrix.length][rightMatrix[0].length];
            for (int i = 0; i < leftMatrix.length; i++) {
                for (int j = 0; j < rightMatrix[0].length; j++) {
                    for (int k = 0; k < rightMatrix.length; k++) {
                        resultMatrix[i][j] = resultMatrix[i][j] + leftMatrix[i][k] * rightMatrix[k][j];
                    }
                }
            }
            return resultMatrix;
        } else {
            System.out.println("The operation is not possible because the number of columns of the left matrix" +
                    "is not equal to the number of rows of the right matrix");
            return resultMatrix;
        }
    }

    public static void printResultMatrix(double[][] array) {
        for (double[] row : array) {
            for (double element : row) {
                System.out.printf("%10.2f ", element);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        double[][] leftMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        double[][] rightMatrix = {
                {1.25, 384.0},
                {2.41, 18.04},
                {38.21, 15.25},
        };

        printResultMatrix(matrixMultiplication(leftMatrix, rightMatrix));
    }
}


