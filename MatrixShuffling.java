package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[][] matrix = initialiseMatrix(scanner, matrixDimensions);

        String command = scanner.nextLine();
        while (!command.equals("END")) {


            String[] cmdParts = command.split(" ");
            if (cmdParts.length != 5) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            int row1 = Integer.parseInt(cmdParts[1]);
            int col1 = Integer.parseInt(cmdParts[2]);
            int row2 = Integer.parseInt(cmdParts[3]);
            int col2 = Integer.parseInt(cmdParts[4]);

            if (row1 > matrix.length || row2 > matrix.length || col1 > matrix[row1].length || col2 > matrix[row2].length) {
                System.out.println("Invalid input!");
            }else {
                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            }
            command = scanner.nextLine();
        }
    }

    private static String[][] initialiseMatrix(Scanner scanner, int[] matrixDimensions) {
        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .toArray(String[]::new);
            matrix[i] = array;
        }
        return matrix;
    }
}
