package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfAllElementsOfAMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowsCount = matrixDimensions[0];
        int columnsCount = matrixDimensions[1];
        int[][] matrix = initialiseMatrix(scanner, matrixDimensions);

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix[rows].length; columns++) {
                sum += matrix[rows][columns];
            }
        }
        System.out.println(rowsCount); // or System.out.println(matrix.length);
        System.out.println(columnsCount); // or System.out.println(matrix[0].length);
        System.out.println(sum);
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
