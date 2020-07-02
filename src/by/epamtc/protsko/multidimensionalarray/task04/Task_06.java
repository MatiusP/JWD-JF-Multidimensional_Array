package by.epamtc.protsko.multidimensionalarray.task04;

import java.util.ArrayList;
import java.util.List;

public class Task_06 {
    private static List<Integer> diagonalElements = new ArrayList<>();

    //ПОСТРОЕНИЕ НЕЧЁТНОГО МАГИЧЕСКОГО КВАДРАТА
    private static int[][] oddMagicSquare(int squareBase) {

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
    private static int[][] initialFillingOfSquare(int squareBase) {
        int currentNumber = 0;
        int[][] initialSquare = new int[squareBase][squareBase];

        for (int i = 0; i < initialSquare.length; i++) {
            for (int j = 0; j < initialSquare[i].length; j++) {
                initialSquare[i][j] = ++currentNumber;
            }
        }
        return initialSquare;
    }

    /*
    Поиск координат диагональных элементов в исходной матрице,
    а также во всех вписанных матрицах порядка 4х4 (координаты диагональных
    элементов по краям матриц)
    */
    private static int[] coordinatesOfEdgesOfSquare(int squareBase) {
        int[] coordinatesOfEdges = new int[squareBase / 2];
        coordinatesOfEdges[0] = 1;

        for (int i = 1; i < coordinatesOfEdges.length; i++) {
            if (i % 2 == 0) {
                coordinatesOfEdges[i] = coordinatesOfEdges[i - 1] + 1;
            } else {
                coordinatesOfEdges[i] = coordinatesOfEdges[i - 1] + 3;
            }
        }
        return coordinatesOfEdges;
    }

    /*
    Поиск координат диагональных элементов в исходной матрице,
    а также во всех вписанных матрицах порядка 4х4 (координаты диагональных
    элементов в середине матриц)
    */
    private static int[] coordinatesOfMiddleOfSquare(int squareBase) {
        int[] coordinatesOfMiddle = new int[squareBase / 2];
        coordinatesOfMiddle[0] = 2;

        for (int i = 1; i < coordinatesOfMiddle.length; i++) {
            if (i % 2 == 0) {
                coordinatesOfMiddle[i] = coordinatesOfMiddle[i - 1] + 3;
            } else {
                coordinatesOfMiddle[i] = coordinatesOfMiddle[i - 1] + 1;
            }
        }
        return coordinatesOfMiddle;
    }

    /*
    Удаление из исходной матрицы, инициализированной значениями в порядке естественного
    возрастания, значений, расположенных по диагоналям (в том числе и по диагоналям квадратов 4х4)
     */
    private static int[][] initialSquareWithoutDiagonalElements(int squareBase) {
        int[][] initialSquareWithoutDiagonalElements = initialFillingOfSquare(squareBase);
        int stepCounter = 1;
        int[] coordinatesOfEdgesOfSquare = coordinatesOfEdgesOfSquare(squareBase);
        int[] coordinatesOfMiddleOfSquare = coordinatesOfMiddleOfSquare(squareBase);

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
    private static int[][] evenEvenMagicSquare(int squareBase) {
        int[][] evenEvenMagicSquare = initialSquareWithoutDiagonalElements(squareBase);
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
    private static int[][] firstIntermediateMagicSquare(int squareBase) {
        int[][] intermediateMagicSquare = new int[squareBase][squareBase];
        int midSquare = squareBase / 2;
        int[][] firstMagicSquare = oddMagicSquare(midSquare);

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
    private static int[][] intermediateMagicSquare(int squareBase) {
        int[][] intermediateMagicSquare = firstIntermediateMagicSquare(squareBase);
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
    private static int[][] evenOddMagicSquare(int squareBase) {
        int[][] evenOddMagicSquare = intermediateMagicSquare(squareBase);
        int swapColumnCount = (squareBase / 2) - 3;
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
        }
        return evenOddMagicSquare;
    }

    public static int[][] magicSquare(int squareBase) {
        if (squareBase % 2 != 0) {
            return oddMagicSquare(squareBase);
        } else if (squareBase % 4 == 0) {
            return evenEvenMagicSquare(squareBase);
        } else {
            return evenOddMagicSquare(squareBase);
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
        printResultMatrix(magicSquare(5));
        printResultMatrix(magicSquare(8));
        printResultMatrix(magicSquare(10));
    }
}
