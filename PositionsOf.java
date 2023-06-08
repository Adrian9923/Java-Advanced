package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = initialiseMatrix(scanner, matrixDimensions);

        boolean isFound = false;
        int number = Integer.parseInt(scanner.nextLine());
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix[rows].length; columns++) {
                if (matrix[rows][columns] == number) {
                    isFound = true;
                    System.out.printf("%d %d\n",rows,columns);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }


    private static int[][] initialiseMatrix(Scanner scanner, int[] matrixDimensions) {
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = array;
        }
        return matrix;
    }
}
