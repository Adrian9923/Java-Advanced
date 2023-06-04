package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = array;
        }
        for (int i = 0; i < dimension; i++) {
            primaryDiagonal += matrix[i][i];
        }
        for (int i = 0; i < dimension; i++) {
            secondaryDiagonal += matrix[i][matrix[i].length - 1 - i];
        }
        int difference = primaryDiagonal - secondaryDiagonal;
        System.out.println(Math.abs(difference));
    }
}
