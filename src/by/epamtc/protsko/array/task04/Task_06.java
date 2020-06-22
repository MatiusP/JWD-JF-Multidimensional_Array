package by.epamtc.protsko.array.task04;

import java.util.ArrayList;
import java.util.List;

public class Task_06 {
    private static List<Integer> diagonalElements = new ArrayList<>();

    //ПОСТРОЕНИЕ НЕЧЁТНОГО МАГИЧЕСКОГО КВАДРАТА
    private static int[][] getOddMagicSquare(int squareBase) {
        int[][] oddMagicSquare = new int[squareBase][squareBase];
        int currentNumber = 1;
        int indexRow = 0;
        int indexColumn = oddMagicSquare.length / 2;
        oddMagicSquare[indexRow][indexColumn] = currentNumber;

        while (currentNumber < Math.pow(squareBase, 2)) {

            if (indexRow == 0) {
                if (indexColumn < (oddMagicSquare[indexRow].length - 1)) {
                    indexRow = oddMagicSquare.length - 1;
                    indexColumn++;
                } else {
                    indexRow++;
                }
            } else {
                if (indexColumn == (oddMagicSquare[indexRow].length - 1)) {
                    indexRow--;
                    indexColumn = 0;
                } else {
                    indexRow--;
                    indexColumn++;
                }
            }
            if (oddMagicSquare[indexRow][indexColumn] == 0) {
                oddMagicSquare[indexRow][indexColumn] = ++currentNumber;
            } else {
                indexRow += 2;
                indexColumn--;
                oddMagicSquare[indexRow][indexColumn] = ++currentNumber;
            }
        }
        return oddMagicSquare;
    }

    //ПОСТРОЕНИЕ ЧЁТНО-ЧЁТНОГО МАГИЧЕСКОГО КВАДРАТА

    /*
    Инициализация матрицы порядка squareBase числами, в порядке
    естестрвенного возрастания
    */
    private static int[][] getInitialFillingOfSquare(int squareBase) {
        int currentNumber = 0;
        int[][] initialFillingOfSquare = new int[squareBase][squareBase];

        for (int i = 0; i < initialFillingOfSquare.length; i++) {
            for (int j = 0; j < initialFillingOfSquare[i].length; j++) {
                initialFillingOfSquare[i][j] = ++currentNumber;
            }
        }
        return initialFillingOfSquare;
    }

    /*
    Поиск координат диагональных элементов в исходной матрице,
    а также во всех вписанных матрицах порядка 4х4 (координаты диагональных
    элементов по краям матриц)
    */
    private static int[] getCoordinatesOfEdgesOfSquare(int squareBase) {
        int[] coordinatesOfEdgesOfSquare = new int[squareBase / 2];
        coordinatesOfEdgesOfSquare[0] = 1;

        for (int i = 1; i < coordinatesOfEdgesOfSquare.length; i++) {
            if (i % 2 == 0) {
                coordinatesOfEdgesOfSquare[i] = coordinatesOfEdgesOfSquare[i - 1] + 1;
            } else {
                coordinatesOfEdgesOfSquare[i] = coordinatesOfEdgesOfSquare[i - 1] + 3;
            }
        }
        return coordinatesOfEdgesOfSquare;
    }

    /*
    Поиск координат диагональных элементов в исходной матрице,
    а также во всех вписанных матрицах порядка 4х4 (координаты диагональных
    элементов в середине матриц)
    */
    private static int[] getCoordinatesOfMiddleOfSquare(int squareBase) {
        int[] coordinatesOfMiddleOfSquare = new int[squareBase / 2];
        coordinatesOfMiddleOfSquare[0] = 2;

        for (int i = 1; i < coordinatesOfMiddleOfSquare.length; i++) {
            if (i % 2 == 0) {
                coordinatesOfMiddleOfSquare[i] = coordinatesOfMiddleOfSquare[i - 1] + 3;
            } else {
                coordinatesOfMiddleOfSquare[i] = coordinatesOfMiddleOfSquare[i - 1] + 1;
            }
        }
        return coordinatesOfMiddleOfSquare;
    }

    /*
    Удаление из исходной матрицы, инициализированной значениями в порядке естественного
    возрастания, значений, расположенных по диагоналям (в том числе и по диагоналям квадратов 4х4)
     */
    private static int[][] getInitialSquareWithoutDiagonalElements(int squareBase) {
        int[][] initialSquareWithoutDiagonalElements = getInitialFillingOfSquare(squareBase);
        int stepCounter = 1;
        int[] coordinatesOfEdgesOfSquare = getCoordinatesOfEdgesOfSquare(squareBase);
        int[] coordinatesOfMiddleOfSquare = getCoordinatesOfMiddleOfSquare(squareBase);

        for (int i = 0; i < initialSquareWithoutDiagonalElements.length; i++) {
            if ((stepCounter == 1) || (stepCounter == 4)) {
                for (int value : coordinatesOfEdgesOfSquare) {
                    diagonalElements.add(initialSquareWithoutDiagonalElements[i][value - 1]);
                    initialSquareWithoutDiagonalElements[i][value - 1] = 0;
                }
            } else {
                for (int value : coordinatesOfMiddleOfSquare) {
                    diagonalElements.add(initialSquareWithoutDiagonalElements[i][value - 1]);
                    initialSquareWithoutDiagonalElements[i][value - 1] = 0;
                }
            }
            stepCounter++;
            if (stepCounter > 4) stepCounter = 1;
        }
        return initialSquareWithoutDiagonalElements;
    }

