package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstMatrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] firstMatrix = initializeMatrix(scanner, firstMatrixDimensions);

        int[] secondMatrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] secondMatrix = initializeMatrix(scanner, secondMatrixDimensions);

        String output;
        if (matricesAreEqual(firstMatrix,secondMatrix)) {
            output = "equal";
        }else {
            output = "not equal";
        }
        System.out.println(output);
    }


    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int columns = 0; columns < firstMatrix[row].length; columns++) {
                if (firstMatrix[row][columns] != secondMatrix[row][columns]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] initializeMatrix(Scanner scanner, int[] firstMatrixDimensions) {
        int rows = firstMatrixDimensions[0];
        int columns = firstMatrixDimensions[1];

        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = array;
        }
        return matrix;
    }

}
