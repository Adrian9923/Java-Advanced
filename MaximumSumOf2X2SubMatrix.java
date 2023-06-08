package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxSum = Integer.MIN_VALUE;

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = initialiseMatrix(scanner, matrixDimensions);
        int[][] result = new int[2][2];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    result[0][0] = matrix[row][col];
                    result[0][1] = matrix[row][col + 1];
                    result[1][0] = matrix[row + 1][col];
                    result[1][1] = matrix[row + 1][col + 1];
                }
            }
        }
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }

    private static int[][] initialiseMatrix(Scanner scanner, int[] matrixDimensions) {
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = array;
        }
        return matrix;
    }
}