    /*
    Построение результирующего магического квадрата чётно-чётного подрядка
     */
    private static int[][] getEvenEvenMagicSquare(int squareBase) {
        int[][] evenEvenMagicSquare = getInitialSquareWithoutDiagonalElements(squareBase);
        int diagonalElementsCounter = 0;

        for (int row = evenEvenMagicSquare.length - 1; row >= 0; row--) {
            for (int column = evenEvenMagicSquare[row].length - 1; column >= 0; column--) {
                if (evenEvenMagicSquare[row][column] == 0) {
                    evenEvenMagicSquare[row][column] = diagonalElements.get(diagonalElementsCounter);
                    diagonalElementsCounter++;
                }
            }
        }
        return evenEvenMagicSquare;
    }

    //ПОСТРОЕНИЕ ЧЁТНО-НЕЧЁТНОГО МАГИЧЕСКОГО КВАДРАТА

    /*
    Построение промежуточного магического квадрата порядка squareBase
    */
    private static int[][] getFirstIntermediateMagicSquare(int squareBase) {
        int[][] intermediateMagicSquare = new int[squareBase][squareBase];
        int midSquare = squareBase / 2;
        int[][] firstMagicSquare = getOddMagicSquare(midSquare);

        for (int row = 0; row < intermediateMagicSquare.length; row++) {
            for (int column = 0; column < intermediateMagicSquare[row].length; column++) {
                if (row < midSquare) {
                    if (column < midSquare) {
                        intermediateMagicSquare[row][column] = firstMagicSquare[row][column];
                    } else {
                        intermediateMagicSquare[row][column] = firstMagicSquare[row][column - midSquare]
                                + (int) Math.pow(midSquare, 2) * 2;
                    }
                } else {
                    if (column < midSquare) {
                        intermediateMagicSquare[row][column] = firstMagicSquare[row - midSquare][column]
                                + (int) Math.pow(midSquare, 2) * 3;
                    } else {
                        intermediateMagicSquare[row][column] = firstMagicSquare[row - midSquare][column - midSquare]
                                + (int) Math.pow(midSquare, 2);
                    }
                }
            }
        }
        return intermediateMagicSquare;
    }

    /*
    Перестановка местами определенных чисел первого и второго столбца
    промежуточнго магического квадрата
     */
    private static int[][] getIntermediateMagicSquare(int squareBase) {
        int[][] intermediateMagicSquare = getFirstIntermediateMagicSquare(squareBase);
        int stepCounter = 0;
        int tempElement;

        while (stepCounter < (squareBase / 2)) {
            if ((stepCounter == 0) || (stepCounter == (squareBase / 2 - 1))) {
                tempElement = intermediateMagicSquare[stepCounter][0];
                intermediateMagicSquare[stepCounter][0] = intermediateMagicSquare[stepCounter + squareBase / 2][0];
                intermediateMagicSquare[stepCounter + squareBase / 2][0] = tempElement;
            } else {
                tempElement = intermediateMagicSquare[stepCounter][1];
                intermediateMagicSquare[stepCounter][1] = intermediateMagicSquare[stepCounter + squareBase / 2][1];
                intermediateMagicSquare[stepCounter + squareBase / 2][1] = tempElement;
            }
            stepCounter++;
        }
        return intermediateMagicSquare;
    }

    /*
    Перестановка местами определенных столбцов промежуточного магического квадрата
    и построение результирующего магического квадрата чётно-нечётного порядка
     */
    private static int[][] getEvenOddMagicSquare(int squareBase) {
        int[][] evenOddMagicSquare = getIntermediateMagicSquare(squareBase);
        int swapColumnCount = squareBase / 2 - 3;
        int startSwapColumnIndex = (squareBase - swapColumnCount) / 2;
        int endSwapColumnIndex = (squareBase + swapColumnCount) / 2;
        int tempElement;

        if (swapColumnCount > 0) {
            for (int row = 0; row < (squareBase / 2); row++) {
                for (int column = startSwapColumnIndex; column < endSwapColumnIndex; column++) {
                    tempElement = evenOddMagicSquare[row][column];
                    evenOddMagicSquare[row][column] = evenOddMagicSquare[row + squareBase / 2][column];
                    evenOddMagicSquare[row + squareBase / 2][column] = tempElement;
                }
            }
            return evenOddMagicSquare;
        } else {
            return evenOddMagicSquare;
        }
    }

    public static int[][] getMagicSquare(int squareBase) {
        if (squareBase % 2 != 0) {
            return getOddMagicSquare(squareBase);
        } else if (squareBase % 4 == 0) {
            return getEvenEvenMagicSquare(squareBase);
        } else {
            return getEvenOddMagicSquare(squareBase);
        }
    }

    public static void printResultMatrix(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
        System.out.println();
    }


    //----- check result -----
    public static void main(String[] args) {
        printResultMatrix(getMagicSquare(5));
        printResultMatrix(getMagicSquare(10));
        printResultMatrix(getMagicSquare(12));
    }
}
