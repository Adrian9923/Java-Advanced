package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biggestSum = Integer.MIN_VALUE;

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = initialiseMatrix(scanner, matrixDimensions);
        int[][] result = new int[3][3];
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > biggestSum) {
                    biggestSum = sum;
                    result[0][0] = matrix[row][col];
                    result[0][1] = matrix[row][col + 1];
                    result[0][2] = matrix[row][col + 2];
                    result[1][0] = matrix[row + 1][col];
                    result[1][1] = matrix[row + 1][col + 1];
                    result[1][2] = matrix[row + 1][col + 2];
                    result[2][0] = matrix[row + 2][col];
                    result[2][1] = matrix[row + 2][col + 1];
                    result[2][2] = matrix[row + 2][col + 2];
                }
            }
        }
        System.out.println("Sum = " + biggestSum);
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] initialiseMatrix(Scanner scanner, int[] matrixDimensions) {
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
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
